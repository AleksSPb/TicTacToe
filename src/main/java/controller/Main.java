package controller;

import model.Game;
import model.Move;
import model.UserException;
import view.GameView;
import view.console.ConsoleView;
import view.swing.SwingView;

/**
 * Контроллер
 */
public class Main {
    Game game = new Game();
    static GameView gameView;

    public static void main(String[] args) {
        gameView = new ConsoleView();
      //  GameView gui = new SwingView();
    }

    public play(){
        while (!game.isOver()) {
            gameView.render(game);
            Move curMove=gameView.getMove();
            try{game.move(curMove.x, curMove.y);}
            catch (UserException ex) {
                System.out.println("Ввод некорректен, повторите ввод. Введите через пробел два числа менее " +game.getSize());
            }

        }
    }

}
