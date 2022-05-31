package view;

import enums.Statics;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.magicArt.MagicArt;
import model.magicArtInstances.artObjects.AliveObject;
import model.magicArtInstances.artObjects.Bullet;
import model.magicArtInstances.artObjects.CupHead;
import model.objects.ArtObject;
import model.magicArt.MovingArt;
import model.magicArt.SoundOnArt;
import view.fx.FxStaticSaves;
import view.images.MagicArtsLoader;

public class MainFx extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        AliveObject aliveObject = new AliveObject(1800, 500, -Statics.flappyBirdsSpeed, 0, 0, 0,
                MagicArtsLoader.FLAPPY_BIRD_PINK_FLY, 200);
        aliveObject.getMagicArtsHandler().addMagicArt(MagicArtsLoader.FLAPPY_BIRD_YELLOW_DEATH);


        CupHead cupHead = new CupHead(3);


        AnchorPane anchorPane = new AnchorPane();
        Canvas canvas = new Canvas(1920,1080);
        GraphicsContext context = canvas.getGraphicsContext2D();
        anchorPane.getChildren().add(canvas);
        Scene temp = new Scene(anchorPane);
        stage.setScene(temp);
        inputHandler(temp);


        Media x = new Media ((MainFx.class.getResource("sounds/1. Halsey - Ashley (320).mp3").toString()));
        MediaPlayer p = new MediaPlayer(x);

        AnimationTimer game  = new AnimationTimer() {
            @Override
            public void handle(long nanotime) {
                context.setFill(Color.WHITE);
                context.fillRect(0,0,1920,1080);
                for (Bullet bullet: Bullet.BULLETS) bullet.print(context);
                cupHead.print(context);
                aliveObject.print(context);
                aliveObject.reduceHP(1);
            }
        };

        MousEIn
        game.start();

        stage.setWidth(1920);
        stage.setHeight(1080);
        stage.setFullScreen(true);
        stage.setResizable(false);
        stage.show();
    }

    public void run() {
        launch();
    }

    public void inputHandler (Scene scene) {
        scene.setOnKeyPressed(
                (KeyEvent event) -> {
                    String keyName = event.getCode().name();
                    if (keyName.equals("W")) FxStaticSaves.KEY_W = true;
                    if (keyName.equals("A")) FxStaticSaves.KEY_A = true;
                    if (keyName.equals("S")) FxStaticSaves.KEY_S = true;
                    if (keyName.equals("D")) FxStaticSaves.KEY_D = true;
                    if (keyName.equals("SPACE")) FxStaticSaves.KEY_SPACE = true;
                    if (keyName.equals("TAB")) FxStaticSaves.KEY_TAB = !FxStaticSaves.KEY_TAB;
                }
        );
        scene.setOnKeyReleased(
                (KeyEvent event) -> {
                    String keyName = event.getCode().name();
                    if (keyName.equals("W")) FxStaticSaves.KEY_W = false;
                    if (keyName.equals("A")) FxStaticSaves.KEY_A = false;
                    if (keyName.equals("S")) FxStaticSaves.KEY_S = false;
                    if (keyName.equals("D")) FxStaticSaves.KEY_D = false;
                    if (keyName.equals("SPACE")) FxStaticSaves.KEY_SPACE = false;
                }
        );
    }
}
