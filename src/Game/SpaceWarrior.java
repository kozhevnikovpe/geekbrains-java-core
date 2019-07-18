package Game;

public class SpaceWarrior extends Warrior{
    public SpaceWarrior(int health, String name, int damage, int addHeal,int speed) {
        super(health, name, damage, addHeal,speed);
    }

    @Override
    void healing(Hero hero) {
        hero.addHealth(addHeal);
        System.out.println(this.name + " лечит " + (this==hero?"сам себя":hero.name)+", теперь здоровья "+hero.health);
    }

}
