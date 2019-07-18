package Game;

public class Team {
    private  Hero[] members;
    private String name;

    public Team(String name, Hero... members){
        this.members = members;
        for(Hero h:members){
            h.setTeam(this);
        }
        this.name=name;
    }

    Hero[] getMembers(){
        return members;
    }

    public void info(){
        System.out.println("----------\nКоманда: "+this.name);
        for (Hero h: members) {
            h.info();
        }
    }

    public int membersAlive(){
        int result = 0;
        for (Hero h :members) {
            if(h.health>0)
                result++;
        }
        return result;
    }

    public boolean isAlive(){
        return membersAlive()>0;
    }
}
