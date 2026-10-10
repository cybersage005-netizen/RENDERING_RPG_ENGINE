package game.rpg_engine.entity;

import game.rpg_engine.client.CanRender;
import game.rpg_engine.enums.DamageSource;
import game.rpg_engine.enums.EntityResponse;
import game.rpg_engine.world.RelativeCord;

import java.util.function.BiFunction;

public abstract class Entity implements CanRender {
    final char id;
    protected RelativeCord cord;
    double health;
    final double maxHealth;
    private final int lineOfSightX;
    private final int lineOfSightY;
    public static final BiFunction<Character, RelativeCord, RelativeCord> BASIC_MOVEMENT = (ch, cord) -> {
        if (ch == 'w') {
            return cord.getUpBy(1);
        } else if (ch == 'a') {
            return cord.getLeftBy(1);
        } else if (ch == 'd') {
            return cord.getRightBy(1);
        } else {
            return ch == 's' ? cord.getDownBy(1) : cord;
        }
    };

    public Entity(char id, RelativeCord cord, double health, double maxHealth, int lineOfSightX, int lineOfSightY) {
        this.id = id;
        this.cord = cord;
        this.health = health;
        this.maxHealth = maxHealth;
        this.lineOfSightX = lineOfSightX;
        this.lineOfSightY = lineOfSightY;
    }

    public Entity(char id, RelativeCord cord, double health, double maxHealth, int lineOfSightGrid) {
        this.id = id;
        this.cord = cord;
        this.health = health;
        this.maxHealth = maxHealth;
        this.lineOfSightX = lineOfSightGrid;
        this.lineOfSightY = lineOfSightGrid;
    }

    public int getSightX(){
        return lineOfSightX;
    }

    public int getSightY(){
        return lineOfSightY;
    }

    public double getHealth(){
        return this.health;
    }

    public void damage(double amt){
        if(health-amt < 0) {
            this.health = 0;
            return;
        }
        this.health -= amt;
    }

    public boolean canHeal(){
        return true;
    }

    public void healHealth(double amt){
        if(health+amt > maxHealth){
            this.health = maxHealth;
            return;
        }
        this.health += amt;
    }

    public void healHealth(double amt, EntityResponse res){
        this.healHealth(amt);
    }

    public void damage(double amt, DamageSource source){
        this.damage(amt);
    }

    public char getId() {
        return this.id;
    }

    public RelativeCord getCord() {
        return this.cord;
    }
}

