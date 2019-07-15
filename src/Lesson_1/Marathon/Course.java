package Lesson_1.Marathon;

public class Course {
    protected Obstacle[] obstacles;

    public Course(Obstacle... obstacles){
        this.obstacles = obstacles;
    }

    public void go(Team team){
        for (Competitor c : team.getTeammates()) {
            for (Obstacle o : obstacles) {
                o.doIt(c);
                if (!c.isOnDistance())
                    break;
            }
        }
    }
}
