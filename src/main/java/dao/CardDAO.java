package dao;

import model.Card;

public class CardDAO {
    public void addCard(Card card){
        String sql = "INSERT INTO Card (username, card) VALUES (?, ?)";
    }
}
