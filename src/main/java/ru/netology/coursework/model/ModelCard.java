package ru.netology.coursework.model;

import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cards")
public class ModelCard {
    @Getter
        private final int cardFromCVV;
    @Getter
    private final long cardFromNumber;

    @Getter
    private final String cardFromValidTill;
    @Getter
    private int balans = 100_000;

    public ModelCard(int cardFromCVV, long cardFromNumber, String cardFromValidTill) {
        this.cardFromCVV = cardFromCVV;
        this.cardFromNumber = cardFromNumber;
        this.cardFromValidTill = cardFromValidTill;
    }

    public void setBalans(int value, String operation) {
        if (operation.equals("plus")) {
            this.balans = balans + value;
        }

        if (operation.equals("minus")) {
            this.balans = balans - value;
        }
    }

    @Override
    public String toString() {
        return "ModelCard{" +
                "cardFromCVV=" + cardFromCVV +
                ", cardFromNumber=" + cardFromNumber +
                ", cardFromValidTill='" + cardFromValidTill + '\'' +
                ", balans=" + balans +
                '}';
    }
}
