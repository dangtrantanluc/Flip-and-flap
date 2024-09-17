package model;

public interface UserObserverable {
    void addUserObserver(UserObserver o);
    void removeUserObserver(UserObserver o);
    void notifyUserObserver();
}
