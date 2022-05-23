package model.animatedObjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class notMovingObject {
    private double centerFromTop;
    private double centerFromLeft;
    private double resize;
    private ArrayList<Image> frames;
    private int lastFrameReturned;

    //CONSTRUCTORS
    private notMovingObject () {
        this.centerFromTop = 0;
        this.centerFromLeft = 0;
        this.resize = 1;
        this.frames = new ArrayList<>();
        this.lastFrameReturned = 0;
    }
    private notMovingObject (double centerFromTop, double centerFromLeft) {
        this();
        this.centerFromTop = centerFromTop;
        this.centerFromLeft = centerFromLeft;
    }
    protected notMovingObject (double centerFromTop, double centerFromLeft, String address) {
        this(centerFromTop, centerFromLeft);
        this.addFrameToObject(address);
    }
    public notMovingObject (double centerFromTop, double centerFromLeft, int howManyFrames, String baseAddress) {
        this(centerFromTop, centerFromLeft);
        this.resetAndAddAllFrames(baseAddress, howManyFrames);
    }
    public notMovingObject (double centerFromTop, double centerFromLeft, int howManyFrames, String baseAddress, double resize) {
        this(centerFromTop, centerFromLeft, howManyFrames, baseAddress);
        this.resize = resize;
    }
    ////CONSTRUCTORS



    //SETTERS
    public void setCenterFromTop(double centerFromTop) {
        this.centerFromTop = centerFromTop;
    }

    public void setCenterFromLeft(double centerFromLeft) {
        this.centerFromLeft = centerFromLeft;
    }
    ////SETTERS



    //GETTERS
    protected double getCenterFromTop() {
        return centerFromTop;
    }

    protected double getCenterFromLeft() {
        return centerFromLeft;
    }

    protected int getFramesCount () {
        return this.frames.size();
    }

    protected Image getFrame(int index) {
        this.lastFrameReturned = index;
        return this.frames.get(index);
    }

    protected Image getNextFrame () {
        int thisFrame = (this.lastFrameReturned + 1) % this.getFramesCount();
        return getFrame(thisFrame);
    }

    protected double getImageHeight (int index) {
        return this.getFrame(index).getHeight();
    }

    protected double getImageWidth (int index) {
        return this.getFrame(index).getWidth();
    }
    ////GETTERS



    //HANDLING IMAGE INPUTS IN OBJECT
    private void addFrameToObject (Image image) {
        frames.add(image);
    }
    private void addFrameToObject (String imageAddress) {
        Image image = new Image(imageAddress);
        this.addFrameToObject(image);
    }

    private void addAllFrames (String baseAddress, int howManyFrames) {
        for (int i = 1; i <= howManyFrames; i++) {
            addFrameToObject(baseAddress + i + ".png");
        }
    }

    private void resetAndAddAllFrames (String baseAddress, int howManyFrames) {
        this.resetFrames();
        this.addAllFrames(baseAddress, howManyFrames);
    }

    private void resetFrames () {
        this.frames = new ArrayList<>();
    }
    ////HANDLING IMAGE INPUTS IN OBJECT




    //HANDLING OUTPUT
    public void print (GraphicsContext context) {
        context.save();

        context.translate(this.getCenterFromLeft(),this.getCenterFromTop());
        context.drawImage(this.getNextFrame(),0,0, 50, 200);

        context.restore();
    }
}
