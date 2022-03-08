package model;

public class Subject {
    private int volume;
    private int price;
    private int minCost;// Стоимость одной целой части предмета

    public Subject(int volume, int price) {
        this.volume = volume;
        this.price = price;
        this.minCost = price / volume;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getMinCost() {
        return minCost;
    }
}
