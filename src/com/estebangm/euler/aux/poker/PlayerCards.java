package com.estebangm.euler.aux.poker;

public class PlayerCards {
    public static final int CARDS_IN_HAND = 5;
    private Card[] cards;

    public PlayerCards() {
         cards = new Card[CARDS_IN_HAND];
    }

    public Card[] getCards() {
        return cards;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        for (int i = 0; i < CARDS_IN_HAND; i++) {
            if (cards[i] == null) {
                cards[i] = card;
                break;
            }
        }
    }

    public boolean containsCardValue(int value) {
        for (Card card : cards) {
            if (value == card.getNumber()) {
                return true;
            }
        }
        return false;
    }
}
