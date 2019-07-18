package Game;

public class Main {
    public static void main(String[] args) {

        Team team1 = new Team("Крутые перцы", new Warrior(320, "Тигрил", 70, 0, 2),
                new Assasin(250, "Акали", 70, 0,4),
                new Doctor(120, "Жанна", 0, 60,1));


        Team team2 = new Team("Незабудки", new Warrior(490, "Минотавр", 60, 0,4),
                new Assasin(260, "Джинкс", 90, 0,5),
                new Doctor(100, "Зои", 0, 80,2));

        Team team3 = new Team("Стражи галактики", new SpaceWarrior(200, "Звездный лорд", 50, 20,4),
                new Assasin(150, "Ракета", 50, 0,6),
                new SpaceWarrior(250, "Гамора", 80, 10,5),
                new Assasin(300, "Грут", 100, 0,1));

        Game game = new Game(team1,team2, team3);

        game.run();
        game.info();
    }
}
