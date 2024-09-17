package view;

import javax.swing.*;
import java.awt.*;

public class FlipAndFind extends JFrame {
    Toolkit defaultToolkit;
    private MainPanel mainPanel;
    public static final int WIDTH= 920;
    public static final int HEIGHT=550;
    public  FlipAndFind(String title,MainPanel mainPanel){
        init(title,mainPanel);
    }
    private void init(String title,MainPanel mainPanel){
        this.setTitle(title);
        this.setSize(this.WIDTH,this.HEIGHT);
        this.defaultToolkit= Toolkit.getDefaultToolkit();
        this.mainPanel= mainPanel;
        this.add(mainPanel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setIconImage(defaultToolkit.getImage("src\\imageIcon\\icon.png"));
        this.setResizable(false);
        setVisible(true);
    }


}
