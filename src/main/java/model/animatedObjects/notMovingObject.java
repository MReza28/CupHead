package model.animatedObjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class notMovingObject {
    private int centerFromTop;
    private int centerFromLeft;
    private ArrayList<Image> frames;
    private int lastFrameReturned;

    //CONSTRUCTORS
    protected notMovingObject (int centerFromTop, int centerFromLeft) {
        this.centerFromTop = centerFromTop;
        this.centerFromLeft = centerFromLeft;
        this.lastFrameReturned = 0;
        frames = new ArrayList<>();
    }
    protected notMovingObject (int centerFromTop, int centerFromLeft, String address) {
        this(centerFromTop, centerFromLeft);
        this.addFrameToObject(address);
    }
    public notMovingObject (int centerFromTop, int centerFromLeft, int howManyFrames, String baseAddress) {
        this(centerFromTop, centerFromLeft);
        this.resetAndAddAllFrames(baseAddress, howManyFrames);
    }
    ////CONSTRUCTORS



    //SETTERS
    public void setCenterFromTop(int centerFromTop) {
        this.centerFromTop = centerFromTop;
    }

    public void setCenterFromLeft(int centerFromLeft) {
        this.centerFromLeft = centerFromLeft;
    }
    ////SETTERS



    //GETTERS
    protected int getCenterFromTop() {
        return centerFromTop;
    }

    protected int getCenterFromLeft() {
        return centerFromLeft;
    }

    protected int getFramesCount () {
        return this.frames.size();
    }

    public Image getFrame(int index) {
        this.lastFrameReturned = index;
        return this.frames.get(index);
    }

    public Image getNextFrame () {
        int thisFrame = (this.lastFrameReturned + 1) % this.getFramesCount();
        return getFrame(thisFrame);
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

}
