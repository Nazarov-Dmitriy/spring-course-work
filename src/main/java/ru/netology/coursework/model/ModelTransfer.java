package ru.netology.coursework.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Date;

@Document(collection = "transferCardS")
public class ModelTransfer {
    @Id
    @MongoId
    @Getter
    private String id;
    @Getter
    private final long cardFromNumber;
    @Getter
    private final long cardToNumber;
    @Getter
    private int amount;
    @Getter
    @Setter
    private Date date = new Date();
    @Getter
    private final int commision;

    public ModelTransfer(long cardFromNumber, long cardToNumber, int amount, int commision) {
        this.cardFromNumber = cardFromNumber;
        this.cardToNumber = cardToNumber;
        this.amount = amount;
        this.commision = commision;
    }

    @Override
    public String toString() {
        return "ModelTransfer{" +
                "id='" + id + '\'' +
                ", cardFromNumber=" + cardFromNumber +
                ", cardToNumber=" + cardToNumber +
                ", amount=" + amount +
                ", date=" + date +
                ", commision=" + commision +
                '}';
    }
}
