package model;

import java.util.*;

public class RoundGame implements IRoundGame{
    // tạo hàng x theo cấp độ chơi
    private int x;
    // tạo cột y theo cấp độ chơi
    private int y;
    // tạo ma trận các valid của thẻ
    private int[][] matrix;
    // tạo ma trận các thẻ
    private ACard[][] cards;
    // tạo thẻ có điểm dựa vào valid của nó
    private Factory factoryCard;

    public RoundGame(int level) {
        this.x=AXIS_X[level];
        this.y=AXIS_Y[level];
        factoryCard= new FactoryCard();
        iconIndex(this.x*this.y/2);// cai nay co trong pt createMatrix
        createMatrix();
        createCards();
    }
    // tạo ra các hình theo ma trận
    private void createCards() {
        this.cards = new ACard[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                cards[i][j] = factoryCard.createCard(matrix[i][j]);
            }
        }
    }
    // tạo ma trận index các hình
    private void createMatrix() {
        matrix = new int[x][y];
        Set<Integer> imageIndex = iconIndex(x * y / 2);// ne
        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(imageIndex);
        list.addAll(imageIndex);
        Collections.shuffle(list);
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                matrix[i][j] = list.get(y * i + j);
            }
        }
    }
    // lấy ngẫu nhiên các hình trong thư viện
    public Set<Integer> iconIndex(int size) {
        Set imageIndex = new HashSet<>();
        for (int i = 0; i < size; i++) {
            Random rd = new Random();
            int index = rd.nextInt(NUM_OF_IMAGE);
            if (!imageIndex.add(index)) i--;
        }
        return imageIndex;
    }
    // lấy dòng ma trận
    @Override
    public int getX() {
        return x;
    }
    // lấy cột ma trận
    @Override
    public int getY() {
        return y;
    }
    // Lấy thẻ ở vị trí (i,j)
    @Override
    public ACard getCardAtIndex(int x, int y) {
        return this.cards[x][y];
    }
    // thay đổi kích thước ma trận theo cấp độ chơi
    @Override
    public void reSized(int width, int height) {
        for (ACard[] c: cards){
            for (ACard card:c){
                card.reSized(width,height);
            }
        }
    }
}
