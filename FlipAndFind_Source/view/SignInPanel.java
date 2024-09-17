package view;

import controller.IController;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignInPanel extends JPanel {
    public static final int WIDTH = 920;
    public static final int HEIGHT = 550;
    // tạo một label thông báo lỗi khi không nhập tên
    JLabel errSelected = new JLabel();
    // nhập tên người chơi
    JTextField nameField;
    // nút Chơi
    JButton playBtn;
    //
    JLayeredPane layer;
    private IController gameController;

    public SignInPanel(IController gameController) {
        this.gameController = gameController;
        setLayout(null);
        setSize(new Dimension(this.WIDTH, this.HEIGHT));
        initPanel(gameController);
    }

    public void initPanel(IController controller) {
        // set background
        ImageIcon bg = new ImageIcon("src\\imageIcon\\levelBgr.png");
        Image background = bg.getImage().getScaledInstance(this.getWidth(), this.getHeight(), Image.SCALE_SMOOTH);
        bg = new ImageIcon(background);
        JLabel bgLabel = new JLabel(bg);
        bgLabel.setBounds(0, 0, this.getWidth(), this.getHeight());
        // tạo panel chính
        JPanel mainPanel = new JPanel();
        mainPanel.setSize(this.getSize());
        mainPanel.setLayout(null);
        // Tạo phần ghi chú
        JLabel noticeLabel = new JLabel("Fill a cute nickname :>> ");
        noticeLabel.setFont(new Font("Comic Sans MS",Font.ITALIC,20));
        noticeLabel.setBounds(this.getWidth() / 2 - 100, 100, this.getWidth(), 30);
        noticeLabel.setForeground(Color.BLACK);
        // tạo phần thông tin người chơi
        nameField = new JTextField();
        nameField.setEditable(true);
        LineBorder border = new LineBorder(Color.BLACK, 4, true);
        nameField.setBorder(border);
        nameField.setBounds(this.getWidth() / 2 - 150, 150, 300, 40);
        // Tạo nút chơi
        playBtn = new JButton("Play");
        playBtn.setBounds(this.getWidth() / 2 - 150, 250, 300, 40);
        playBtn.setFont(new Font("Comic Sans MS", Font.BOLD, 25));
        playBtn.setFocusable(false);
        playBtn.setBackground(Color.pink);
        playBtn.addActionListener(e -> {
            this.gameController.switchPanelAction(nameField);
        });
        // tạo label thông báo lỗi chưa nhập tên
        errSelected.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        errSelected.setBounds(this.getWidth() / 2 - 150, 200, 300, 40);
        errSelected.setForeground(Color.RED);
        // layer pane
        layer = new JLayeredPane();
        layer.setBounds(0, 0, this.getWidth(), this.getHeight());
        layer.add(noticeLabel, JLayeredPane.POPUP_LAYER);
        layer.add(nameField, JLayeredPane.POPUP_LAYER);
        layer.add(playBtn, JLayeredPane.POPUP_LAYER);
        layer.add(errSelected, JLayeredPane.POPUP_LAYER);
        layer.add(bgLabel, JLayeredPane.DEFAULT_LAYER);
        // thêm layer vào main
        mainPanel.add(layer);
        this.add(mainPanel);
    }

    // phương thức cập nhật lỗi nhập tên trên hệ thống.
    public void setError() {
        errSelected.setText("Name is unavailable!!");
        nameField.setText("");
    }

}
