package ru.netology.coursework.controller;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.coursework.DTO.ConfirmOperationDto;
import ru.netology.coursework.DTO.TransferDto;
import ru.netology.coursework.exception.BadRequest;
import ru.netology.coursework.loger.Loger;
import ru.netology.coursework.model.ModelCard;
import ru.netology.coursework.servise.TransferServise;

@CrossOrigin(origins = "https://serp-ya.github.io")
@RestController
public class MoneyTransferController {
    @Value("${percentTransfer}")
    private int percentTransfer;
    final private TransferServise servise;

    public MoneyTransferController(TransferServise servise) {
        this.servise = servise;
    }

    @PostMapping("/transfer")
    public ResponseEntity<?> postTransfer(@RequestBody TransferDto body) {
        System.out.println(body);
        ModelCard cardFromNumber = servise.getCard(body.getCardFromNumber());
        ModelCard cardToNumber = servise.getCard(body.getCardToNumber());

        if (cardFromNumber != null
                && cardToNumber != null
                && cardFromNumber.getBalans() >= body.getAmount()
                && cardFromNumber.getCardFromCVV() == body.getCardFromCVV()
                && cardFromNumber.getCardFromValidTill().equals(body.getCardFromValidTill())
        ) {
            final var commission = (body.getAmount() * percentTransfer) / 100;

            var transferIdDb = servise.addTransfer(body.getCardFromNumber(), body.getCardToNumber(), body.getAmount());

            Loger.write("Message", "Перевод успешно совершен с карты " + body.getCardFromNumber() + " на карту " +
                    body.getCardToNumber() + " на сумму " + body.getAmount() + " руб." + " коммисия:" + commission);

            final var gson = new Gson();
            final var transferId = new ResponseTransfer(transferIdDb);
            final var response = gson.toJson(transferId);

            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            throw new BadRequest("Error input data");
        }
    }

    @PostMapping("/confirmOperation")
    public ResponseEntity<?> getConfirmOperation(@RequestBody ConfirmOperationDto body) {
        String confirmOperationId;
        if (!body.getCode().isEmpty() && !body.getOperationId().isEmpty()) {
            confirmOperationId = servise.confirmOperation(body.getOperationId());
        } else {
            throw new BadRequest("Error input data");
        }

        final var gson = new Gson();
        final var transferId = new ConfirmOperation(confirmOperationId);
        final var response = gson.toJson(transferId);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }
}
