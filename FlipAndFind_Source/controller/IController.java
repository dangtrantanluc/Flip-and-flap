package controller;

import model.IUser;
import model.SystemObserver;
import model.UserObserver;

import javax.swing.*;
import java.awt.event.ActionListener;

public interface IController {
    // thao tác chơi sau khi nhấn bắt đầu chơi
    ActionListener buttonPlayButton();
    // chuyển màn hình sau khi nhập tên người chơi
    void switchPanelAction(JTextField field);
    // nút trợ giúp người chơi

    void helpButtonAction();
    // Kiểm tra thẻ thắng : valid =-1 và isFlip=true.
    boolean checkForAllAction(int i, int j);
    // Thêm người chơi vào hệ thống
    void addUserObserver(UserObserver observer);
    // Hệ thống cập nhật BXH
    void addSystemObserver(SystemObserver observer);
    IUser getUser();
    //  lấy cấp độ người chơi
    int getLevelUser();
    // thay đổi ma trận hình từng level
    void resetImage(int width, int height);
    // chuyển màn
    void upRound();
    // Lấy tên người chơi
    String getName();
    // Lấy chiều dài của màn hình chơi
    int getX();
    // lấy chiều cao của màn hình chơi.
    int getY();
    // lấy điểm
    int getScore();
    // lấy điểm số cao nhất.
    int getMaxScore();

    // kiểm tra thẻ hình ở vị trí (X,Y) đã lật hay chưa.
    boolean isFlip(int locationX, int locationY);
    // lấy hình không được lật của một thẻ hình
    ImageIcon getNullImage(int locationX, int locationY);
    // lấy hình đã lật của một thẻ
    ImageIcon getIcon(int locationX, int locationY);
    // Lấy hình chưa lật của một thẻ
    ImageIcon getBackGround(int locationX, int locationY);
    // thoát khỏi trò chơi.
    void quitAction();
    // chơi lại từ đầu
    void quitAllLevels();
    // chuyển đến trang đăng nhập.
    void switchPaneLogIn();

    void switchPaneWin();

    ActionListener checkTime();
}
