package model.magicArt;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class MovingArt {
    private final ArrayList<Image> frames;
    private int frameRate;

    //CONSTRUCTORS
    public MovingArt (String baseAddress, int howManyFrames) {
        frames = new ArrayList<>();
        addAllFrames(baseAddress, howManyFrames);
        this.frameRate = 6;
    }
    public MovingArt (String baseAddress, int howManyFrames, int frameRate) {
        this(baseAddress, howManyFrames);
        this.frameRate = frameRate;
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


    //SETTERS
    public void setFrameRate (int frameRate) {
        this.frameRate = frameRate;
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
            addFrameToObject(baseAddress + i + ".png");
        }
    }
    ////HANDLING IMAGE INPUTS IN OBJECT
}
