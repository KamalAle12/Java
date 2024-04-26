import java.util.*;

class Card {
    private char symbol;
    private int number;

    public Card(char symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof Card)) return false;
        Card c = (Card) obj;
        return symbol == c.symbol && number == c.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, number);
    }

    @Override
    public String toString() {
        return symbol + " " + number;
    }
}

public class Exp22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Character> uniqueSymbols = new HashSet<>();
        List<Card> cards = new ArrayList<>();
        while (uniqueSymbols.size() < 4) {
            System.out.println("Enter a card:");
            char symbol = scanner.next().charAt(0);
            int number = scanner.nextInt();
            if (uniqueSymbols.add(symbol)) {
                cards.add(new Card(symbol, number));
            }
            System.out.println("Four symbols gathered in " + cards.size() + " cards.");
        }
        Collections.sort(cards, (c1, c2) -> Character.compare(c1.getSymbol(), c2.getSymbol()));
        System.out.println("Cards in Set are:");
        for (Card card : cards) {
            System.out.println(card);
        }
    }
}
