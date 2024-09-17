package view;
/**
 * Màn hình chứa các thành phần nhỏ hơn của giao diện chơi.
 * Màn hình gồm: Phần thông tin người chơi, tên màn chơi, bảng xếp hạng, phần nút, màn chơi,thời gian.
 */

import controller.IController;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    // thông tin người chơi+điểm
    InforPanel inforPanel;
    // bảng xếp hạng
    ChartPanel chartPanel;
    //tên trò chơi
    GameNamePanel nameGame;
    // panel chứa nút thoát+trợ giúp
    ButtonsPanel buttonPanel;
    // panel chứa cards
    PlayPanels playPanel;
    IController gameController;
    TimePanel timePanel;

    public GamePanel(IController gameController) {
        this.gameController= gameController;
        this.setSize(new Dimension(920, 550));
        setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        // thông tin người chơi
        this.inforPanel= new InforPanel(this.gameController);
        this.inforPanel.setLocation(0,3);
        // tên trò chơi
        this.nameGame= new GameNamePanel(this.gameController);
        this.nameGame.setLocation(200,3);
        // bảng xếp hạng
        this.chartPanel= new ChartPanel(this.gameController);
        this.chartPanel.setLocation(0,100);
        // màn chơi
        this.playPanel= new PlayPanels(this.gameController);
        this.playPanel.setLocation(200,105);
        // nút chơi
        this.buttonPanel= new ButtonsPanel(this.gameController);
        this.buttonPanel.setLocation(0,350);
        // phần thời gian
        this.timePanel= new TimePanel(this.gameController);
        this.timePanel.setLocation(2,460);
        //
        this.add(inforPanel);
        this.add(nameGame);
        this.add(chartPanel);
        this.add(playPanel);
        this.add(buttonPanel);
        this.add(timePanel);
    }
    // lấy phần thời gian
    public TimePanel getTimePanel(){
        return timePanel;
    }
    // chuyển màn chơi
    public void nextGame(){
        playPanel.newPlayGame();
    }
    // mở hết tất cả các thẻ
    public void openAllCard(){playPanel.openAll();}
    // đóng hết tất cả các thẻ
    public void closeAllCard(){playPanel.closeAll();}
    // cập nhật thời gian còn lại
    public void updateTimer(String s) {
        timePanel.timeLabel.setText(s);
    }
    // dừng thời gian chơi
    public void stopTimer() {
        timePanel.stopTimer();
    }


}
