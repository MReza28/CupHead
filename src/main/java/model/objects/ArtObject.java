package model.objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import model.PositionVertex;
import model.magicArt.MagicArt;
import model.magicArt.MagicArtsHandler;

public class ArtObject {
    private boolean isVisible;
    private boolean isDead;

    private PositionVertex place;
    private PositionVertex velocity;
    private PositionVertex acceleration;

    private MagicArtsHandler magicArtsHandler;

    private double resize;

    private Image currentImage;


    //CONSTRUCTORS
    private ArtObject (MagicArt magicArt) {
        isVisible = true;
        isDead = false;
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

    public boolean isVisible() {
        return isVisible;
    }

    public boolean isDead() {
        return isDead;
    }

    private double getWidth () {
        return currentImage.getWidth() * resize;
    }

    private double getHeight () {
        return currentImage.getHeight() * resize;
    }
    //TODO get from top and from left here

    public boolean isInBorder () {
        return this.getPlace().isInRectangle(-getWidth()/2, -getHeight()/2,
                1920 + getWidth()/2 ,1080 + getHeight()/2);
    }

    public boolean isInsideBorder () {
        return this.getPlace().isInRectangle(getWidth()/2, getHeight()/2,
                1920 - getWidth()/2 ,1080 - getHeight()/2);
    }

    public boolean isInObject (double fromLeft, double fromTop) {
        PositionVertex position = new PositionVertex(fromLeft, fromTop);
        double fromLeftTemp = this.getPlace().getFromLeft();
        double fromTopTemp = this.getPlace().getFromTop();
        return position.isInRectangle(fromLeftTemp - getWidth()/2, fromTopTemp - getHeight()/2,
                fromLeftTemp + getWidth()/2, fromTopTemp + getHeight()/2);
    }
    ////GETTERS

    //SETTERS
    public void setResize(double resize) {
        this.resize = resize;
    }

    public void setVisible() {
        this.isVisible = !isVisible;
    }
    public void setVisible(boolean visible) {
        this.isVisible = visible;
    }

    public void killObject() {
        isDead = true;
        isVisible = false;
    }

    //TODO set velocity and place
    ////SETTERS


    //HANDLING OUTPUT
    protected void updateArtObject () {
        updateObjectMagicArt();
        updateObjectPlace();
    }
    protected void updateObjectMagicArt () {
        this.currentImage = magicArtsHandler.getFrame();
    }
    protected void updateObjectPlace () {
        this.velocity.addPositionVertex(acceleration);
        this.place.addPositionVertex(velocity);
    }

    public void print (GraphicsContext context) {
        if (!isVisible() || isDead) {
            return;
        }

        updateArtObject();

        context.save();
        context.setEffect(magicArtsHandler.getEffect());
        context.translate(this.getPlace().getFromLeft() ,this.getPlace().getFromTop());
        context.drawImage(currentImage, -getWidth()/2, -getHeight()/2, getWidth(), getHeight());
        context.restore();
    }
    ////Handling Output

    //HANDLING IMAGE OR TRANSPARENT
    public boolean isInImage (double fromLeft, double fromTop) {
        if (!isInObject(fromLeft, fromTop)) return false;
        double fromLeftImg = fromLeft - (this.getPlace().getFromLeft() - getWidth()/2);
        double fromTopImg = fromTop - (this.getPlace().getFromTop() - getHeight()/2);

        return currentImage.getPixelReader().getColor((int)fromLeftImg, (int)fromTopImg).getOpacity() != 0;
    }
}
