package view;

import javax.swing.*;
import java.awt.*;

/**
 * Panel dùng card layout để chuyển giao giữa các màn hình.
 */
public class MainPanel extends JPanel {
    public static final int WIDTH = 920;
    public static final int HEIGHT = 500;
    private WelcomePanel welcomePanel;
    public MainPanel(WelcomePanel welcomePanel) {
        setSize(new Dimension(this.WIDTH,this.HEIGHT));
        this.welcomePanel = welcomePanel;
        setLayout(new CardLayout());
        this.add(this.welcomePanel, "welcome");
    }
}
