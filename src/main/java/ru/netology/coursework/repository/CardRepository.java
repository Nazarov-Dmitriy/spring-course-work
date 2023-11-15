package ru.netology.coursework.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import ru.netology.coursework.loger.Loger;
import ru.netology.coursework.model.ModelCard;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class CardRepository  {
    @Autowired
    MongoTemplate mongoTemplate;

    @Value("${percentTransfer}")
    private int percentTransfer;
    public void addCars() {
        ModelCard result = getCard(1111_1111_1111_1111L);
        if (result == null) {
            System.out.println("Data creation started...");
            Loger.write("INFO", "Data creation started...");
            mongoTemplate.save(new ModelCard(111, 1111_1111_1111_1111L, "11/24"));
            mongoTemplate.save(new ModelCard(222, 2222_2222_2222_2222L, "11/24"));
            mongoTemplate.save(new ModelCard(333, 3333_3333_3333_3333L, "11/24"));
            mongoTemplate.save(new ModelCard(444, 4444_4444_4444_4444L, "11/24"));
            mongoTemplate.save(new ModelCard(555, 5555_5555_5555_5555L, "11/24"));
            mongoTemplate.save(new ModelCard(666, 6666_6666_6666_6666L, "11/24"));
            System.out.println("Data creation complite...");
            Loger.write("INFO", "Data creation complite...");

        }
    }

    public ModelCard getCard(long CardNumber) {
        Query searchCard = new Query(where("cardFromNumber").is(CardNumber));
        return mongoTemplate.findOne(searchCard, ModelCard.class);
    }

    public void changeBalans(long cardFrom, long cardTo, int amount) {
        ModelCard cardFromNumber = getCard(cardFrom);
        ModelCard cardToNumber = getCard(cardTo);

        var cardFromAmount = amount + (amount * percentTransfer) / 100;

        cardFromNumber.setBalans(cardFromAmount, "minus");
        cardToNumber.setBalans(amount, "plus");

        mongoTemplate.updateFirst(query(where("cardFromNumber").is(cardFrom)), Update.update("balans", cardFromNumber.getBalans()), ModelCard.class);
        mongoTemplate.updateFirst(query(where("cardFromNumber").is(cardTo)), Update.update("balans", cardToNumber.getBalans()), ModelCard.class);
    }
}
