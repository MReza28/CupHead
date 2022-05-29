package model.magicArt;

import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.Effect;
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

    private MovingArt getMovingArt () {
        return getMagicArt(playingMagicArt).getMovingArt();
    }
    private MovingArt getMovingArt (int index) {
        return getMagicArt(index).getMovingArt();
    }

    private SoundOnArt getSoundOnArt () {
        return getMagicArt(playingMagicArt).getSoundOnArt();
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
        MovingArt tempArt = getMovingArt();
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
        MovingArt tempArt = getMovingArt();
        Image temp = tempArt.getFrame(framesPassed / tempArt.getFrameRate());
        framedPassedHandler();
        if (temp == null) {
            endMagicArt();
            return null;
        }
        return temp;
    }
    private void framedPassedHandler () {
        if (getMovingArt().isLoop()) {
            if (getMovingArt().isUpFrame()) {
                framesPassed++;
                if (isFinished()) framesPassed = 0;
            }
            else {
                framesPassed--;
                if (framesPassed < 0)
                    framesPassed = getMovingArt().getFrameRate() * getMovingArt().getFramesCount() - 1;
            }
        }
        else {
            if (getMovingArt().isUpFrame()) {
                framesPassed++;
                if (isFinished()) framesPassed--;
            }
            else {
                framesPassed--;
                if (framesPassed < 0) framesPassed++;
            }
        }
    }

    public ColorAdjust getEffect () {
        ColorAdjust effect = new ColorAdjust();
        //Works on Effect
        ////
        return effect;
    }

    //TODO...
    public Image playSound () {
        if (this.isFinished()) return null;
        return null;
    }
}
