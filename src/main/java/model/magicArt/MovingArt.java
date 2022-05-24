package model.magicArt;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class MovingArt {
    private final ArrayList<Image> frames;

    //CONSTRUCTORS
    public MovingArt (String baseAddress, int howManyFrames) {
        frames = new ArrayList<>();
        addAllFrames(baseAddress, howManyFrames);
    }

    //GETTERS
    private int getFramesCount () {
        return frames.size();
    }

    private Image getFrame (int index) {
        return frames.get(index);
    }
    Image getFirstFrame () {
        if (this.getFramesCount() == 0) return null;
        return frames.get(0);
    }
    //null at the end of the frames
    Image getNextFrame (int previousFrame) {
        if (getFramesCount() <= previousFrame + 1) return null;
        return getFrame((previousFrame + 1) % this.getFramesCount());
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
