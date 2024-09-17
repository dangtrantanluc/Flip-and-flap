package view;
/**
 * Panel hiện thời gian trên màn hình
 */

import controller.IController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TimePanel extends JPanel {
    JLabel timeLabel;
    Timer timer;
    IController gameController;

    public TimePanel(IController gameController) {
        this.gameController = gameController;
        timer = new Timer(1000, gameController.checkTime());
        timer.start();
//        count=0;
        JLabel time = new JLabel("Time Remaining: " + "\t");
        time.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.timeLabel = new JLabel(setTimeRemaining(20000 * gameController.getX() * gameController.getY()));
        timeLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        this.setSize(new Dimension(900, 50));
        this.setLayout(new FlowLayout());
        this.add(time);
        this.add(timeLabel);
    }

    // cập nhật thời gian còn lại lên màn hình
    public String setTimeRemaining(int time) {
        String result;
        int sec = (time % 60000) / 1000;
        int min = time / 60000;
        int hour = time / (60000 * 60);
        result = hour + ":" + min + ":" + sec;
        return result;
    }

    public void stopTimer() {
        timer.stop();
    }

}
