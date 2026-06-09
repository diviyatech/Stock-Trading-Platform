import java.util.*;

class Stock {
    String name;
    double price;

    Stock(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

class Portfolio {
    HashMap<String, Integer> holdings = new HashMap<>();
    double balance = 10000.0;

    public void buyStock(String stockName, int quantity, double price) {
        double cost = quantity * price;

        if (cost <= balance) {
            balance -= cost;
            holdings.put(stockName,
                    holdings.getOrDefault(stockName, 0) + quantity);

            System.out.println(quantity + " shares of " + stockName + " purchased successfully.");
            System.out.println("Remaining Balance: ₹" + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public void sellStock(String stockName, int quantity, double price) {

        if (holdings.containsKey(stockName) &&
                holdings.get(stockName) >= quantity) {

            holdings.put(stockName,
                    holdings.get(stockName) - quantity);

            balance += quantity * price;

            System.out.println(quantity + " shares of " + stockName + " sold successfully.");
            System.out.println("Updated Balance: ₹" + balance);

        } else {
            System.out.println("Not enough shares available!");
        }
    }

    public void showPortfolio() {

        System.out.println("\n===== PORTFOLIO =====");

        if (holdings.isEmpty()) {
            System.out.println("No stocks purchased yet.");
        } else {
            for (String stock : holdings.keySet()) {
                System.out.println(stock + " : " + holdings.get(stock) + " shares");
            }
        }

        System.out.println("Available Balance: ₹" + balance);
    }
}

public class StockTradingPlatform {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stock tata = new Stock("TATA", 500);
        Stock infosys = new Stock("INFOSYS", 1500);
        Stock reliance = new Stock("RELIANCE", 2500);

        Portfolio portfolio = new Portfolio();

        int choice;

        do {

            System.out.println("\n===== STOCK TRADING PLATFORM =====");
            System.out.println("1. View Market Data");
            System.out.println("2. Buy Stock");
            System.out.println("3. Sell Stock");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("\nAvailable Stocks:");
                    System.out.println("1. TATA     - ₹500");
                    System.out.println("2. INFOSYS  - ₹1500");
                    System.out.println("3. RELIANCE - ₹2500");
                    break;

                case 2:

                    System.out.println("\nSelect Stock:");
                    System.out.println("1. TATA");
                    System.out.println("2. INFOSYS");
                    System.out.println("3. RELIANCE");

                    int buyChoice = sc.nextInt();

                    System.out.print("Enter Quantity: ");
                    int buyQty = sc.nextInt();

                    if (buyChoice == 1)
                        portfolio.buyStock(tata.name, buyQty, tata.price);
                    else if (buyChoice == 2)
                        portfolio.buyStock(infosys.name, buyQty, infosys.price);
                    else if (buyChoice == 3)
                        portfolio.buyStock(reliance.name, buyQty, reliance.price);
                    else
                        System.out.println("Invalid Choice!");

                    break;

                case 3:

                    System.out.println("\nSelect Stock:");
                    System.out.println("1. TATA");
                    System.out.println("2. INFOSYS");
                    System.out.println("3. RELIANCE");

                    int sellChoice = sc.nextInt();

                    System.out.print("Enter Quantity: ");
                    int sellQty = sc.nextInt();

                    if (sellChoice == 1)
                        portfolio.sellStock(tata.name, sellQty, tata.price);
                    else if (sellChoice == 2)
                        portfolio.sellStock(infosys.name, sellQty, infosys.price);
                    else if (sellChoice == 3)
                        portfolio.sellStock(reliance.name, sellQty, reliance.price);
                    else
                        System.out.println("Invalid Choice!");

                    break;

                case 4:
                    portfolio.showPortfolio();
                    break;

                case 5:
                    System.out.println("Thank you for using Stock Trading Platform!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}