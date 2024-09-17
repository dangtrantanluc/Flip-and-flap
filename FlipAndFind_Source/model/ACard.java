package model;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public abstract class ACard {
    // gía trị của thẻ
    private int valid;
    // biến trạng thái cho phép hình lật hay chưa
    private boolean flip;
    // hình bên trong của thẻ.
    private ImageIcon icon;
    // hình thẻ đã lật.
    private ImageIcon nullIcon;
    // hình chưa lật.
    private ImageIcon bgrIcon;
    //


    public ACard(int valid) {
        this.valid = valid;
        this.flip = true;
        this.icon = new ImageIcon("src\\flatIcon\\"+valid+".png");
        this.nullIcon = new ImageIcon("src\\flatIcon\\null_bg.png");
        this.bgrIcon = new ImageIcon("src\\flatIcon\\open.png");
    }
    // lấy hình của thẻ ảnh
    public ImageIcon getIcon(){
        return icon;
    }
    // gán giá trị để hình không lật nữa
    public void openTrue(){
        flip=false;
        valid=-1;
    }
    // kiểm tra hình lật chưa
    public boolean isFlip(){
        return flip;
    }
    // lấy giá trị hình
    public int getValid(){
        return valid;
    }
    // set lại màn chơi (thêm nhiều hình hơn)
    public void reSized(int width, int height){
        icon= imageIcon(icon.getImage(),width,height);
        bgrIcon= imageIcon(bgrIcon.getImage(),width,height);
        nullIcon= imageIcon(nullIcon.getImage(),width,height);
    }
    //
    public ImageIcon getNullIcon(){return nullIcon;}
    private ImageIcon imageIcon(Image image, int width, int height) {
        return new ImageIcon(image.getScaledInstance(width,height,
                Image.SCALE_SMOOTH));
    }
    //
    public ImageIcon getBgrIcon(){return bgrIcon;}
    //
    public boolean checkForAllAction(){
        return valid!=-1 && flip;
    }
    //so sánh hai hình

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ACard card = (ACard) o;
        return valid == card.valid && icon.equals(card.icon);
    }
    // lấy điểm
    public abstract int getScore();
}
