package duke;

import java.io.IOException;
import java.util.Collections;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * An example of a custom control using FXML.
 * This control represents a dialog box consisting of an ImageView to represent the speaker's face and a label
 * containing text from the speaker.
 */
public class DialogBox extends HBox {
    @FXML
    private Label dialog;
    @FXML
    private ImageView displayPicture;

    private DialogBox(String text, Image img) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(MainWindow.class.getResource("/view/DialogBox.fxml"));
            fxmlLoader.setController(this);
            fxmlLoader.setRoot(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dialog.setText(text);
        dialog.setFont(Font.font("Roboto", 12));
        displayPicture.setImage(img);
    }

    /**
     * Flips the dialog box such that the ImageView is on the left and text on the right.
     */
    private void flip() {
        ObservableList<Node> tmp = FXCollections.observableArrayList(this.getChildren());
        Collections.reverse(tmp);
        getChildren().setAll(tmp);
        setAlignment(Pos.TOP_LEFT);
    }
    //@@author jiayushe-reused
    //Reused from https://github.com/jiayushe/duke/blob/master/src/main/java/duke/DialogBox.java with minor modifications
    public static DialogBox getUserDialog(String text, Image img) {
        DialogBox dialogbox = new DialogBox(text, img);
        BackgroundFill backFill = new BackgroundFill(
                Color.web("#A7DDDC"),
                new CornerRadii(20),
                new Insets(5, 1, 5, 1)
        );
        Background background = new Background(backFill);
        dialogbox.setBackground(background);
        return dialogbox;
    }

    public static DialogBox getDukeDialog(String text, Image img) {
        var db = new DialogBox(text, img);
        BackgroundFill backFill = new BackgroundFill(
                Color.web("#A4BCE0"),
                new CornerRadii(20),
                new Insets(5, 1, 5, 1)
        );
        Background background = new Background(backFill);
        db.setBackground(background);
        db.flip();
        return db;
    }
    //@@author
}
