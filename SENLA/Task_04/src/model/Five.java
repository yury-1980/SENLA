package model;

public class Five extends Number {
    private String s = "*";

    public void setS(String s) {
        this.s = s;
    }

    @Override
    public void str1() {
        System.out.print(s + s + s + "  ");
    }

    @Override
    public void str2() {
        System.out.print(s + " " + " " + "  ");
    }

    @Override
    public void str3() {
        System.out.print(s + s + s + "  ");
    }

    @Override
    public void str4() {
        System.out.print(" " + " " + s + "  ");
    }

    @Override
    public void str5() {
        System.out.print(s + s + s + "  ");
    }
}
