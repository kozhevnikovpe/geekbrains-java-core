package Game;

class Warrior extends Hero {

    public Warrior(int health, String name, int damage, int addHeal,int speed) {
        super(health, name, damage, addHeal,speed);
    }

    @Override
    void hit(Hero hero) {
        if (hero != this) {
            if(health < 0) {
                System.out.println("Герой погиб и бить не может!");
            } else {
                hero.causeDamage(damage);
            }
            System.out.println(this.name + " нанес урон " + hero.name+(hero.isAlive()?", осталось здоровья "+hero.health:", герой умер"));
        }
    }

    @Override
    void healing(Hero hero) {
        System.out.println("Войны не умеют лечить!");
    }
}