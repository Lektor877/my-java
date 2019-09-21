package Game;

public class Game {
    private GameBoard board; //ссылка на игровое поле
    private GamePlayer[] gamePlayers = new GamePlayer[2]; // массив игроков
    private int playersTurn = 0;// индекс текущего

    public Game(){
        this.board = new GameBoard(this);
    }
}
