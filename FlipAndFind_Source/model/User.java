package model;

import java.util.ArrayList;
import java.util.List;

public class User implements IUser {
    private String name;
    private int level;
    private int score;
    private int maxScore;
    private List<IRoundGame> rounds;
    private ArrayList<UserObserver> userObservers;

    public User(String name) {
        this.name = name;
        this.level = 0;
        this.score = 200;
        this.maxScore = this.score;
        userObservers = new ArrayList<>();
        createRound();
    }

    public User(String name, int level, int score, int maxScore) {
        this.name = name;
        this.level = level;
        this.score = score;
        this.maxScore = maxScore;
    }

    // tạo màn chơi
    private void createRound() {
        this.rounds = new ArrayList<>();
        for (int i = 0; i < NUM_OF_LEVEL; i++) {
            IRoundGame roundGame = new RoundGame(i);
            this.rounds.add(roundGame);
        }
    }

    // tăng cấp độ chơi
    @Override
    public void levelUp() {
        level++;
    }

    //
    public boolean checkAllLevel() {
        return level == NUM_OF_LEVEL;
    }

    // tăng điểm lên
    @Override
    public void upScore(int x, int y) {
        score += getCardAtIndex(x, y).getScore();
        setMaxScore();
    }

    // gán lại điểm cao nhất.
    private void setMaxScore() {
        maxScore = score > maxScore ? score : maxScore;
    }

    // trừ điểm
    @Override
    public void downScore() {
        score -= 50;
        if (score < 0) score = 0;
    }

    // trừ điểm nếu sử dụng nút Trợ giúp.
    @Override
    public void downScoreForHelp() {
        score -= 200;
        if (score < 0) score = 0;
    }

    // lấy màn chơi gần nhất (vì tăng level theo màn chơi)
    @Override
    public IRoundGame getCurrentGame() {
        return rounds.get(level);
    }

    // lấy thẻ ở vị trí index (i,j)
    @Override
    public ACard getCardAtIndex(int i, int j) {
        return getRound().getCardAtIndex(i, j);
    }

    // lấy điểm cao nhất.
    @Override
    public int getMaxScore() {
        return maxScore;
    }

    // lấy điểm ngưởi chơi
    @Override
    public int getScore() {
        return score;
    }

    // lấy cấp độ người chơi.
    @Override
    public int getLevel() {
        return level;
    }

    // lấy tên người chơi
    @Override
    public String getName() {
        return name;
    }

    // lấy dòng ma trận màn chơi
    @Override
    public int getX() {
            return getRound().getX();

    }

    // lấy màn chơi ở vị trí level
    public IRoundGame getRound() {
        return this.rounds.get(level);
    }

    // lấy cột ma trận màn chơi
    @Override
    public int getY() {
            return getRound().getY();
    }

    // thay đổi kích thước màn chơi theo cấp độ
    @Override
    public void reSized(int width, int height) {
        getRound().reSized(width, height);
    }

    // thêm phần hệ thống hiện thông tin người chơi
    @Override
    public void addUserObserver(UserObserver o) {
        userObservers.add(o);
    }

    // xóa phần hệ thống hiện thông tin người chơi
    @Override
    public void removeUserObserver(UserObserver o) {
        userObservers.remove(o);
    }

    // cập nhật lên phần hệ thống hiện thông tin người chơi
    @Override
    public void notifyUserObserver() {
        for (UserObserver observer : userObservers) {
            if (checkAllLevel()) {
                observer.setScreenWin();
            }
            observer.update(level, score, maxScore);
        }
    }
}
