package controller;

import model.ACard;
import model.IUser;
import view.PlayButton;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionWhenPlay implements ActionListener {
    private int status;
    private PlayButton predict1;
    private PlayButton predict2;
    private ACard c1, c2;
    private IUser user;
    private GameController gameController;

    public ActionWhenPlay(GameController gameController) {
        this.gameController = gameController;
        this.user = this.gameController.getUser();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (status == 0) {
            predict1 = (PlayButton) e.getSource();
            c1 = gameController.getCardAtIndex(predict1.getLocationX(), predict1.getLocationY());
            if (c1.isFlip()) {
                predict1.open();
                status = 1;
            }
            return;
        } else if (status == 1) {
            predict2 = (PlayButton) e.getSource();
            c2 = gameController.getCardAtIndex(predict2.getLocationX(), predict2.getLocationY());
            if (c2.isFlip()) {
                predict2.open();
                status = 2;
                new Thread() {
                    @Override
                    public void run() {
                        try {

                            Thread.sleep(500);
                            actionWhenPlay();
                            Thread.sleep(500);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }.start();
            }
        }
    }

    public void actionWhenPlay() {
        if (status == 2) {
            boolean checkCorrect = check();
            // do animations
            try {
                if (checkCorrect) {
                    animationFlips();
                    if (checkWon()) {
                        JOptionPane.showMessageDialog(gameController.getMainPanel(),"Win with: "+ gameController.getScore(),"Congratulation!!!",JOptionPane.INFORMATION_MESSAGE);
                        this.gameController.upRound();
                    }
                } else{
                    animationClose();

                }
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            status = 0;
        }
    }

    private boolean check() {
        if (c1.isFlip() && c2.isFlip()) {
            if (!c1.equals(c2)) {
                if (c1.getValid() == c2.getValid()) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkWon() {
        for (int i = 0; i < gameController.getX(); i++) {
            for (int j = 0; j < gameController.getY(); j++) {
                if (gameController.isFlip(i, j)) return false;
            }
        }
        return true;
    }

    private void animationClose() throws InterruptedException {
        Thread.sleep(500);
        predict1.close();
        predict2.close();
        user.downScore();
        user.notifyUserObserver();
    }

    private void animationFlips() throws InterruptedException {
        for (int i = 0; i < 3; i++) {
            predict1.close();
            predict2.close();
            Thread.sleep(100);
            predict1.open();
            predict2.open();
            Thread.sleep(100);
        }
        setImage();
        user.upScore(predict1.getLocationX(), predict1.getLocationY());
        user.notifyUserObserver();
    }

    private void setImage() {
        predict1.setNoIcon();
        predict2.setNoIcon();
        c1.openTrue();
        c2.openTrue();
    }
}
