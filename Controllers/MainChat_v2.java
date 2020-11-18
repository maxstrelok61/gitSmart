package sample.Controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.property.DoubleProperty;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.OverrunStyle;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class MainChat_v2 {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label labelFIO;

    @FXML
    private VBox vBoxContacts;

    @FXML
    private VBox vBoxFieldMessages;

    @FXML
    private Button buttonAttach;

    @FXML
    private TextField fieldMessage;

    @FXML
    private Button buttonMessageSend;

    @FXML
    void initialize() {
        HBox hbox = new HBox();
        hbox.prefHeight(48.0);
        hbox.prefWidth(246.0);
        hbox.styleProperty().set("-fx-background-color: #FFFFFF;");

        VBox vbox = new VBox();
        vbox.setOpaqueInsets(new Insets(4.0, 4.0, 4.0, 4.0));


        ImageView iv = new ImageView();
        iv.fitHeightProperty().setValue(36.0);
        iv.fitWidthProperty().setValue(39.0);
        iv.pickOnBoundsProperty().set(true);
        iv.preserveRatioProperty().set(true);
      //  iv.setImage(new Image(""));


        Label lab = new Label();
        lab.prefHeight(44.0);
        lab.prefWidth(180.0);
        lab.setText("Фисташкин Александр Сергеевич");
        lab.wrapTextProperty().set(true);
        lab.setFont(new Font(13.0));

        Label lab2 = new Label();
        lab2.setAlignment(Pos.CENTER);
        lab2.styleProperty().set("-fx-background-color: #b10404;");
        lab2.setText("1");
        lab2.setTextAlignment(TextAlignment.CENTER);
        lab2.setTextFill(Paint.valueOf("WHITE"));
        lab2.setTextOverrun(OverrunStyle.CENTER_WORD_ELLIPSIS);

        vbox.getChildren().add(iv);
        vbox.getChildren().add(lab);
        vbox.getChildren().add(lab2);

        hbox.getChildren().add(vbox);

        vBoxContacts.getChildren().add(hbox);




    }
}
