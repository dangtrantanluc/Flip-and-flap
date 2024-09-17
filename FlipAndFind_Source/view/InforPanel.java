package view;
/**
 * Lớp panel hiển thị thông tin của người chơi
 * Gồm: tên, điểm, cấp độ, điểm cao nhất
 * Nhận thông báo cập nhật cấp độ chơi, điểm, điểm cao nhất của người chơi sau khi kết thúc màn
 */

import controller.IController;
import model.UserObserver;

import javax.swing.*;
import java.awt.*;

public class InforPanel extends JPanel implements UserObserver {
    private JLabel name;
    private JLabel score;
    private JLabel level;
    private JLabel maxScore;
    private final int WIDTH=200;
    private final int HEIGHT=103;
    private IController gameController;

    public InforPanel(IController gameController) {
        this.gameController=gameController;
        setSize(new Dimension(WIDTH,HEIGHT));
        setBackground(Color.decode("#EFE9DB"));
        initComponents();
        gameController.addUserObserver(this);
    }

    public void initComponents() {
        // tên người chơi
        this.name= new JLabel(gameController.getName());
        name.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        // cấp độ chơi
        this.level = new JLabel(" Level: "  + gameController.getLevelUser());
        level.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        // điểm hiện có
        this.score = new JLabel(" Score: " + gameController.getScore());
        score.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        // điểm cao nhất đã đạt được
        this.maxScore = new JLabel(" Max Score: " +  gameController.getMaxScore());
        maxScore.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
        // tạo các panel chứa từng cái
        JPanel panel_name = new JPanel();
        panel_name.setLayout(new FlowLayout());
        panel_name.setBackground(Color.decode("#EFE9DB"));

        JPanel panel_level_score = new JPanel();
        panel_level_score.setLayout(new FlowLayout());
        panel_level_score.setBackground(Color.decode("#EFE9DB"));

        JPanel panel_maxsore = new JPanel();
        panel_maxsore.setLayout(new FlowLayout());
        panel_maxsore.setBackground(Color.decode("#EFE9DB"));
        // thêm panels vào panel lớn
        panel_name.add(name);
        panel_level_score.add(level);
        panel_level_score.add(score);
        panel_maxsore.add(maxScore);
        this.setLayout(new GridLayout(3, 1));
        this.add(panel_name);
        this.add(panel_level_score);
        this.add(panel_maxsore);
    }
    // phương thức cập nhật cấp độ, điểm và điểm cao nhất của người chơi
    @Override
    public void update(int level, int score, int maxScore) {
        this.level.setText(" Level: "+ (level+1)+"");
        this.score.setText(" Score: "+ score+"");
        this.maxScore.setText(" Max Score: "+ maxScore+"");
    }
    // cập nhật màn hình sau khi chơi đủ 4 màn.
    @Override
    public void setScreenWin() {
        gameController.switchPaneWin();
    }
}
