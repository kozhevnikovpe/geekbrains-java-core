package Lesson_1.Marathon;

public class Main {
    public static void main(String[] args) {
        Course c = new Course(new Obstacle[]{new Cross(80), new Wall(2), new Wall(1), new Cross(120),new Water(100)});
        Team team = new Team("Стражи галактики", new Competitor[]{new Human("Звеездный лорд"), new Human("Гамора"), new Dog("Ракета")});
        c.go(team);
        team.showResults();
    }
}