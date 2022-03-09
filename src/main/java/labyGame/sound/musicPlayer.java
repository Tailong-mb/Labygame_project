package labyGame.sound;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.IOException;

public class musicPlayer extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        Pane root = new Pane();
        root.setPrefSize(1332, 850);


        Media media = new Media(new File("doc/music/sound/GamerInstincts.wav").toURI().toString());

        MediaPlayer mp = new MediaPlayer(media);

        mp.setAutoPlay(true);

        primaryStage.show();

    }
}
