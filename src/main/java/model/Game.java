package model;

/**
 * Состояние игры
 */
public class Game {


    /**
     * Размер поля
     */
    final int size;
    /**
     * Поле игры
     * Координаты отсчитываем от
     * верхнего левого угла
     */
    public final Cell[][] field;
    /**
     * Состояние игры
     */
    State state = State.X_MOVE;
public boolean isOver(){
   if  ((state==State.X_MOVE)||(state==State.O_MOVE))        return false;
    return true;
}

    public Game(int size) {
        this.size = size;
        field = new Cell[size][size];
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                field[x][y] = Cell.EMPTY;
            }
        }
    }

    public Game() {
        this(3);
    }

    public int getSize() {
        return size;
    }

    /**
     * Ход
     *
     * @param x координата по горизонтали (столбец)
     * @param y координата по вертикали (строка)
     */
    public boolean correctMove(int x, int y) throws UserException {
        if (x < 0 || x >= size)
            throw new UserException("x за пределами поля");
        if (y < 0 || y >= size)
            throw new UserException("y за пределами поля");
        if (field[x][y] != Cell.EMPTY)
            throw new UserException("Ячейка занята x = " + x + " y = " + y);
        return true;
    }
    public void move(int x, int y) throws UserException {

if (correctMove(x,y))
        switch (state) {
            case X_MOVE:
                field[x][y] = Cell.X;
                state=State.O_MOVE;
                break;
            case O_MOVE:
                field[x][y] = Cell.O;
                state=State.X_MOVE;
                break;
            default:
                throw new UserException("Ход невозможен!");
        }
    }

    public boolean gameEnd()
    {
        //check rows
        for (int x = 0; x < size; x++) {
            int counter=1;
            if (field[x][0]!=Cell.EMPTY)
            for (int y = 1; y < size; y++) {
                if (field[x][0]!=field[x][y]) break;
                counter++;
            }
            if (counter==size) {
                System.out.println("Find horizontal line!!!");
                if (field[x][0]==Cell.X) state=State.X_WINS;
                else state=State.O_WINS;
                return true;
            }
        }

        //check columns
        for (int x = 0; x < size; x++) {
            int counter=1;
            if (field[0][x]!=Cell.EMPTY)
            for (int y = 1; y < size; y++) {
                if (field[0][x]!=field[y][x]) break;
                counter++;
            }
            if (counter==size) {
                System.out.println("Find vertical line!!!");
                if (field[0][x]==Cell.X) state=State.X_WINS;
                else state=State.O_WINS;
                return true;
            }
        }

        //check diagonal

            int counter=1;
            if (field[0][0]!=Cell.EMPTY)
            for (int y = 1; y < size; y++) {
                if (field[0][0]!=field[y][y]) break;
                counter++;
            }
            if (counter==size) {
                System.out.println("Find diagonal line!!!");
                if (field[0][0]==Cell.X) state=State.X_WINS;
                else state=State.O_WINS;
                return true;
            }

        //check diagonal

       counter=1;
        if (field[0][size-1]!=Cell.EMPTY)
        for (int y = 1; y < size; y++) {
            if (field[0][size-1]!=field[y][size-1-y]) break;
            counter++;
        }
        if (counter==size) {
            System.out.println("Find revers diagonal line!!!");
            if (field[0][size-1]==Cell.X) state=State.X_WINS;
            else state=State.O_WINS;
            return true;
        }

        //check draw

        for (int x = 0; x < size; x++)
            for (int y = 0; y < size; y++) {
                if (field[x][y]==Cell.EMPTY) return false;
            }
        state=State.DRAW;
        return true;


    }

    public State getState() {
        return state;
    }

    public enum State {
        X_MOVE("Ход крестиков"),
        O_MOVE("Ход ноликов"),
        X_WINS("Крестики выиграли"),
        O_WINS("Нолики выиграли"),
        DRAW("Ничья");

        public final String name;

        State(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "State: " + name;
        }
    }
}
