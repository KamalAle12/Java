import java.util.*;

class Card {
    String symbol;
    int number;

    Card(String symbol, int number) {
        this.symbol = symbol;
        this.number = number;
    }

    @Override
    public String toString() {
        return symbol + " " + number;
    }
}

public class Exp21 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Number of Cards:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        Map<String, List<Card>> cardMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter card " + (i + 1) + ":");
            String symbol = scanner.nextLine().trim();
            int number = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            Card card = new Card(symbol, number);
            cardMap.computeIfAbsent(symbol, k -> new ArrayList<>()).add(card);
        }
        System.out.println("Distinct Symbols are :");
        for (String symbol : cardMap.keySet()) {
            System.out.print(symbol + " ");
        }
        System.out.println();
        for (Map.Entry<String, List<Card>> entry : cardMap.entrySet()) {
            String symbol = entry.getKey();
            List<Card> cards = entry.getValue();
            System.out.println("Cards in " + symbol + " Symbol");

            int sum = 0;
            for (Card card : cards) {
                System.out.println(card);
                sum += card.number;
            }
            System.out.println("Number of cards : " + cards.size());
            System.out.println("Sum of Numbers : " + sum);
        }
        scanner.close();
    }
}
