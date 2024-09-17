package view;

import controller.IController;

import javax.swing.*;

/**
 * Panel thẻ chơi
 */
public class PlayButton extends JButton {
    // vị trí của thẻ trong ma trận
    private int locationX;
    private int locationY;
    private IController controller;

    public PlayButton(IController controller,int locationX, int locationY) {
        this.controller= controller;
        this.locationX = locationX;
        this.locationY = locationY;
        this.close(); // các thẻ tạo ra đều ở trạng thái đóng.
    }
    // vị trí dòng X của thẻ
    public int getLocationX() {
        return locationX;
    }
    // vị trí cột Y của thẻ
    public int getLocationY() {
        return locationY;
    }
    // gán icon đã lật cho thẻ
    public void setNoIcon(){
        setIcon(controller.getNullImage(locationX,locationY));
    }
    // phương thức mở thẻ
    public void open(){
        setIcon(controller.getIcon(locationX,locationY));
    }
    // phương thức đóng thẻ.
    public void close(){
        setIcon(controller.getBackGround(locationX,locationY));
    }
}
