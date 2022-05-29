package model.objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.PositionVertex;
import model.magicArt.MagicArt;
import model.magicArt.MagicArtsHandler;

import java.util.Random;

public class ArtObject {
    private PositionVertex place;
    private PositionVertex velocity;
    private PositionVertex acceleration;

    private MagicArtsHandler magicArtsHandler;

    private double resize;

    private Image currentImage;


    //CONSTRUCTORS
    private ArtObject (MagicArt magicArt) {
        place = new PositionVertex(0, 0);
        velocity = new PositionVertex(0, 0);
        acceleration = new PositionVertex(0, 0);
        this.magicArtsHandler = new MagicArtsHandler(magicArt);
        this.resize = 1;
    }
    public ArtObject (PositionVertex place, MagicArt magicArt) {
        this(magicArt);
        this.place = place;
    }
    public ArtObject (double fromLeft, double fromTop, MagicArt magicArt) {
        this(magicArt);
        this.place.addPositionVertex(fromLeft, fromTop);
    }
    public ArtObject (PositionVertex place, PositionVertex velocity, MagicArt magicArt) {
        this(place, magicArt);
        this.velocity = velocity;
    }
    public ArtObject (double fromLeft, double fromTop, double velocityFromLeft, double velocityFromTop, MagicArt magicArt) {
        this(fromLeft, fromTop, magicArt);
        this.velocity.addPositionVertex(velocityFromLeft, velocityFromTop);
    }
    public ArtObject (double fromLeft, double fromTop, double velocityFromLeft, double velocityFromTop,
                      double accelerationFromLeft, double accelerationFromTop, MagicArt magicArt) {
        this(fromLeft, fromTop, velocityFromLeft, velocityFromTop, magicArt);
        this.acceleration.addPositionVertex(accelerationFromLeft, accelerationFromTop);
    }
    ////CONSTRUCTORS

    //GETTERS
    public PositionVertex getPlace() {
        return place;
    }

    public PositionVertex getVelocity() {
        return velocity;
    }

    public PositionVertex getAcceleration() {
        return acceleration;
    }

    public MagicArtsHandler getMagicArtsHandler() {
        return magicArtsHandler;
    }
    //TODO get from top and from left here
    ////GETTERS

    //SETTERS
    public void setResize(double resize) {
        this.resize = resize;
    }
    //TODO set velocity and place
    ////SETTERS


    //HANDLING OUTPUT
    private void updateArtObject () {
        updateObjectMagicArt();
        updateObjectPlace();
    }
    private void updateObjectMagicArt () {
        this.currentImage = magicArtsHandler.getFrame();
    }
    protected void updateObjectPlace () {
        this.velocity.addPositionVertex(acceleration);
        this.place.addPositionVertex(velocity);
    }

    public void print (GraphicsContext context) {
        updateArtObject();
        context.save();
        context.setEffect(magicArtsHandler.getEffect());
        context.translate(this.getPlace().getFromLeft() ,this.getPlace().getFromTop());
        context.drawImage(currentImage, 0, 0,
                currentImage.getWidth() * resize, currentImage.getHeight() * resize);

        context.restore();
    }
    ////Handling Output
}
