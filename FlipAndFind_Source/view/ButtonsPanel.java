package view;
/**
 * Lớp panel chứa nút thoát + nút trợ giúp
 *
 */

import controller.IController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonsPanel extends JPanel {
    // nút thoát
    private JButton quitButton;
    // nút trợ giúp
    private JButton helpButton;
    private final int BUTTON_SIZE=90;
    private final int WIDTH=200;
    private final int HEIGHT=100;

    public ButtonsPanel(IController controller) {
        //nút trợ giúp người chơi
        helpButton= new JButton("HELP");
        helpButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        helpButton.setForeground(Color.black);
        helpButton.setBackground(Color.decode("#C3C6B1"));
        helpButton.setPreferredSize(new Dimension(BUTTON_SIZE-1, BUTTON_SIZE-1));
        helpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.helpButtonAction();
            }
        });
        // nút thoát trò chơi
        quitButton= new JButton("QUIT");
        quitButton.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        quitButton.setForeground(Color.white);
        quitButton.setBackground(Color.decode("#4B533A"));
        quitButton.setPreferredSize(new Dimension(BUTTON_SIZE-1, BUTTON_SIZE-1));
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.quitAction();
            }
        });
        //
        this.setSize(new Dimension(WIDTH, HEIGHT));
        this.add(helpButton);
        this.add(quitButton);
        setBackground(Color.LIGHT_GRAY);
    }
}
