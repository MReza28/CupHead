package model.magicArtInstances.artObjects;

import model.PositionVertex;
import model.magicArt.MagicArt;
import model.objects.ArtObject;

public class AliveObject extends ArtObject {
    private int HP = 0;

    //CONSTRUCTORS
    public AliveObject(double fromLeft, double fromTop,
                       double velocityFromLeft, double velocityFromTop, double accelerationFromLeft, double accelerationFromTop,
                       MagicArt magicArt, int HP) {
        super(fromLeft, fromTop, velocityFromLeft, velocityFromTop, accelerationFromLeft, accelerationFromTop, magicArt);
        this.HP = HP;

        playMainAnimation();
    }
    ////CONSTRUCTORS


    //PLAYING ANIMATIONS
    private void playMainAnimation () {
        super.getMagicArtsHandler().playMagicArt(0);
    }

    private void playDeath () {
        if (super.getMagicArtsHandler().getPlayingMagicArt() == 1) {
            if (super.getMagicArtsHandler().isFinished()) {
                super.killObject();
            }
        }
        else
            super.getMagicArtsHandler().playMagicArt(1);
    }

    @Override
    protected void updateArtObject() {
        super.updateArtObject();
        if (HP <= 0) playDeath();
    }

    //NEW FUNCTIONS
    public void reduceHP (int howMuch) {
        this.HP -= howMuch;
    }
}
