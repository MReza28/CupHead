package view.images;

import model.magicArt.MagicArt;
import model.magicArt.MovingArt;

public class MagicArtsLoader {
    public static MagicArt CUP_HEAD;
    public static MagicArt CUP_HEAD_BULLET;
    public static MagicArt CUP_HEAD_BOMB;

    public static MagicArt FLAPPY_BIRD_YELLOW_FLY;
    public static MagicArt FLAPPY_BIRD_YELLOW_DEATH;
    public static MagicArt FLAPPY_BIRD_PINK_FLY;
    public static MagicArt FLAPPY_BIRD_PINK_DEATH;
    public static MagicArt BOSS1;


    public static MagicArt BOSS2;
    public static MagicArt BOSS3;

    static {
        MovingArt temp;
        MovingArt temp2;
        temp = new MovingArt(MagicArtsLoader.class.getResource("Flappy Birds/Yellow/Fly").toExternalForm(), 16);
        CUP_HEAD = new MagicArt(temp, null);
        CUP_HEAD_BULLET = new MagicArt(
                new MovingArt(MagicArtsLoader.class.getResource("CupHead/Bullet").toExternalForm(), 4) ,
                null);
        CUP_HEAD_BOMB = new MagicArt(
                new MovingArt(MagicArtsLoader.class.getResource("CupHead/Bomb").toExternalForm(), 22) ,
                null);


        FLAPPY_BIRD_YELLOW_FLY = new MagicArt(
                new MovingArt(MagicArtsLoader.class.getResource("Flappy Birds/Yellow/Fly").toExternalForm(), 16) ,
                null);
        FLAPPY_BIRD_YELLOW_DEATH = new MagicArt(
                new MovingArt(MagicArtsLoader.class.getResource("Flappy Birds/Yellow/Death").toExternalForm(), 12) ,
                null);

        FLAPPY_BIRD_PINK_FLY = new MagicArt(
                new MovingArt(MagicArtsLoader.class.getResource("Flappy Birds/Pink/Fly").toExternalForm(), 16) ,
                null);
        FLAPPY_BIRD_PINK_DEATH = new MagicArt(
                new MovingArt(MagicArtsLoader.class.getResource("Flappy Birds/Pink/Death").toExternalForm(), 12) ,
                null);
    }
}
