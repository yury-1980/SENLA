package ru.senla.validation;

public class StringValidationConst {

    public static final String REG_CARD = "^(\\d{4}-\\d{4}-\\d{4}-\\d{4})$";
    public static final String REG_PIN = "^(\\d{4})$";
    public static final String REG_NUM_MENU = "^(1|2|3|4)$";
    public static final String REG_WITHDRAW = "^([1-9]\\d{0,4}|100000)$";
    public static final String REG_MAX_AMOUNT = "^([1-9]\\d{0,5}|1000000)$";
    public static final Long BLOCKING_DAYS = 1L;
    public static final Double LIMIT = 1000000.0;
}
