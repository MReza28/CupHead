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

public class MainFx extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        notMovingObject boss = new notMovingObject(300, 700, 10,
                MainFx.class.getResource("images/bossFly/").toExternalForm());
        notMovingObject bosss = new notMovingObject(100, 200, 4,
                MainFx.class.getResource("images/purple/").toExternalForm(), 2, 4);

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
                context.setFill(Color.WHITE);
                context.fillRect(0,0,1280,720);
                boss.print(context);
                bosss.print(context);
                System.gc();
            }
        };

        game.start();

        stage.setHeight(720);
        stage.setWidth(1280);
        stage.show();

    }

    public void run() {
        launch();
    }
}
