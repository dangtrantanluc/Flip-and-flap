package model;

public interface IUser extends UserObserverable {
    int NUM_OF_LEVEL = 4;

    void levelUp();

    void upScore(int x, int y);

    void downScore();

    void downScoreForHelp();

    IRoundGame getCurrentGame();

    ACard getCardAtIndex(int i, int j);

    int getMaxScore();

    int getScore();

    int getLevel();

    String getName();

    int getX();

    int getY();

    void reSized(int width, int height);

}
