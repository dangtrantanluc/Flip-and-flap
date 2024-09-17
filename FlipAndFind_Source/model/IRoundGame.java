package model;

/**
 *đại diện cho lớp Màn chơi
 */

public interface IRoundGame {
    int[] AXIS_X = {2, 3, 4, 5};
    int[] AXIS_Y = {3, 4, 6, 6};

    int NUM_OF_IMAGE = 15;

    int getX();

    int getY();

    ACard getCardAtIndex(int x, int y);

    void reSized(int width, int height);
}
