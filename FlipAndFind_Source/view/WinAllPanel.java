package view;

import controller.IController;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class WinAllPanel extends JPanel {
    IController gameController;
    JButton playBack;


    public WinAllPanel(IController gameController) {
        this.gameController = gameController;
        setLayout(null);
        setSize(920, 500);

        ImageIcon imgBG = new ImageIcon("src\\imageIcon\\winBG.png");
        Image img = imgBG.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        imgBG = new ImageIcon(img);

        JLabel background = new JLabel(imgBG);
        background.setBounds(0, 0, this.getWidth(), this.getHeight());

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBounds(0, 0, this.getWidth(), this.getHeight());

        JLayeredPane layer = new JLayeredPane();
        layer.setBounds(0, 0, this.getWidth(), this.getHeight());
        //
        JLabel winLabel = new JLabel("Bạn đã chơi hết màn rồi!!!");
        winLabel.setFont(new Font("Nunito", Font.PLAIN, 25));
        winLabel.setBounds(this.getWidth()/2-150, 30, this.getWidth(), 50);
        winLabel.setForeground(Color.decode("#FFFFFF"));
        JLabel winScore = new JLabel("Bạn nhận được: " + this.gameController.getScore() + " điểm ");
        winScore.setFont(new Font("Nunito", Font.PLAIN, 25));
        winScore.setBounds(this.getWidth()/2-150, 80, this.getWidth(), 50);
        winScore.setForeground(Color.decode("#FFFFFF"));
        //
        playBack= new JButton("Chơi lại từ đầu");
        playBack.setFont(new Font("Nunito", Font.BOLD, 25));
        playBack.setForeground(Color.decode("#FFFFFF"));
        setEvent();
        //
        playBack.setBounds(this.getWidth()/2-180, 200, 300, 70);
        playBack.setBackground(new Color(253, 188, 207));
        //-
        layer.add(playBack, JLayeredPane.DRAG_LAYER);
        layer.add(winLabel, JLayeredPane.DRAG_LAYER);
        layer.add(winScore,JLayeredPane.DRAG_LAYER);
        layer.add(background, JLayeredPane.DEFAULT_LAYER);

        mainPanel.add(layer);
        add(mainPanel);
    }

    private void setEvent() {
        playBack.setFocusable(false);
        playBack.addActionListener(e -> {
           this.gameController.quitAllLevels();
        });
    }
}
