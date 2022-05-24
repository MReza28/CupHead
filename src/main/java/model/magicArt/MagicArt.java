package model.magicArt;

public class MagicArt {
    private final MovingArt movingArt;
    private final SoundOnArt soundOnArt;

    public MagicArt (MovingArt movingArt, SoundOnArt soundOnArt) {
        this.movingArt = movingArt;
        this.soundOnArt = soundOnArt;
    }

    //GETTERS
    public MovingArt getMovingArt() {
        return movingArt;
    }

    public SoundOnArt getSoundOnArt() {
        return soundOnArt;
    }

    //SETTERS
}
