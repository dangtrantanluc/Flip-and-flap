package model;

public interface UserObserver {
    void update(int level, int score, int maxScore);

    void setScreenWin();
}
