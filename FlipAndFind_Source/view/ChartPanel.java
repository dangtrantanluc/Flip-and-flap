package view;

import controller.IController;
import model.SystemObserver;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Lớp panel hiển thị bảng xếp hạng người chơi
 * nhận thông báo từ hệ thống để cập nhật bảng xếp hạng.
 */
public class ChartPanel extends JPanel implements SystemObserver {
   private JTextArea textArea;
   private final int WIDTH=200;
   private final int HEIGHT=250;
   IController gameController;

    public ChartPanel(IController gameController) {
        this.gameController= gameController;
        // tạo tên
        textArea = new JTextArea(" ");
        textArea.setBorder(BorderFactory.createLineBorder(Color.decode("#4B533A"), 2));
        textArea.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
        textArea.setPreferredSize(new Dimension(WIDTH - 10, HEIGHT - 10));
        textArea.setForeground(Color.decode("#4B533A"));
        textArea.setBackground(Color.white);
        textArea.setEditable(false);
        this.add(textArea);
        this.setSize(WIDTH - 3, HEIGHT - 2);
        this.setBackground(Color.white);
        gameController.addSystemObserver(this);
    }
    // cập nhật bảng xếp hạng lên phần text area.
    @Override
    public void update(List<String> topUserName, List<Integer> topUserMaxScore) {
        StringBuilder sb = new StringBuilder();
        sb.append("      TOP PLAYERS\n");
        for (int i=0; i<topUserName.size(); i++) {
            String name = topUserName.get(i);
            int score = topUserMaxScore.get(i);
            sb.append(String.format("%1d. %s:\t %9d\n", i+1, name, score));
        }
        textArea.setText(sb.toString());
    }
}
