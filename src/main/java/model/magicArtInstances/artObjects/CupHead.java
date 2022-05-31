package model.magicArtInstances.artObjects;


import enums.Statics;
import javafx.scene.input.MouseEvent;
import view.fx.FxStaticSaves;
import view.images.MagicArtsLoader;

public class CupHead extends AliveObject{
    private final int cupHeadSpeed = Statics.cupHeadMoveSpeed;
    private final double bulletSpeed = Statics.cupHeadBulletsSpeed;
    private final double bombAcceleration = Statics.cupBombAcceleration;
    private int bulletCoolDown = 0;
    private boolean bulletOrBomb;

    public CupHead (int HP) {
        super(200, 540, 0, 0, 0, 0,
                MagicArtsLoader.CUP_HEAD, HP);
    }

    //UPDATE HANDLER
    @Override
    protected void updateObjectPlace() {
        MouseEvent mouseEvent = new MouseEvent()

        if (FxStaticSaves.KEY_W) {
            super.getPlace().addPositionVertex(0, -cupHeadSpeed);
            if (!isInsideBorder()) super.getPlace().addPositionVertex(0, cupHeadSpeed);
        }
        if (FxStaticSaves.KEY_A) {
            super.getPlace().addPositionVertex(-cupHeadSpeed, 0);
            if (!isInsideBorder()) super.getPlace().addPositionVertex(cupHeadSpeed, 0);
        }
        if (FxStaticSaves.KEY_S) {
            super.getPlace().addPositionVertex(0, cupHeadSpeed);
            if (!isInsideBorder()) super.getPlace().addPositionVertex(0, -cupHeadSpeed);
        }
        if (FxStaticSaves.KEY_D) {
            super.getPlace().addPositionVertex(cupHeadSpeed, 0);
            if (!isInsideBorder()) super.getPlace().addPositionVertex(-cupHeadSpeed, 0);
        }
        if (FxStaticSaves.KEY_SPACE) {
            if (FxStaticSaves.KEY_TAB) fireBullet();
            else fireBomb();
        }
    }

    private void fireBullet () {
        if (bulletCoolDown > 0) {
            bulletCoolDown--;
            return;
        }
        Bullet bullet = new Bullet(getPlace().getFromLeft(), getPlace().getFromTop(),
                bulletSpeed, 0, 0, 0,
                MagicArtsLoader.CUP_HEAD_BULLET, 1, false);
        bulletCoolDown = Statics.cupHeadBulletCoolDown;
    }

    private void fireBomb () {
        if (bulletCoolDown > 0) {
            bulletCoolDown--;
            return;
        }
        Bullet bullet = new Bullet(getPlace().getFromLeft(), getPlace().getFromTop(),
                0, 0, 0, bombAcceleration,
                MagicArtsLoader.CUP_HEAD_BOMB, 2, false);
        bulletCoolDown = Statics.cupHeadBombCoolDown;
    }
}
