package view;
/**
 * Panel mở đầu vào game
 */

import controller.IController;

import javax.swing.*;
import java.awt.*;

public class WelcomePanel extends JPanel {
    JLayeredPane layer;
    public static final int WIDTH = 920;
    public static final int HEIGHT = 550;

    public WelcomePanel(IController controller) {
        initPanel(controller);
    }

    private void initPanel(IController controller) {
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.setLayout(null);
        // Tên Game
        JLabel nameGame = new JLabel("Welcome to find something relax");
        nameGame.setBounds(this.getWidth()/2-260, 40, 800, 100);
        nameGame.setFont(new Font("Time New Roman", Font.BOLD, 30));
        nameGame.setForeground(new Color(255,102,102));
        // Nút chơi
        JButton playButton = new JButton("Join Game");
        playButton.setBounds(this.getWidth()/2-150, 250, 300, 50);
        playButton.setFocusable(false);
        playButton.setFont(new Font("Time New Roman", Font.BOLD, 20));
        playButton.setBackground(new Color(242, 194, 220));
        playButton.addActionListener(e-> controller.switchPaneLogIn());
        // Lấy hình background
        ImageIcon bgrImage = new ImageIcon("src\\imageIcon\\bgr.png");
        Image bgr = bgrImage.getImage();
        bgrImage = new ImageIcon(bgr);
        // set background
        JLabel backgroundLabel = new JLabel(bgrImage);
        backgroundLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        // sắp xết các thành phần lên main
        layer = new JLayeredPane();
        layer.setBounds(0, 0, this.getWidth(), this.getHeight());
        layer.add(nameGame, JLayeredPane.MODAL_LAYER);
        layer.add(playButton, JLayeredPane.MODAL_LAYER);
        layer.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);
        //
        add(layer);
    }
}
