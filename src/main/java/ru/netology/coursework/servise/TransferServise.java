package ru.netology.coursework.servise;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.netology.coursework.model.ModelCard;
import ru.netology.coursework.repository.CardRepository;
import ru.netology.coursework.repository.TransferRepository;

@Service
public class TransferServise {
    private @Autowired CardRepository cardRepository;
    private @Autowired TransferRepository transferRepository;

    public ModelCard getCard(long numberCard) {
        return cardRepository.getCard(numberCard);
    }

    public String addTransfer(long cardFromNumber, long cardToNumber, int amount) {
        cardRepository.changeBalans(cardFromNumber, cardToNumber, amount);
        return transferRepository.addTransfer(cardFromNumber, cardToNumber, amount);
    }

    public String confirmOperation(String operationId) {
        return transferRepository.findOpretation(operationId);
    }
}
