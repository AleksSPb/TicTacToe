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
    static Game game = new Game();
    static GameView gameView;

    public static void main(String[] args) {
        gameView = new ConsoleView();
       int i=0;
      //  GameView gui = new SwingView();
        while (!game.isOver()) {
            if (i>9) break;
            gameView.render(game);
            Move curMove=gameView.getMove();
            try{game.move(curMove.x, curMove.y);
            if (game.gameEnd()) break;}
            catch (UserException ex) {
                System.out.println("Ввод некорректен, повторите ввод. Введите через пробел два числа менее " +game.getSize());
                  }
            i++;
    }

        System.out.println("Game over! Result - " + (game.getState()).name);

    }

}
