package Competitor;

public class Animal implements Competitor {
    protected String name;
    protected String type;
    protected int maxRunDistance;
    protected int maxSwimDistance;
    protected int maxJumpDistance;
    protected boolean OnDistance;

    @Override
    public boolean isOnDistance() {
        return OnDistance;
    }

    public Animal(String name, String type, int maxRunDistance, int maxSwimDistance, int maxJumpDistance){
        this.name = name;
        this.type = type;
        this.maxRunDistance = maxRunDistance;
        this.maxSwimDistance = maxSwimDistance;
        this.maxJumpDistance = maxJumpDistance;
        this.OnDistance = true;
    }

    @Override
    public void run(int dist){
        if(dist <= maxRunDistance){
            System.out.println(type + " " + name + " отлично справился с кроссом");
        } else{
            System.out.println(type + " " + name + " не справился с кроссом");
            OnDistance = false;
        }
    }

    @Override
    public void swim(int dist){
        if(maxSwimDistance == 0){
            System.out.println(type + " " + name + " не умеет плавать");
            OnDistance = false;
            return;
        }
        if(dist <= maxSwimDistance){
            System.out.println(type + " " + name + " проплыл");
        }else{
            System.out.println(type + " " + name + " не проплыл");
            OnDistance = false;
        }
    }

    @Override
    public void jump(int height){
        if(height <= maxJumpDistance){
            System.out.println(type + " " + name + " перепрыгнул через стену");
        } else{
            System.out.println(type + " " + name + " не перепрыгнул через стену");
            OnDistance = false;
        }
    }

    @Override
    public void result(){
        System.out.println(type + " " + name + ": " + OnDistance);
    }
}
