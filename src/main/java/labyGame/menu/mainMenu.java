package labyGame.menu;

//import labyGame.sauvegarde.Save;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;

/**
 * main class
 * open the menu window
 * */
public class mainMenu extends Application {

    GameMenu gameMenu;

    @Override
    public void start(Stage stage) throws Exception {

        Pane root = new Pane();
        root.setPrefSize(1332, 850);

        InputStream is = Files.newInputStream(Paths.get("doc/images/wallpaper/menu_wallpaper.jpg"));
        Image img = new Image(is);
        is.close();

        ImageView imgView = new ImageView(img);
        imgView.setFitWidth(1332);
        imgView.setFitHeight(850);

        gameMenu = new GameMenu();

        root.getChildren().addAll(imgView, gameMenu);

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }

    /**
     * Class to creat menu buttons
     * */
    private static class MenuButton extends StackPane {

        Text txt;

        public MenuButton(String name) {

            txt = new Text(name);
            txt.setFont(this.txt.getFont().font(20));
            txt.setFill(Color.rgb(72, 184, 250));

            Rectangle r = new Rectangle(250, 30);
            r.setOpacity(0.6);
            r.setFill(Color.WHITE);
            r.setEffect(new GaussianBlur(3.5));

            setAlignment(Pos.CENTER);
            setRotate(-0.5);
            getChildren().addAll(r, txt);

            setOnMouseEntered(event -> {
                r.setTranslateX(10);
                txt.setTranslateX(10);
                r.setFill(Color.rgb(124, 212, 52));
                txt.setFill(Color.WHITE);
            });

            setOnMouseExited(event -> {
                r.setTranslateX(0);
                txt.setTranslateX(0);
                r.setFill(Color.WHITE);
                txt.setFill(Color.rgb(72, 184, 250));
            });

            DropShadow drop = new DropShadow(50, Color.rgb(174, 174, 179));
            drop.setInput(new Glow());

            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));

        }
    }

    /**
     * class to creat the menus and to choice actions link to the buttons
     * */
    private static class GameMenu extends Parent {

        public GameMenu() {

            VBox menu0 = new VBox(15);
            VBox menu1 = new VBox(15);

            menu0.setTranslateX(550);
            menu0.setTranslateY(200);
            menu1.setTranslateX(550);
            menu1.setTranslateY(200);

            final int offset = 200;

            menu1.setTranslateX(offset);

            MenuButton btnCtn = new MenuButton("Continue");
            btnCtn.setOnMouseClicked(event -> {
                FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
                ft.setFromValue(1);
                ft.setToValue(0);
                ft.setOnFinished(evt -> this.setVisible(false));
                ft.play();
                //ft.Save.recuperationSaveHero();
            });

            MenuButton btnNG = new MenuButton("New Game");
            //btnNG.setOnMouseClicked(event -> {
            //FadeTransition ft = new FadeTransition(Duration.seconds(0.5), this);
            //ft.setFromValue(1);
            //ft.setToValue(0);
            //ft.setOnFinished(evt -> this.setVisible(false));
            //ft.play();
            //});

            MenuButton btnOpt = new MenuButton("Options");
            btnOpt.setOnMouseClicked(event -> {
                getChildren().add(menu1);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu0);
                tt.setToX(menu0.getTranslateX()+offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu1);
                tt1.setToX(menu0.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> getChildren().remove(menu0));
            });

            MenuButton btnE = new MenuButton("Exit");
            btnE.setOnMouseClicked(event -> System.exit(0));

            MenuButton btnBk = new MenuButton("Back");
            btnBk.setOnMouseClicked(event -> {
                getChildren().add(menu0);

                TranslateTransition tt = new TranslateTransition(Duration.seconds(0.25), menu1);
                tt.setToX(menu1.getTranslateX()+offset);

                TranslateTransition tt1 = new TranslateTransition(Duration.seconds(0.5), menu0);
                tt1.setToX(menu1.getTranslateX());

                tt.play();
                tt1.play();

                tt.setOnFinished(evt -> getChildren().remove(menu1));
            });

            MenuButton btnS = new MenuButton("Sound");
            //btnS.setOnMouseClicked(event -> {
            //TODO
            //});

            menu0.getChildren().addAll(btnCtn, btnNG, btnOpt, btnE);
            menu1.getChildren().addAll(btnBk,btnS);

            Rectangle r = new Rectangle(1332, 850);
            r.setFill(Color.GREY);
            r.setOpacity(0.4);

            getChildren().addAll(r, menu0);

        }

    }

    public static void main(String[] args) {
        launch(args);
    }
}