package Course;

import Competitor.Competitor;

public class Cross extends Obstacle {
    private int dist;

    public Cross(int dist){
        this.dist = dist;
    }

    @Override
    public void doit(Competitor competitor){
        competitor.run(dist);
    }
}
