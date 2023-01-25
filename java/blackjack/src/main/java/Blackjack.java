import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class Blackjack {

    Map<String, Integer> cards = new HashMap<>();
    public int parseCard(String card) {

        cards.put("ace", 11);
        cards.put("two", 2);
        cards.put("three", 3);
        cards.put("four", 4);
        cards.put("five", 5);
        cards.put("six", 6);
        cards.put("seven", 7);
        cards.put("eight", 8);
        cards.put("nine", 9);
        cards.put("ten", 10);
        cards.put("jack", 10);
        cards.put("queen", 10);
        cards.put("king", 10);
        cards.put("other", 0);

        int numberCard = 0;

        for (String key : cards.keySet()) {
            if (key.contains(card)) {
                numberCard = cards.get(key);
                break;
            }
        }
        return numberCard;
    }

    public boolean isBlackjack(String card1, String card2) {

        Predicate<Integer> isBlackJack = s1 -> s1 == 21;
        int valueCard1 = 0;
        int valueCard2 = 0;

        for (String key : cards.keySet()) {
            if (key.contains(card1)) {
                valueCard1 = cards.get(key);
            }
            if (key.contains(card2)) {
                valueCard2 = cards.get(key);
            }
        }

        if (isBlackJack.test(valueCard1 + valueCard2))
            return true;
                return false;

    }

    public String largeHand(boolean isBlackjack, int dealerScore) {

        if (isBlackjack && dealerScore < 10) {
            return "W";
        } else if (isBlackjack && dealerScore == 11){
            return "P";
        } else {
            return "S";
        }
    };

    public String smallHand(int handScore, int dealerScore) {

        if (handScore >= 17) {
            return "S";
        } else if (handScore <= 11) {
            return "H";
        } else if ((handScore >= 12 || handScore <= 16) && dealerScore <= 7) {
            return "H";
        } else {
            return "W";
        }
    }

    // FirstTurn returns the semi-optimal decision for the first turn, given the cards of the player and the dealer.
    // This function is already implemented and does not need to be edited. It pulls the other functions together in a
    // complete decision tree for the first turn.
    public String firstTurn(String card1, String card2, String dealerCard) {
        int handScore = parseCard(card1) + parseCard(card2);
        int dealerScore = parseCard(dealerCard);

        if (20 < handScore) {
            return largeHand(isBlackjack(card1, card2), dealerScore);
        } else {
            return smallHand(handScore, dealerScore);
        }
    }

    public static void main(String[] args) {

        Blackjack blackjack = new Blackjack();

        blackjack.firstTurn("eight", "three", "four");

    }
}
