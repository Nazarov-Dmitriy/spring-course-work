package ru.netology.coursework.DTO;

public class AmountData {
    public final String currency;
    public final int value;

    public AmountData(String currency, int value) {
        this.currency = currency;
        this.value = value;
    }

    public String getCurrency() {
        return currency;
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "AmountData{" +
                "currency='" + currency + '\'' +
                ", value=" + value +
                '}';
    }
}
