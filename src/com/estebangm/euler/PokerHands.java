package com.estebangm.euler;

import com.estebangm.euler.aux.poker.Card;
import com.estebangm.euler.aux.poker.PlayerCards;
import com.estebangm.euler.aux.poker.PlayerHand;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.estebangm.euler.aux.poker.PlayerHand.*;


/**
 * ID 54
 *
 * In the card game poker, a hand consists of five cards and are ranked, from lowest to highest,
 * in the following way:
 *
 *     High Card: Highest value card.
 *     One Pair: Two cards of the same value.
 *     Two Pairs: Two different pairs.
 *     Three of a Kind: Three cards of the same value.
 *     Straight: All cards are consecutive values.
 *     Flush: All cards of the same suit.
 *     Full House: Three of a kind and a pair.
 *     Four of a Kind: Four cards of the same value.
 *     Straight Flush: All cards are consecutive values of same suit.
 *     Royal Flush: Ten, Jack, Queen, King, Ace, in same suit.
 *
 * The cards are valued in the order:
 * 2, 3, 4, 5, 6, 7, 8, 9, 10, Jack, Queen, King, Ace.
 *
 * If two players have the same ranked hands then the rank made up of the highest value wins;
 * for example, a pair of eights beats a pair of fives (see example 1 below). But if two ranks tie,
 * for example, both players have a pair of queens, then highest cards in each hand are compared
 * (see example 4 below); if the highest cards tie then the next highest cards are compared, and so on.
 *
 * Consider the following five hands dealt to two players:
 * Hand	 	Player 1	 	    Player 2	 	    Winner
 * 1	 	5H 5C 6S 7S KD      2C 3S 8S 8D TD      Player 2
 *          Pair of Fives       Pair of Eights
 *
 * 2	 	5D 8C 9S JS AC      2C 5C 7D 8S QH      Player 1
 *          Highest card Ace    Highest card Queen
 *
 * 3	 	2D 9C AS AH AC      3D 6D 7D TD QD      Player 2
 *          Three Aces          Flush with Diamonds
 *
 * 4	 	4D 6S 9H QH QC      3D 6D 7H QD QS      Player 1
 *          Pair of Queens      Pair of Queens
 *          Highest card Nine   Highest card Seven
 *
 * 5	 	2H 2D 4C 4D 4S      3C 3D 3S 9S 9D      Player 1
 *          Full House          Full House
 *          With Three Fours    with Three Threes
 *
 * The file 'p054_poker.txt' contains one-thousand random hands dealt to two players.
 * Each line of the file contains ten cards (separated by a single space):
 * the first five are Player 1's cards and the last five are Player 2's cards.
 * You can assume that all hands are valid (no invalid characters or repeated cards),
 * each player's hand is in no specific order, and in each hand there is a clear winner.
 *
 * How many hands does Player 1 win?
 *
 * ANSWER: 376
 */
public class PokerHands {
    public static final String HANDS_FILE_PATH = "attachments/p054_poker.txt";

    public static void main (String [] args) {
        int playerOneWins = 0;
        try {
            File handsFile = new File(HANDS_FILE_PATH);
            Scanner myReader = new Scanner(handsFile);
            int lineNumber = 1;
            while (myReader.hasNextLine()) {
                System.out.print(lineNumber + ") ");
                String line = myReader.nextLine();
                PlayerCards[] playerCards = readPlayersCards(line);
                int playerOneHand = PlayerHand.evaluateHand(playerCards[0]);
                int playerTwoHand = PlayerHand.evaluateHand(playerCards[1]);
                System.out.print(playerOneHand + " vs " + playerTwoHand);
                if (playerOneHand > playerTwoHand) {
                    playerOneWins++;
                    System.out.print(" > " + playerOneWins + "!!");
                } else if (playerOneHand == playerTwoHand) {
                    playerOneHand = PlayerHand.evaluateTieHand(playerCards[0]);
                    playerTwoHand = PlayerHand.evaluateTieHand(playerCards[1]);
                    System.out.print(" > TIE! > " + playerOneHand + " vs " + playerTwoHand);
                    if (playerOneHand > playerTwoHand) {
                        playerOneWins++;
                        System.out.print(" > " + playerOneWins + "!!");
                    }
                }
                System.out.println();
                lineNumber++;
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(playerOneWins);
    }

    private static PlayerCards[] readPlayersCards(String line) {
        PlayerCards[] playerCards = {new PlayerCards(), new PlayerCards()};
        String [] cardsStrings = line.split(" ");
        for (int i = 0; i < cardsStrings.length; i++) {
            Card card = readCard(cardsStrings[i].charAt(0), cardsStrings[i].charAt(1));
            playerCards[i / PlayerCards.CARDS_IN_HAND].addCard(card);
        }
        return playerCards;
    }

    private static Card readCard(char value, char suit) {
        Card card = new Card();
        card.setNumber(extractCardValue(value));
        card.setSuit(suit);
        return card;
    }

    private static int extractCardValue(char value) {
        switch (value) {
            case TEN:
                return TEN_VALUE;
            case JACK:
                return JACK_VALUE;
            case QUEEN:
                return QUEEN_VALUE;
            case KING:
                return KING_VALUE;
            case ACE:
                return ACE_VALUE;
            default:
                return Character.getNumericValue(value);
        }
    }

    private static int processHandValueInTie(PlayerCards playerCards) {
        int tieValue = 0;

        return tieValue;
    }
}
