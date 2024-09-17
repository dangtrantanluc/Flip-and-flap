package model;

import java.util.List;

public interface SystemObserver {
    void update(List<String> topUserName, List<Integer> topUserMaxScore);

}
