package Game;

import java.util.Arrays;
import java.util.Random;

abstract class Hero implements Comparable<Hero> {

    protected int health;
    protected int maxHealth;
    protected String name;
    protected int damage;
    protected int addHeal;
    protected int speed;
    protected Team team;

    public Hero(int health, String name, int damage, int addHeal, int speed) {
        this.health = health;
        this.maxHealth = health;
        this.name = name;
        this.damage = damage;
        this.addHeal = addHeal;
        this.speed = speed;
    }

    abstract void hit(Hero hero);

    abstract void healing(Hero hero);

    boolean isAlive(){
        return health>0;
    }

    boolean canHit(){
        return damage>0;
    }

    boolean canHeal(){
        return addHeal>0;
    }

    void setTeam(Team team){
        this.team = team;
    }

    Team getTeam(){
        return this.team;
    }

    void causeDamage(int damage) {
        if(health < 0) {
            System.out.println("Герой уже мертвый!");
        } else {
            health -= damage;
            if(health<0)
                health=0;
        }
    }

    public int getHealth() {
        return health;
    }

    void addHealth(int health) {
        this.health += health;
        if(this.health>this.maxHealth)
            this.health=this.maxHealth;
    }

    void info() {

        System.out.println(name + " " + speed + ' ' + (health <= 0 ? "Герой мертвый" : health) + " " + damage);
    }

    public int getSpeed() {
        return speed;
    }

    public int compareTo(Hero p) {
        //Одинаковые по скорости ходят с рандомной очередностью
        Random random = new Random();
        if(this.speed < p.getSpeed()) return 1;
        else if(this.speed == p.getSpeed()) return random.nextInt(2)==0?1:-1;
        else return -1;
    }
}