package model.magicArt;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Collections;

public class MagicArtsHandler {
    private final ArrayList<MagicArt> magicArts;

    int framesPassed;
    int playingMagicArt;

    private MagicArtsHandler () {
        this.magicArts = new ArrayList<>();
        framesPassed = -1;
        playingMagicArt = -1;
    }
    public MagicArtsHandler(MagicArt magicArt) {
        this();
        magicArts.add(magicArt);
    }
    public MagicArtsHandler(ArrayList<MagicArt> magicArts) {
        this();
        Collections.copy(this.magicArts, magicArts);
    }


    //GETTERS
    private MagicArt getMagicArt (int index) {
        return magicArts.get(index);
    }

    private MovingArt getMovingArt (int index) {
        return getMagicArt(index).getMovingArt();
    }

    private SoundOnArt getSoundOnArt (int index) {
        return getMagicArt(index).getSoundOnArt();
    }


    //SETTERS
    public void addMagicArt (MagicArt magicArt) {
        this.magicArts.add(magicArt);
    }


    //isMETHODS
    public boolean isFinished () {
        if (playingMagicArt == -1 || framesPassed == -1) return true;
        MovingArt tempArt = getMovingArt(playingMagicArt);
        return (framesPassed / tempArt.getFrameRate()) >= tempArt.getFramesCount();
        //TODO caution here
    }


    //START and ENDING PLAYING AN ANIMATION
    public void playMagicArt (int index) {
        this.playingMagicArt = index;
        this.framesPassed = 0;
    }
    private void endMagicArt () {
        this.playingMagicArt = -1;
        this.framesPassed = -1;
    }

    //RETURNING IMAGES AND SOUNDS
    public Image getFrame () {
        MovingArt tempArt = getMovingArt(playingMagicArt);
        Image temp = tempArt.getFrame(framesPassed / tempArt.getFrameRate());

        this.framesPassed++;
        if (temp == null) {
            endMagicArt();
            return null;
        }
        return temp;
    }

    //TODO...
    public Image playSound () {
        if (this.isFinished()) return null;
        return null;
    }
}
