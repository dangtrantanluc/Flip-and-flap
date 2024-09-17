package model;

public interface ISystemGame extends SystemObserverable {
    // 10 người đầu tiên sẽ hiện trên panel
    int NUM_OF_TOP_PLAYER = 10;
    // thêm người chơi
    void addUser(IUser user);
    // thông báo đến hệ thống
    void notifySystemObserver();
    // thêm phần hệ thống
    void addSystemObserver(SystemObserver systemObserver);
    // xóa phần hệ thống
    void removeSystemObserver(SystemObserver o);


}
