package model;

import java.util.ArrayList;
import java.util.List;

public class Safe {
    private int volume;
    private int price;
    List<Subject> safeList = new ArrayList<>();

    public Safe(int volume) {
        this.volume = volume;
    }

    public void setSafeList(Subject subject) {
        this.safeList.add(subject);
        this.volume = getVolume() - subject.getVolume();
        this.price = getPrice() + subject.getPrice();
    }

    public int getVolume() {
        return volume;
    }

    public int getPrice() {
        return price;
    }

    public List<Subject> getSafeList() {
        return safeList;
    }
}
