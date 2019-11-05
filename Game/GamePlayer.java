package game;

public class GamePlayer {
    private char playerSign;
    private boolean realplayer = true;

    public GamePlayer(boolean isRealplayer, char playerSign){
        this.realplayer = isRealplayer;
        this.playerSign = playerSign;
    }

    public boolean isRealplayer(){
        return realplayer;
    }

    public char getPlayerSign(){
        return playerSign;
    }
}
