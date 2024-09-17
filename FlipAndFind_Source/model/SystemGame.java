package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class SystemGame implements ISystemGame{
    // danh sách người chơi
    private List<IUser> users;
    // bảng xếp hạng
    private List<IUser> scoreBoard;
    // phần hệ thống nhận thông báo
    private List<SystemObserver> observers;

    public SystemGame() {
        this.users= new ArrayList<>();
        this.scoreBoard= new ArrayList<>();
        this.observers= new ArrayList<>();
    }
    // thêm người chơi
    @Override
    public void addUser(IUser user) {
        this.users.add(user);
    }
    // gửi thông báo đến các phần hệ thống
    @Override
    public void notifySystemObserver() {
        updateScoreBoard();
        List<String> topUserName= topUserName();
        List<Integer> topUserMaxScore= topUserMaxScore();
        for (SystemObserver observer: observers){
            observer.update(topUserName,topUserMaxScore);
        }
    }
    // tạo bảng xếp hạng (cột điểm)
    private List<Integer> topUserMaxScore() {
        List<Integer> userMaxScore= new ArrayList<>();
        for (IUser user: scoreBoard){
            userMaxScore.add(user.getMaxScore());
        }
        return userMaxScore;
    }
    // tạo bảng xếp hạng (thêm tên người chơi)
    private List<String> topUserName() {
        List<String> usersName= new ArrayList<>();
        for (IUser user: scoreBoard){
            usersName.add(user.getName());
        }
        return usersName;
    }
    // cập nhật bảng xếp hạng
    private void updateScoreBoard() {
        scoreBoard.clear();
        scoreBoard.addAll(users);
        Collections.sort(scoreBoard, new Comparator<IUser>() {
            @Override
            public int compare(IUser o1, IUser o2) {
                return o2.getMaxScore()-o1.getMaxScore();
            }
        });
        while (scoreBoard.size()>NUM_OF_TOP_PLAYER){
            scoreBoard.remove(NUM_OF_TOP_PLAYER);
        }
    }
    // thêm phần hệ thống nhận thông báo
    @Override
    public void addSystemObserver(SystemObserver observer) {
        observers.add(observer);
    }
    // xóa phần hệ thống nhận thông báo
    @Override
    public void removeSystemObserver(SystemObserver o) {
        observers.remove(o);
    }
}
