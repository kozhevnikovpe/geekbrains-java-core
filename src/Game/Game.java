package Game;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

class Game {
    private Team[] teams;
    public Game(Team... teams){
        this.teams = teams;
    }

    public void run(){

        //сортируем всех героев по скорости
        ArrayList<Hero> all = new ArrayList<>();
        for(Team t: teams){
            all.addAll(Arrays.asList(t.getMembers()));
        }
        Collections.sort(all);

        /*for(Hero h:all)
            h.info();
        return;*/

        //пока живо больше 1 команды
        while(teamsAlive()>1){
            for(Hero h:all){
                //действуют только живые герои
                if(h.isAlive()){
                    //бьют только бьющие
                    if(h.canHit()){
                        Hero target = getRandomTarget(true, h);
                        if(target!=null){
                            h.hit(target);
                        }
                    }
                    //лечат только лечащие
                    if(h.canHeal()){
                        Hero target = getRandomTarget(false, h);
                        if(target!=null){
                            h.healing(target);
                        }
                    }
                }
            }
        }
    }

    Hero getRandomTarget(boolean isEnemy, Hero thisHero){
        if(isEnemy){
            Random random = new Random();
            int enemiesAlive = enemiesAlive(thisHero.getTeam());
            if(enemiesAlive==0)
                return null;
            int enemyIndex = random.nextInt(enemiesAlive);
            int index = 0;
            for (Team t:teams){
                //ищем чужие команды
                if(t!= thisHero.getTeam())
                    for (Hero h:t.getMembers()){
                        if(h.isAlive()){
                            if(index==enemyIndex){
                                return h;
                            }else{
                                index++;
                            }
                        }
                    }
            }
        }else{
            Random random = new Random();
            int teammateIndex = random.nextInt(thisHero.getTeam().membersAlive());
            int index = 0;
            for (Hero h:thisHero.getTeam().getMembers()){
                if(h.isAlive()){
                    if(index==teammateIndex){
                        return h;
                    }else{
                        index++;
                    }
                }
            }
        }
        return null;
    }

    private int teamsAlive(){
        int result = 0;
        for (Team t :teams) {
            if(t.isAlive())
                result++;
        }
        return result;
    }

    /**
     * живых врагов
     * @param except
     * @return
     */
    private int enemiesAlive(Team except){
        int result = 0;
        for (Team t :teams) {
            if(t != except)
                result+=t.membersAlive();
        }
        return result;
    }

    public void info(){
        for(Team t:this.teams){
            t.info();
        }
    }
}
