package duke;

import java.io.IOException;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 * A GUI for Duke using FXML.
 */
public class Main extends Application {
    private static MainWindow window;
    private Duke duke = new Duke();

    @SuppressWarnings("checkstyle:CommentsIndentation")
    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/MainWindow.fxml"));
            AnchorPane ap = fxmlLoader.load();
            Scene scene = new Scene(ap);
            stage.setScene(scene);
            fxmlLoader.<MainWindow>getController().setDuke(duke);
            window = fxmlLoader.getController();
            stage.show();
            duke.welcome();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static MainWindow getWindow() {
        return window;
    }

    public static void closeWindow() {
        Platform.exit();
    }
}
