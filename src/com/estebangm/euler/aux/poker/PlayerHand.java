package com.estebangm.euler.aux.poker;

import static com.estebangm.euler.aux.poker.PlayerHand.HandRanking.ROYAL_FLUSH;

public class PlayerHand {
    public static final char JACK = 'J';
    public static final char QUEEN = 'Q';
    public static final char KING = 'K';
    public static final char ACE = 'A';

    public static final int JACK_VALUE = 11;
    public static final int QUEEN_VALUE = 12;
    public static final int KING_VALUE = 13;
    public static final int ACE_VALUE = 14;

    public enum HandRanking {
        ROYAL_FLUSH(100),
        STRAIGHT_FLUSH(90),
        FOUR_OF_A_KIND(80),
        FULL_HOUSE(70),
        FLUSH(60),
        STRAIGHT(50),
        THREE_OF_A_KIND(40),
        TWO_PAIRS(30),
        ONE_PAIR(20),
        HIGH_CARD(10);

        private int value;
        HandRanking(int value) {
            this.value = value;
        }
    }

    public HandRanking evaluateHand(PlayerCards playerCards) {
        if (isRoyalFlush(playerCards)) {
            return ROYAL_FLUSH;
        }
        return null;
    }

    private boolean isRoyalFlush(PlayerCards playerCards) {
        if (!allAreSameSuit(playerCards)) {
            return false;
        }
        if (playerCards.containsCardValue(10)
                && playerCards.containsCardValue(JACK_VALUE)
                && playerCards.containsCardValue(QUEEN_VALUE)
                && playerCards.containsCardValue(KING_VALUE)
                && playerCards.containsCardValue(ACE_VALUE)) {
            return true;
        }
        return false;
    }

    private boolean isStraightFlush(PlayerCards playerCards) {
        if (!allAreSameSuit(playerCards)) {
            return false;
        }

        return false;
    }

    private boolean allAreSameSuit(PlayerCards playerCards) {
        for (int i = 0; i < playerCards.CARDS_IN_HAND - 1; i++) {
            if (playerCards.getCards()[i].getSuit() != playerCards.getCards()[i+1].getSuit()) {
                return false;
            }
        }
        return true;
    }

    public static void main (String [] args) {
        System.out.println("que pasa");
    }
}
