package model;

public class LowPointCard extends ACard{
    public LowPointCard(int valid) {
        super(valid);
    }

    @Override
    public int getScore() {
        return 50;
    }
}
