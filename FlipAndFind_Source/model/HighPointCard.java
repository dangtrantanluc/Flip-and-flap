package model;

public class HighPointCard extends ACard{
    public HighPointCard(int valid) {
        super(valid);
    }

    @Override
    public int getScore() {
        return 100;
    }
}
