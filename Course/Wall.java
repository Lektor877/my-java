package Course;

import Competitor.Competitor;

public class Wall extends Obstacle{
    private int height;

    public Wall(int height){
        this.height = height;
    }

    @Override
    public void doit(Competitor competitor){
       competitor.jump(height);
    }
}
