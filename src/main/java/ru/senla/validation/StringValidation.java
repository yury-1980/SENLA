package ru.senla.validation;

public class StringValidation {

    public static final String regCard = "^(\\d{4}-\\d{4}-\\d{4}-\\d{4})$";
    public static final String regPin = "^(\\d{4})$";
    public static final String regNumMenu = "^(1|2|3|4)$";
    public static final String regWithdraw = "^([1-9]\\d{0,4}|100000)$";
    public static final String regMaxAmount = "^([1-9]\\d{0,5}|1000000)$";
}
