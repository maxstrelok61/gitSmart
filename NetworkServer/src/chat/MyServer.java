package chat;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import chat.handler.*;
import chat.auth.*;

public class MyServer {

    private final ServerSocket serverSocket;
    private final AuthService authService;
    private final List<ClientHandler> clients = new ArrayList<>();
    public Logger log = Logger.getLogger(MyServer.class.getName());



    public MyServer(int port) throws IOException, SQLException, ClassNotFoundException {
        this.serverSocket = new ServerSocket(port);
        this.authService = new BaseAuthService();
    }


    public void start() throws IOException {
        System.out.println("Сервер запущен!");
        log.info("Сервер запущен!");

        try {
            while (true) {
                waitAndProcessNewClientConnection();
            }
        } catch (IOException e) {
            System.out.println("Ошибка создания нового подключения");
            log.warning("Ошибка создания нового подключения");
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }

    private void waitAndProcessNewClientConnection() throws IOException {
        System.out.println("Ожидание пользователя...");
        log.info("Ожидание пользователя...");
        Socket clientSocket = serverSocket.accept();
        System.out.println("Клиент подключился!");
        log.info("Клиент подключился!");
        processClientConnection(clientSocket);
    }

    private void processClientConnection(Socket clientSocket) throws IOException {
        ClientHandler clientHandler = new ClientHandler(this, clientSocket);
        clientHandler.handle();
    }

    public AuthService getAuthService() {
        return authService;
    }

    public synchronized boolean isUsernameBusy(String clientUsername) {
        for (ClientHandler client : clients) {
            if (client.getClientUsername().equals(clientUsername)) {
               return true;
            }
        }
        return false;
    }

    public synchronized void subscribe(ClientHandler clientHandler) {
        clients.add(clientHandler);
    }

    public synchronized void unSubscribe(ClientHandler clientHandler) {
        clients.remove(clientHandler);
    }

    public synchronized void broadcastMessage(String message, ClientHandler sender, boolean isServerInfoMsg) throws IOException {
        for (ClientHandler client : clients) {
            if (client == sender) {
                continue;
            }
            client.sendMessage(isServerInfoMsg ? null : sender.getClientUsername(), message);

        }
    }

    public synchronized void sendPrivateMessage(ClientHandler sender, String recipient, String privateMessage) throws IOException {
        for (ClientHandler client : clients) {
            if (client.getClientUsername().equals(recipient)) {
                client.sendMessage(sender.getClientUsername(), privateMessage);
            }
        }
    }
}
