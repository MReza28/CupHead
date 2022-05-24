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
    MagicArtsHandler(MagicArt magicArt) {
        this();
        magicArts.add(magicArt);
    }
    MagicArtsHandler(ArrayList<MagicArt> magicArts) {
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
        return this.playingMagicArt == -1;
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
        if (this.isFinished()) return null;
        Image temp = getMovingArt(playingMagicArt).getNextFrame(framesPassed);
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
