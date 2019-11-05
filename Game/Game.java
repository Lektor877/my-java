package game;

import javax.swing.*;

public class Game {
    private GameBoard  board; //Ссылка на игровое поле
    private GamePlayer[] gamePlayers = new GamePlayer[2]; //массив игроков
    private int playersTurn = 0; // индекс текущего игрока

    public Game(){
        this.board = new GameBoard(this);
    }

    public void initGame(){
        gamePlayers[0] = new GamePlayer(true,'X'); // игрок
        gamePlayers[1] = new GamePlayer(false, 'O'); // AI
    }

    //Передача хода
    void passTurn(){
        if(playersTurn == 0) // игрок
            playersTurn = 1; // AI
        else playersTurn = 0; // снова игрок
    }

    //Получение объекта текущего игрока
    GamePlayer getCurrentPlayer(){
        return gamePlayers[playersTurn];
    }

    //Метод показа сообщения для пользователя
    void showMessage(String messageText){
        JOptionPane.showMessageDialog(board, messageText);
    }

}