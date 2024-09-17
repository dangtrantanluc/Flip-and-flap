package view;

import controller.IController;

import javax.swing.*;
import java.awt.*;

/**
 * Lớp panel chứa các màn chơi theo cấp độ.
 * Chuyển màn sau khi chơi thắng.
 */
public class PlayPanels extends JPanel {
    private PlayPanel curPlayPanel;
    private IController gameController;

    public PlayPanels(IController gameController) {
        this.gameController= gameController;
        this.setLayout(new CardLayout());
        curPlayPanel = new PlayPanel(gameController);
        setSize(curPlayPanel.getSize());
        add(curPlayPanel,gameController.getLevelUser()+"");
    }
    // Chức năng chuyển màn
    public void newPlayGame() {
        curPlayPanel= new PlayPanel(this.gameController);
        this.add(curPlayPanel,gameController.getLevelUser()+"");
        CardLayout cardLayout= (CardLayout) this.getLayout();
        cardLayout.show(this,gameController.getLevelUser()+"");
    }
    // mở hết các thẻ
    public void openAll() {
        curPlayPanel.openAll();
    }
    // đóng hết các thẻ.
    public void closeAll() {
        curPlayPanel.closeAll();
    }
}
