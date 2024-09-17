package controller;

import model.*;
import view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameController implements IController {
    //quản lý hệ thống trò chơi
    private ISystemGame systemGame;
    // quản lý người chơi
    private IUser user;
    // quản lý thao tác chơi
    private ActionWhenPlay actionWhenPlay;
    // quản lý thời gian chơi
//    private TimerAction timerAction;
    // chuyển màn hình chơi
    private MainPanel mainPanel;
    // thao tác màn hình chơi
    private GamePanel gamePanel;
    // đăng nhập
    private SignInPanel signInPanel;
    //welcome panel
    private WelcomePanel welcomePanel;
    //

    // hết lượt chơi
    private WinAllPanel winAllPanel;
    // count time
    private int count;

    public GameController(ISystemGame systemGame) {
        this.systemGame = systemGame;
        initView();
    }

    private void initView() {
        welcomePanel = new WelcomePanel(this);
        mainPanel = new MainPanel(welcomePanel);
        new FlipAndFind("Flip and find!!!", mainPanel);
        count = 0;
    }

    @Override
    public ActionListener buttonPlayButton() {
        return actionWhenPlay;
    }

    @Override
    public void switchPanelAction(JTextField field) {
        String nameUser = field.getText();
        if (nameUser.equals("")) {
            signInPanel.setError();
        } else {
            user = new User(nameUser);
            systemGame.addUser(user);
            actionWhenPlay = new ActionWhenPlay(this);
            gamePanel = new GamePanel(this);
            mainPanel.add(gamePanel, "game");
            this.systemGame.notifySystemObserver();
            CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
            cardLayout.show(mainPanel, "game");
        }
    }

    @Override
    public void helpButtonAction() {
        Thread t = new Thread() {
            @Override
            public void run() {
                try {
                    gamePanel.openAllCard();
                    Thread.sleep(2000);
                    gamePanel.closeAllCard();
                    user.downScoreForHelp();
                    user.notifyUserObserver();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        t.start();
    }

    @Override
    public boolean checkForAllAction(int i, int j) {
        return getCardAtIndex(i, j).checkForAllAction();
    }

    public ACard getCardAtIndex(int i, int j) {
        return user.getCardAtIndex(i, j);
    }

    @Override
    public void addUserObserver(UserObserver observer) {
        user.addUserObserver(observer);
    }

    @Override
    public void addSystemObserver(SystemObserver observer) {
        systemGame.addSystemObserver(observer);
    }

    @Override
    public IUser getUser() {
        return user;
    }

    @Override
    public int getLevelUser() {
        return user.getLevel();
    }

    @Override
    public void resetImage(int width, int height) {
        user.reSized(width, height);
    }

    @Override
    public void upRound() {
        user.levelUp();
        if (getLevelUser()>= IUser.NUM_OF_LEVEL) {
            switchPaneWin();
            return;
        }else {
            user.notifyUserObserver();
            this.gamePanel.nextGame();
            systemGame.notifySystemObserver();
        }
    }

    @Override
    public String getName() {
        return user.getName();
    }

    @Override
    public int getX() {
        return user.getX();
    }

    @Override
    public int getY() {
        return user.getY();
    }

    @Override
    public int getScore() {
        return user.getScore();
    }

    @Override
    public int getMaxScore() {
        return user.getMaxScore();
    }

    @Override
    public boolean isFlip(int locationX, int locationY) {
        return getCardAtIndex(locationX, locationY).isFlip();
    }

    @Override
    public ImageIcon getNullImage(int locationX, int locationY) {
        return getCardAtIndex(locationX, locationY).getNullIcon();
    }

    @Override
    public ImageIcon getIcon(int locationX, int locationY) {
        return getCardAtIndex(locationX, locationY).getIcon();
    }

    @Override
    public ImageIcon getBackGround(int locationX, int locationY) {
        return getCardAtIndex(locationX, locationY).getBgrIcon();
    }

    @Override
    public void quitAction() {
        int pane = JOptionPane.showConfirmDialog(gamePanel, "Muốn thoát game thiệt hong?", "QUIT", -1);
        if (pane == 0) {
            removeUserObserver();
            mainPanel.remove(gamePanel);
        }
    }

    @Override
    public void quitAllLevels() {
        int pane = JOptionPane.showConfirmDialog(gamePanel, "Chơi lại từ đầu hong?", "Play Back", -1);
        if (pane == 0) {
            removeUserObserver();
            mainPanel.remove(winAllPanel);
            mainPanel.remove(gamePanel);
        }
    }

    public void removeUserObserver() {

    }

    @Override
    public void switchPaneLogIn() {
        signInPanel = new SignInPanel(this);
        mainPanel.add(signInPanel, "Sign in");
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "Sign in");
    }

    @Override
    public void switchPaneWin() {
        gamePanel.stopTimer(); // dừng trc khi chuyển
        winAllPanel = new WinAllPanel(this);
        mainPanel.add(winAllPanel, "Out game");
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "Out game");

    }

    @Override
    public ActionListener checkTime() {
        return e -> {
            count += 1000;
            gamePanel.updateTimer(gamePanel.getTimePanel().setTimeRemaining(20000 * getX() * getY() - count));
            if (count == 20000 * getX() * getY()) {
                gamePanel.stopTimer();
                JOptionPane.showMessageDialog(getMainPanel(), "Lose with: " + getScore(), "Lose :<", JOptionPane.INFORMATION_MESSAGE);
                count = 0;
                mainPanel.remove(gamePanel);
            }
        };
    }

    public MainPanel getMainPanel() {
        return mainPanel;
    }
}
