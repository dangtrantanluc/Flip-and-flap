package view;
/**
 * Lớp chứa tên game : Flip And Find.
 */

import controller.IController;

import javax.swing.*;
import java.awt.*;

public class GameNamePanel extends JPanel {
    private JLabel jLabel;
    private final int WIDTH=700;
    private final int HEIGHT=100;
    private IController gameController;

    public GameNamePanel(IController gameController) {
        this.gameController=gameController;
        this.jLabel = new JLabel("Flip and Find!!");
        jLabel.setForeground(Color.WHITE);
        jLabel.setFont(new Font("Monospaced", Font.BOLD, 70));
        this.setSize(new Dimension(WIDTH,HEIGHT));
        this.setBackground(Color.decode("#4B533A"));
        this.add(jLabel);
    }
}
