package Course;

import Competitor.Competitor;
import Competitor.Team;

public class Course {
    private Obstacle[] obstacles;

    public Course(Obstacle... obstacles){
        this.obstacles = obstacles;
    }

    public void doit(Team team){
        for(Competitor c : team.getCompetitors()){
            for(Obstacle o : obstacles){
                o.doit(c);
                if(!c.isOnDistance()) break;
            }
        }
    }
}
