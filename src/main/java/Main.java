import java.util.Scanner;

class Main {

    public static void showMenu() {
        System.out.println();
        System.out.println("Select an operation and enter its number:");
        System.out.println("1. Add new income");
        System.out.println("2. Add new expense");
        System.out.println("3. Choose a taxation system");
        System.out.println();
    }

    public static int taxEarningsMinusSpendings(int earnings, int spendings) {
        int tax = (earnings - spendings) * 15 / 100;
        if (tax >= 0) {
            return tax;
        } else {
            return 0;
        }
    }

    public static int taxEarning(int earnings) {
        int tax = (earnings * 6) / 100;
        return tax;
    }

    public static void main(String[] args) {
        int earnings = 0;
        int spendings = 0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            } else if ("".equals(input)) {
                System.out.println("You have not selected a menu item!");
                break;
            } else {
                int operation = Integer.parseInt(input);
                switch (operation) {
                    case 1:
                        System.out.println("Enter the amount of income:");
                        String earningsMoneyStr = scanner.nextLine();
                        int earningsMoney = Integer.parseInt(earningsMoneyStr);
                        earnings += earningsMoney;
                        break;
                    case 2:
                        System.out.println("Enter the amount of the expense:");
                        String spendingsMoneyStr = scanner.nextLine();
                        int spendingsMoney = Integer.parseInt(spendingsMoneyStr);
                        spendings += spendingsMoney;
                        break;
                    case 3:
                        int a = taxEarning(earnings);
                        int b = taxEarningsMinusSpendings(earnings, spendings);
                        if (a < b) {
                            System.out.println("We advise you on STS income ( УСН доходы )");
                            System.out.println("Your tax will be: " + a + " rubles");
                            System.out.println("Tax on another system: " + b + " rubles");
                            System.out.println("Saving: " + (b - a) + " rubles");
                        } else {
                            System.out.println("We advise you to STS income-expenses ( УСН доходы-расходы )");
                            System.out.println("Your tax will be: " + b + " rubles");
                            System.out.println("Tax on another system: " + a + " rubles");
                            System.out.println("Saving: " + (a - b) + " rubles");
                        }
                        break;
                    default:
                        System.out.println("No such operation");
                }
            }
        }
        System.out.println("Program completed!");
        scanner.close();
    }
}