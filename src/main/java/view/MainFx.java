package view;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.magicArt.MagicArt;
import model.objects.ArtObject;
import model.magicArt.MovingArt;
import model.magicArt.SoundOnArt;

public class MainFx extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        MovingArt oneArt = new MovingArt(MainFx.class.getResource("images/purple/").toExternalForm(), 4, 6, true, true);
        MovingArt two = new MovingArt(MainFx.class.getResource("images/BossShoot/").toExternalForm(), 12);
        SoundOnArt tempp = new SoundOnArt();
        MagicArt magicArt = new MagicArt(oneArt, null);
        MagicArt magicArt1 = new MagicArt(two, null);

        ArtObject[] artsObject = new ArtObject[2000];
        for (int i = 0; i < 2000; i++) {
            artsObject[i] = new ArtObject(78,60,0,0, 0, 0, magicArt);
            artsObject[i].getMagicArtsHandler().addMagicArt(magicArt1);
        }
        artsObject[0].getMagicArtsHandler().playMagicArt(0);

        ArtObject artObject = new ArtObject(100, 100, 0.2, 0, magicArt);
        artObject.getMagicArtsHandler().addMagicArt(magicArt1);

        AnchorPane anchorPane = new AnchorPane();
        Canvas canvas = new Canvas(1280,720);
        GraphicsContext context = canvas.getGraphicsContext2D();
        anchorPane.getChildren().add(canvas);
        context.setFill(Color.MINTCREAM);
        context.fillRect(50,50 , 500 ,500);
        Scene temp = new Scene(anchorPane);
        stage.setScene(temp);

        Media x = new Media ((MainFx.class.getResource("sounds/1. Halsey - Ashley (320).mp3").toString()));
        MediaPlayer p = new MediaPlayer(x);
        //p.play();

        AnimationTimer game  = new AnimationTimer() {
            int s = 0;
            @Override
            public void handle(long nanotime) {
                context.setFill(Color.WHITE);
                context.fillRect(0,0,1280,720);
                //artObject.print(context);
                for (int i = 0; i < 1; i++) {
                    artsObject[i].print(context);
                }
                s++;
                if (s == 120)
                {
                    MediaPlayer sss = new MediaPlayer(x);
                    sss.play();
                }
            }
        };

        game.start();

        //game.start();

        stage.setHeight(720);
        stage.setWidth(1280);
        stage.show();

    }

    public void run() {
        launch();
    }
}
