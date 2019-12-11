package Competitor;

public class Human implements Competitor {
    protected String name;
    protected int maxRunDistance;
    protected  int maxSwimDistance;
    protected  int maxJumpDistance;
    protected boolean active;

    @Override
    public boolean isOnDistance(){
        return active;
    }

    public Human(String name){
        this.name = name;
        this.maxRunDistance = 10000;
        this.maxSwimDistance = 500;
        this.maxJumpDistance = 20;
        this.active = true;
    }

    @Override
    public void run(int dist){
        if(dist <= maxRunDistance){
            System.out.println(name + " отлично справился с кроссом");
        } else {
            System.out.println(name + " не справился с кроссом");
          active = false;
        }
    }

    @Override
    public void swim(int dist){
        if(dist <= maxSwimDistance){
            System.out.println(name + " отлично проплыл");
        } else {
            System.out.println(name + " не проплыл");
            active = false;
        }
    }

    @Override
    public void jump(int height){
        if(height <= maxJumpDistance){
            System.out.println(name + " перепрыгнул стену");
        } else {
            System.out.println(name + " не перепрыгнул стену");
            active = false;
        }
    }

    @Override
    public  void result(){
        System.out.println(name + ": " + active);
    }
}
