package Game;

class Doctor extends Hero {

    public Doctor(int heal, String name, int damage, int addHeal, int speed) {
        super(heal, name, damage, addHeal,speed);
    }

    @Override
    void hit(Hero hero) {
        System.out.println("Доктор не может бить!");
    }

    @Override
    void healing(Hero hero) {
        hero.addHealth(addHeal);
        System.out.println(this.name + " лечит " + (this==hero?"сам себя":hero.name)+", теперь здоровья "+hero.health);
    }
}