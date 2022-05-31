package model.magicArtInstances.artObjects;

import model.magicArt.MagicArt;
import model.objects.ArtObject;

import java.util.ArrayList;

public class Bullet extends ArtObject {
    public static ArrayList<Bullet> BULLETS = new ArrayList<>();

    private int damage;
    private boolean isEnemy;
    private boolean isDying;

    public Bullet(double fromLeft, double fromTop,
                  double velocityFromLeft, double velocityFromTop, double accelerationFromLeft, double accelerationFromTop,
                  MagicArt magicArt, int damage, boolean isEnemy) {
        super(fromLeft, fromTop, velocityFromLeft, velocityFromTop, accelerationFromLeft, accelerationFromTop, magicArt);
        this.damage = damage;
        this.isEnemy = isEnemy;
        BULLETS.add(this);
        playMainAnimation();
    }

    //GETTERS
    public int getDamage () {
        return this.damage;
    }

    public boolean isEnemy () {
        return this.isEnemy;
    }
    ////GETTERS

    //ANIMATION
    private void playMainAnimation () {
        super.getMagicArtsHandler().playMagicArt(0);
    }

    private void playExplosion () {
        if (super.getMagicArtsHandler().getPlayingMagicArt() == 1) {
            if (super.getMagicArtsHandler().isFinished()) {
                super.killObject();
            }
        }
        else
            super.getMagicArtsHandler().playMagicArt(1);
    }
    ////ANIMATION

    //FUNCTIONS
    @Override
    protected void updateArtObject() {
        super.updateArtObject();
        if (damage <= 0) playExplosion();
    }

    ////FUNCTIONS
}
