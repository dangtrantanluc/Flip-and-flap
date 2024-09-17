package view;
/**
 * Lớp màn chơi chính
 */

import controller.IController;

import javax.swing.*;
import java.awt.*;

public class PlayPanel extends JPanel {
    private IController controller;
    public static final int WIDTH=700;
    public static final int HEIGHT = 350;
    // ma trận các thẻ
    private PlayButton[][] buttons;
    // số dòng ma trận
    private int x;
    // số cột ma trận
    private int y;

    public PlayPanel(IController controller) {
        this.controller= controller;
        this.x= controller.getX();
        this.y=controller.getY();
        buttons = new PlayButton[x][y];
        this.setSize(new Dimension(WIDTH,HEIGHT));
        this.setBackground(Color.decode("#EFE9DB"));
        this.setBorder(BorderFactory.createLineBorder(Color.DARK_GRAY, 2));
        setLayout(new GridLayout(x, y));
        initButton();
    }

    public void initButton() {
        int dx = (WIDTH / y);
        int dy = (HEIGHT / x);
        // thay đổi kích thước các thẻ hình
        controller.resetImage(dx,dy);
        // tạo các thẻ hình trong màn
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                PlayButton button = new PlayButton(controller,i, j);
                buttons[i][j] = button;
                button.addActionListener(controller.buttonPlayButton());
                add(button);
            }
        }
    }
    // mở tất cả các thẻ
    public void openAll() {
        for (int i=0;i<x;i++){
            for (int j=0;j<y;j++){
                // kiểm tra thẻ trong trạng thái valid khác -1 và chưa lật.
                if(controller.checkForAllAction(i,j)){
                    buttons[i][j].open();
                }
            }
        }
    }
    // đóng tất cả các thẻ hình
    public void closeAll() {
        for(int i=0;i<x;i++){
            for (int j=0;j<y;j++){
                // kiểm tra thẻ trong trạng thái valid khác -1 và chưa lật.
                if(controller.checkForAllAction(i,j)){
                    buttons[i][j].close();
                }
            }
        }
    }
}
