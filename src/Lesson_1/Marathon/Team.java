package Lesson_1.Marathon;

public class Team {

    protected String name;
    protected Competitor[] teammates;

    public Team(String name,Competitor... teammates){
        this.name = name;
        this.teammates = teammates;
    }

    public String getName(){
        return new String(this.name);
    }

    public Competitor[] getTeammates(){
        return teammates.clone();
    }

    public void showSuccessfulResults(){
        for(Competitor c:this.teammates){
            if(c.isOnDistance())
                c.info();
        }
    }

    public void showResults(){
        for(Competitor c:this.teammates){
            c.info();
        }
    }
}
