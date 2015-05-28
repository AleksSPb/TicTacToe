package model;

/**
 * Created by Student_04 on 28.05.2015.
 */
public class Move {
    public final int x;
    public final int y;

    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Move{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
