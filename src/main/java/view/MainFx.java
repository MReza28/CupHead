package view;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.animatedObjects.notMovingObject;

import java.io.SyncFailedException;

public class MainFx extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        /*notMovingObject boss = new notMovingObject(50, 50, 10,
                MainFx.class.getResource("images/bossFly/").toExternalForm());

        AnchorPane anchorPane = new AnchorPane();
        Canvas canvas = new Canvas(1280,720);
        GraphicsContext context = canvas.getGraphicsContext2D();
        anchorPane.getChildren().add(canvas);
        context.setFill(Color.RED);
        context.fillRect(50,50 , 500 ,500);
        Scene temp = new Scene(anchorPane);
        stage.setScene(temp);

        AnimationTimer game  = new AnimationTimer() {
            int s = 0;
            @Override
            public void handle(long nanotime) {
                if (s < 6) {
                    s++;
                    return;
                }
                s%=6;
                context.setFill(Color.WHITE);
                context.fillRect(0,0,1280,720);
                context.save();

                context.translate(50, 50);
                context.drawImage(boss.getNextFrame(), 0, 0);

                context.restore();
                System.gc();
            }
        };

        game.start();

        stage.setHeight(720);
        stage.setWidth(1280);
        context.clearRect(0,0,1280,720);
        stage.show();*/

    }

    public void run() {
        launch();
    }
}
