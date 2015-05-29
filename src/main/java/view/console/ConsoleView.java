package view.console;

import model.Game;
import model.Move;
import view.GameView;

import java.util.Scanner;

/**
 * Запуск консольного варианта игры
 */
public class ConsoleView implements GameView {
    public ConsoleView() {
        System.out.println("Игра Крестики-нолики");
        System.out.println("====================");
    }

    public void render(Game game) {
        // TODO: Реализовать
        System.out.println("Next "+(game.getState()).name);
        System.out.println("________ Game field size "+game.getSize());
        for (int x = 0; x < game.getSize(); x++) {
            System.out.print("|");
            for (int y = 0; y < game.getSize(); y++) {
                System.out.print(game.field[x][y].name);
            }
            System.out.println("|");
        }
        System.out.println("----------- Game state" +game.isOver());
    }

    @Override
    public Move getMove() {
        int x=-1,y=-1;
        while (true) {
            System.out.println("Ваш ход! Введите строку и столбец Вашего хода:");
            Scanner sc = new Scanner(System.in);
            try {
            x = sc.nextInt();
            y = sc.nextInt();}
            catch (NumberFormatException ex) {
                System.out.println("Введите числа через пробел");
            }
            if  ((x>=0)&&(y>=0)) { return new Move(x,y);}
        }
    }
}
