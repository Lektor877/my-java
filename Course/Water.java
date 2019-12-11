package Course;

import Competitor.Competitor;

public class Water extends Obstacle {
    private int dist;

    public Water(int dist) {
        this.dist = dist;
    }

    @Override
    public void doit(Competitor competitor) {
        competitor.swim(dist);
    }
}