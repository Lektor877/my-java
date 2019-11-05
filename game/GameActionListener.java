package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameActionListener implements ActionListener {
  private int row; // ряд
  private int cell; // столбец
  private GameButton button; // ссылка на кнопки

  public GameActionListener(int row, int cell,  GameButton gButton){
      this.row = row;
      this.cell = cell;
      this.button = gButton;
  }

   @Override
    public void actionPerformed(ActionEvent e) {
    GameBoard board = button.getBoard();

    if(board.isTurnable(row, cell)){
     updateByPlayersData(board);

     if(board.isFull()){//смотрит за заполненность
         board.getGame().showMessage("Ничья!");
         board.emptyField();
     }
     else{
         updateByAIData(board);
     }
    }
    else{
        board.getGame().showMessage("Некорректный ход!");
    }
    }

    //Ход человека
    private void updateByPlayersData(GameBoard board){
      //Обновить матрицы игры
        board.updateGameField(row, cell);

        //Обновить содержимое кнопки
        button.setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        if(board.checkWin()){
            button.getBoard().getGame().showMessage("Вы выиграли!");
            board.emptyField();
        }
        else{//иначе идет ход AI
            board.getGame().passTurn();
        }
    }

    //Код компютера
    private void updateByAIData(GameBoard board){
      //генерация координат хода компьютера
        int x, y;
        Random rnd = new Random();

        do{
            x = rnd.nextInt(GameBoard.dimension);
            y = rnd.nextInt(GameBoard.dimension);
        }
        while(!board.isTurnable(x, y));

        board.updateGameField(x, y);

        //Обновить содержимое кнопки
        int cellIndex = GameBoard.dimension * x + y;
        board.getButton(cellIndex).setText(Character.toString(board.getGame().getCurrentPlayer().getPlayerSign()));

        //Проверить победу
        if(board.checkWin()){
            button.getBoard().getGame().showMessage("Компьютер выиграл!");
            board.emptyField();
        }
        else{
            //Передать ход
            board.getGame().passTurn();
        }
    }
}
