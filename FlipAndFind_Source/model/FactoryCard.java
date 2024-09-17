package model;

public class FactoryCard implements Factory{
    private ACard card;

    public FactoryCard() {
    }
    // tạo các thẻ theo điểm số
    @Override
    public ACard createCard(int valid) {
        if(valid<10){
            card= new LowPointCard(valid);
        }
        else card= new HighPointCard(valid);
        return card;
    }


}
