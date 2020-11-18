package sample.Controllers;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class MainChat {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BorderPane BorderPane;

    @FXML
    private MenuBar topMenu;

    @FXML
    private Menu topMenu_Contacts;

    @FXML
    private MenuItem topMenu_Contacts_SaveFile;

    @FXML
    private MenuItem topMenu_Contacts_LoadFile;

    @FXML
    private Menu topMenu_Settings;

    @FXML
    private Menu topMenu_Info;

    @FXML
    private MenuItem menuBar_Info;

    @FXML
    private ListView<?> listViewContacts;

    @FXML
    private ListView<?> listViewChat;

    @FXML
    private MenuItem contextMenu_Exit;

    @FXML
    private TextField fieldMessege;

    @FXML
    private Button buttonSendMessage;

    private final String pathToForm_Info = "../Views/Info.fxml";// путь до окна информации

    @FXML
    void buttonSendMessage_Click(ActionEvent event) {
        buttonSendMessage_Click_main();
    }

    @FXML
    void menuBar_menuBar_Info_Click(ActionEvent event) throws IOException {
        showWindowInfo();
    }

    @FXML
    void onKeyEntrer(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            buttonSendMessage_Click_main();
        }
    }

    @FXML
    void mouseClick_contextMenu_Exit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void initialize() {

    }

    private void buttonSendMessage_Click_main(){
        if(!fieldMessege.getText().isBlank()) {

            ObservableList items = listViewChat.getItems();
            items.add(fieldMessege.getText());
            listViewChat.setItems(items);

            fieldMessege.setText("");
        }
    }
    //Метод вывода информационного окна
    private void showWindowInfo (){
        BorderPane.setDisable(true);// Блокируем основное окно
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(pathToForm_Info));

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setResizable(false);

        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                BorderPane.setDisable(false);//Разблокируем основное окно
                stage.close();//Закрываем информационное окно
                event.consume();
            }
        });
        stage.setScene(new Scene(root));
        stage.showAndWait();

    }

}

