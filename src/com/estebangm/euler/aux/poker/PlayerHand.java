package com.estebangm.euler.aux.poker;

public class PlayerHand {
    public static final char TEN = 'T';
    public static final char JACK = 'J';
    public static final char QUEEN = 'Q';
    public static final char KING = 'K';
    public static final char ACE = 'A';

    public static final int TEN_VALUE = 10;
    public static final int JACK_VALUE = 11;
    public static final int QUEEN_VALUE = 12;
    public static final int KING_VALUE = 13;
    public static final int ACE_VALUE = 14;

    private enum HandRanking {
        ROYAL_FLUSH(100),
        STRAIGHT_FLUSH(90),
        FOUR_OF_A_KIND(80),
        FULL_HOUSE(70),
        FLUSH(60),
        STRAIGHT(50),
        THREE_OF_A_KIND(40),
        TWO_PAIRS(30),
        ONE_PAIR(20);

        private int value;
        HandRanking(int value) {
            this.value = value;
        }

        public static HandRanking getHandRankingFromValue(int value) {
            for (HandRanking handRanking : HandRanking.values()) {
                if (handRanking.value == value) {
                    return handRanking;
                }
            }
            return null;
        }
    }

    public static int evaluateHand(PlayerCards playerCards) {
        if (isRoyalFlush(playerCards)) {
            return HandRanking.ROYAL_FLUSH.value;
        }
        if (isStraightFlush(playerCards)) {
            return HandRanking.STRAIGHT_FLUSH.value;
        }
        if (isPoker(playerCards)) {
            return HandRanking.FOUR_OF_A_KIND.value;
        }
        if (isFullHouse(playerCards)) {
            return HandRanking.FULL_HOUSE.value;
        }
        if (allAreSameSuit(playerCards)) {
            return HandRanking.FLUSH.value;
        }
        if (isStraight(playerCards)) {
            return HandRanking.STRAIGHT.value;
        }
        if (hasThreeOfAKind(playerCards)) {
            return HandRanking.THREE_OF_A_KIND.value;
        }
        if (hasTwoPairs(playerCards)) {
            return HandRanking.TWO_PAIRS.value;
        }
        if (hasOnePair(playerCards)) {
            return HandRanking.ONE_PAIR.value;
        }
        return getHigherCard(playerCards);
    }

