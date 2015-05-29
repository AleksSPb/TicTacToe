package model;

/**
 * Состояние клетки поля
 */
public enum Cell {
    X("X"), O("0"), EMPTY(" ");

    public final String name;

    Cell(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
