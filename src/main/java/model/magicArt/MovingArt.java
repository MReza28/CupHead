package model.magicArt;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class MovingArt {
    private final ArrayList<Image> frames;
    private int frameRate;
    private boolean isLoop;
    private boolean isUpFrame;

    //CONSTRUCTORS
    private MovingArt () {
        frames = new ArrayList<>();
        this.frameRate = 5;
        isLoop = true;
        isUpFrame = true;
    }
    public MovingArt (String baseAddress, int howManyFrames) {
        this();
        addAllFrames(baseAddress, howManyFrames);
    }
    public MovingArt (String baseAddress, int howManyFrames, int frameRate) {
        this(baseAddress, howManyFrames);
        this.frameRate = frameRate;
    }
    public MovingArt (String baseAddress, int howManyFrames, int frameRate, boolean isLoop, boolean isUpFrame) {
        this(baseAddress, howManyFrames, frameRate);
        this.isLoop = isLoop;
        this.isUpFrame = isUpFrame;
    }

    //GETTERS
    public int getFramesCount () {
        return frames.size();
    }

    public int getFrameRate () {
        return this.frameRate;
    }

    Image getFrame (int index) {
        if (index >= this.getFramesCount()) return null;
        return frames.get(index);
    }
    Image getFirstFrame () {
        if (this.getFramesCount() == 0) return null;
        return frames.get(0);
    }

    public boolean isLoop() {
        return isLoop;
    }
    public boolean isUpFrame() {
        return isUpFrame;
    }

    //SETTERS
    public void setFrameRate (int frameRate) {
        this.frameRate = frameRate;
    }

    public void setUpFrame () {
        isUpFrame = !isUpFrame;
    }
    public void setUpFrame (boolean isUpFrame) {
        this.isUpFrame = isUpFrame;
    }

    public void setLoop () {
        isLoop = !isLoop;
    }
    public void setLoop (boolean isLoop) {
        this.isLoop = isLoop;
    }



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
            addFrameToObject(baseAddress + "img (" + i + ").png");
        }
    }
    ////HANDLING IMAGE INPUTS IN OBJECT
}
