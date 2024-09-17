package model;

public interface SystemObserverable {
    void addSystemObserver(SystemObserver o);
    void removeSystemObserver(SystemObserver o);
    void notifySystemObserver();
}
