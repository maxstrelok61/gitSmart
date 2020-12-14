package chat.handler;

import chat.MyServer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
//import java.util.Timer;
import javax.swing.Timer;

import chat.WorkFiles.Data_File.WorkFileLinesMod;
import chat.WorkFiles.WorkFileLines;
import chat.auth.*;
import chat.*;

public class ClientHandler {
    private WorkFileLines logFile;

    private static final String AUTH_CMD_PREFIX = "/auth";
    private static final String AUTHOK_CMD_PREFIX = "/authok";
    private static final String AUTHERR_CMD_PREFIX = "/autherr";
    private static final String PRIVATE_MSG_CMD_PREFIX = "/w";
    private static final String CLIENT_MSG_CMD_PREFIX = "/clientMsg";
    private static final String SERVER_MSG_CMD_PREFIX = "/serverMsg";
    private static final String END_CMD = "/end";

    private final MyServer myServer;
    private final Socket clientSocket;
    private DataInputStream io;
    private DataOutputStream out;
    private String clientUsername;

    private Timer timer1;
    private boolean checkAuthForConnection = false;
    private final int limitTime = 120;





    public ClientHandler(MyServer myServer, Socket clientSocket) {
        this.myServer = myServer;
        this.clientSocket = clientSocket;
    }

    public void handle() throws IOException {

        timer1 = new Timer(1000 * limitTime, new ActionListener(
        ) {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!checkAuthForConnection){
                    try {
                        clientSocket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        timer1.start();

//        new Thread(() -> {
//            if(!checkAuthForConnection) {
//                System.out.println(myServer.timer1.toString());
//                System.out.println(new Timer().toString());
//            }else return;
//        }).start();

        io = new DataInputStream(clientSocket.getInputStream());
        out = new DataOutputStream(clientSocket.getOutputStream());


        new Thread(() -> {
            try {
                authentication();
                readMessage();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }).start();

    }

    private void authentication() throws IOException {
        String message = io.readUTF();
        while (true) {
            if (message.startsWith(AUTH_CMD_PREFIX)) {
                String[] parts = message.split("\\s+", 3);
                String login = parts[1];
                String password = parts[2];

                AuthService authService = myServer.getAuthService();
                this.clientUsername = authService.getUsernameByLoginAndPassword(login, password);
                if (clientUsername != null) {
                    if (myServer.isUsernameBusy(clientUsername)) {
                        out.writeUTF(AUTHERR_CMD_PREFIX + " Логин уже используется");
                    }

                    out.writeUTF(AUTHOK_CMD_PREFIX + " " + clientUsername);
                    myServer.broadcastMessage(String.format(">>> %s присоединился к чату", clientUsername), this, true);
                    myServer.subscribe(this);
                    checkAuthForConnection = true;
                    logFile = new WorkFileLines("history_" + clientUsername + ".txt");
                    logFile.setModWriter(WorkFileLinesMod.DOWN);

                    break;
                } else {
                    out.writeUTF(AUTHERR_CMD_PREFIX + " Логин или пароль не соответствуют действительности");
                }
            } else {
                out.writeUTF(AUTHERR_CMD_PREFIX + " Ошибка авторизации");
            }
        }
    }

    private void readMessage() throws IOException {
            while (true) {
                String message = io.readUTF();
                System.out.println("message | " + clientUsername + ": " + message);
                if (message.startsWith(END_CMD)) {
                    return;
                } else if (message.startsWith(PRIVATE_MSG_CMD_PREFIX)) {
                    String[] parts = message.split("\\s+", 3);
                    String recipient = parts[1];
                    String privateMessage = parts[2];
                    myServer.sendPrivateMessage(this, recipient, privateMessage);
                    logFile.writerInFile(message);
                } else {
                    myServer.broadcastMessage(message, this, false);
                }
            }
    }

    public String getClientUsername() {
        return clientUsername;
    }

    public void sendMessage(String sender, String message) throws IOException {
        if (sender == null) {
            out.writeUTF(String.format("%s %s", SERVER_MSG_CMD_PREFIX, message));
        } else {
            out.writeUTF(String.format("%s %s %s", CLIENT_MSG_CMD_PREFIX, sender, message));
        }
    }
}
