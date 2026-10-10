package game.rpg_engine.util;

public class Random
{
    public static int randByte(){
        int rand = (int)(Math.random()*100);
        return rand <= 50 ? 0 : 1;
    }

    public static boolean randBool(){
        int rand = randByte();
        return rand == 0;
    }

    public static int randByte(double chance){
        int rand = (int)(Math.random()*100);
        return rand <= chance ? 0 : 1;
    }

    public static boolean randBool(double chance){
        return randByte(chance)==0;
    }
}