    private static boolean isRoyalFlush(PlayerCards playerCards) {
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

    private static boolean isStraightFlush(PlayerCards playerCards) {
        if (!allAreSameSuit(playerCards)) {
            return false;
        }
        if (isStraight(playerCards)) {
            return true;
        }
        return false;
    }

    private static boolean isPoker(PlayerCards playerCards) {
        int[] sortedCardValues = playerCards.getSortedCardsValues();
        if ((sortedCardValues[0] == sortedCardValues[1]
                && sortedCardValues[1] == sortedCardValues[2]
                && sortedCardValues[2] == sortedCardValues[3])
            || (sortedCardValues[1] == sortedCardValues[2]
                && sortedCardValues[2] == sortedCardValues[3]
                && sortedCardValues[3] == sortedCardValues[4])) {
            return true;
        }
        return false;
    }

    private static boolean isFullHouse(PlayerCards playerCards) {
        int[] sortedCardValues = playerCards.getSortedCardsValues();
        if ((sortedCardValues[0] == sortedCardValues[1]
                && sortedCardValues[1] == sortedCardValues[2]
                && sortedCardValues[3] == sortedCardValues[4])
            || (sortedCardValues[0] == sortedCardValues[1]
                && sortedCardValues[2] == sortedCardValues[3]
                && sortedCardValues[3] == sortedCardValues[4])) {
            return true;
        }
        return false;
    }

    private static boolean allAreSameSuit(PlayerCards playerCards) {
        for (int i = 0; i < playerCards.CARDS_IN_HAND - 1; i++) {
            if (playerCards.getCards()[i].getSuit() != playerCards.getCards()[i+1].getSuit()) {
                return false;
            }
        }
        return true;
    }

    private static boolean isStraight(PlayerCards playerCards) {
        int[] sortedCardValues = playerCards.getSortedCardsValues();
        for (int i = 0; i < PlayerCards.CARDS_IN_HAND - 1; i++) {
            if (sortedCardValues[i+1] != (sortedCardValues[i] + 1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean hasThreeOfAKind(PlayerCards playerCards) {
        int[] sortedCardValues = playerCards.getSortedCardsValues();
        if ((sortedCardValues[0] == sortedCardValues[1]
                && sortedCardValues[1] == sortedCardValues[2])
            || (sortedCardValues[1] == sortedCardValues[2]
                && sortedCardValues[2] == sortedCardValues[3])
            || (sortedCardValues[2] == sortedCardValues[3]
                && sortedCardValues[3] == sortedCardValues[4])) {
            return true;
        }
        return false;
    }

    private static boolean hasTwoPairs(PlayerCards playerCards) {
        int[] sortedCardValues = playerCards.getSortedCardsValues();
        if ((sortedCardValues[0] == sortedCardValues[1]
                && sortedCardValues[2] == sortedCardValues[3])
            || (sortedCardValues[0] == sortedCardValues[1]
                && sortedCardValues[3] == sortedCardValues[4])
            || (sortedCardValues[1] == sortedCardValues[2]
                && sortedCardValues[3] == sortedCardValues[4])) {
            return true;
        }
        return false;
    }

    private static boolean hasOnePair(PlayerCards playerCards) {
        int[] sortedCardValues = playerCards.getSortedCardsValues();
        if (sortedCardValues[0] == sortedCardValues[1]
                || sortedCardValues[1] == sortedCardValues[2]
                || sortedCardValues[2] == sortedCardValues[3]
                || sortedCardValues[3] == sortedCardValues[4]) {
            return true;
        }
        return false;
    }

    private static int getHigherCard(PlayerCards playerCards) {
        int higherValue = playerCards.getCards()[0].getNumber();
        for (int i = 1; i < PlayerCards.CARDS_IN_HAND; i++) {
            if (playerCards.getCards()[i].getNumber() > higherValue) {
                higherValue = playerCards.getCards()[i].getNumber();
            }
        }
        return higherValue;
    }

    public static int evaluateTieHand(PlayerCards playerCards) {
        int handValue = evaluateHand(playerCards);
        int[] sortedCardValues = playerCards.getSortedCardsValues();
        switch (HandRanking.getHandRankingFromValue(handValue)) {
            case FOUR_OF_A_KIND:
                if (sortedCardValues[0] == sortedCardValues[1]) {
                    handValue += playerCards.getCards()[0].getNumber();
                } else {
                    handValue += playerCards.getCards()[1].getNumber();
                }
                break;
            case FULL_HOUSE:
                if (sortedCardValues[1] == sortedCardValues[2]) {
                    handValue += sortedCardValues[0];
                } else {
                    handValue += sortedCardValues[2];
                }
                break;
            case FLUSH:
            case STRAIGHT:
                handValue += getHigherCard(playerCards);
                break;
            case THREE_OF_A_KIND:
                if (sortedCardValues[0] == sortedCardValues[1]
                        && sortedCardValues[1] == sortedCardValues[2]) {
                    handValue += sortedCardValues[0];
                } else if (sortedCardValues[1] == sortedCardValues[2]
                        && sortedCardValues[2] == sortedCardValues[3]) {
                    handValue += sortedCardValues[1];
                } else {
                    handValue += sortedCardValues[2];
                }
                break;
            case TWO_PAIRS:
                int higher;
                if (sortedCardValues[0] == sortedCardValues[1]
                        && sortedCardValues[2] == sortedCardValues[3]) {
                    if (sortedCardValues[1] > sortedCardValues[2]) {
                        higher = sortedCardValues[1];
                    } else {
                        higher = sortedCardValues[2];
                    }
                } else if (sortedCardValues[0] == sortedCardValues[1]
                        && sortedCardValues[3] == sortedCardValues[4]) {
                    if (sortedCardValues[1] > sortedCardValues[3]) {
                        higher = sortedCardValues[1];
                    } else {
                        higher = sortedCardValues[3];
                    }
                } else {
                    if (sortedCardValues[1] > sortedCardValues[2]) {
                        higher = sortedCardValues[1];
                    } else {
                        higher = sortedCardValues[2];
                    }
                }
                handValue += higher;
                break;
            case ONE_PAIR:
                if (sortedCardValues[0] == sortedCardValues[1]) {
                    handValue += sortedCardValues[0];
                } else if (sortedCardValues[1] == sortedCardValues[2]) {
                    handValue += sortedCardValues[1];
                } else if (sortedCardValues[2] == sortedCardValues[3]) {
                    handValue += sortedCardValues[2];
                } else {
                    handValue += sortedCardValues[3];
                }
                break;
        }

        return handValue;
    }

}
