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
    }

    @Override
    public Move getMove() {
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
