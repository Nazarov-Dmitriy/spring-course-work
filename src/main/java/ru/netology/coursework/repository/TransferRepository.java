package ru.netology.coursework.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import ru.netology.coursework.exception.ErrorTransfer;
import ru.netology.coursework.model.ModelTransfer;

import java.util.Objects;

@Repository
public class TransferRepository {
    @Autowired
    MongoTemplate mongoTemplate;

    @Value("${percentTransfer}")
    private int percentTransfer;

    public String addTransfer(long cardFromNumber, long cardToNumber, int amount) {
        var commission = amount * percentTransfer / 100;
        try {
            var document = mongoTemplate.save(new ModelTransfer(cardFromNumber, cardToNumber, amount, commission));
            return document.getId();
        } catch (Exception e) {
            throw new ErrorTransfer("Error customer message");
        }
    }

    public String findOpretation(String operationId) {
        try {
            return Objects.requireNonNull(mongoTemplate.findById(operationId, ModelTransfer.class)).getId();
        } catch (Exception e) {
            throw new ErrorTransfer("Error customer message");
        }
    }
}