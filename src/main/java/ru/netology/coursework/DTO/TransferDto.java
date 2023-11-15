package ru.netology.coursework.DTO;

public class TransferDto {
    private final int cardFromCVV;
    private final long cardFromNumber;
    private final String cardFromValidTill;
    private final long cardToNumber;
    private final AmountData amount;

    public TransferDto(int cardFromCVV, long cardFromNumber, String cardFromValidTill, long cardToNumber, AmountData amount) {
        this.cardFromCVV = cardFromCVV;
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
        this.cardToNumber = cardToNumber;
        this.amount = amount;
    }

    public int getCardFromCVV() {
        return cardFromCVV;
    }

    public long getCardFromNumber() {
        return cardFromNumber;
    }

    public String getCardFromValidTill() {
        return cardFromValidTill;
    }

    public long getCardToNumber() {
        return cardToNumber;
    }

    public int getAmount() {
        return amount.getValue();
    }

    @Override
    public String toString() {
        return "TransferDTo{" +
                "cardFromCVV=" + cardFromCVV +
                ", cardFromNumber=" + cardFromNumber +
                ", cardFromValidTill='" + cardFromValidTill + '\'' +
                ", cardToNumber=" + cardToNumber +
                ", amount=" + amount +
                '}';
    }
}


