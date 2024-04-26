import java.util.Scanner;

abstract class Account {
    double interestRate;
    double amount;

    abstract double calculateInterest() throws InvalidValueException;

    static class InvalidValueException extends Exception {
        public InvalidValueException(String message) {
            super(message);
        }
    }
}

class FDAccount extends Account {
    int noOfDays;
    int ageOfACHolder;

    @Override
    double calculateInterest() throws InvalidValueException {
        if (amount < 0 || noOfDays <= 0 || ageOfACHolder < 0) {
            throw new InvalidValueException("Invalid input values");
        }
        double interest = 0;
        if (amount <= 10000000) {
            if (noOfDays >= 7 && noOfDays <= 14) {
                interestRate = ageOfACHolder >= 60 ? 5.00 : 4.50;
            } else if (noOfDays >= 15 && noOfDays <= 29) {
                interestRate = ageOfACHolder >= 60 ? 5.25 : 4.75;
            } else if (noOfDays >= 30 && noOfDays <= 45) {
                interestRate = ageOfACHolder >= 60 ? 6.00 : 5.50;
            } else if (noOfDays >= 45 && noOfDays <= 60) {
                interestRate = ageOfACHolder >= 60 ? 7.50 : 7.00;
            } else if (noOfDays >= 61 && noOfDays <= 184) {
                interestRate = ageOfACHolder >= 60 ? 8.00 : 7.50;
            } else if (noOfDays >= 185 && noOfDays <= 365) {
                interestRate = ageOfACHolder >= 60 ? 8.50 : 8.00;
            } else {
                throw new InvalidValueException("Invalid number of days");
            }
        } else {
            if (noOfDays >= 7 && noOfDays <= 14) {
                interestRate = 6.50;
            } else if (noOfDays >= 15 && noOfDays <= 29) {
                interestRate = 6.75;
            } else if (noOfDays >= 30 && noOfDays <= 45) {
                interestRate = 6.75;
            } else if (noOfDays >= 45 && noOfDays <= 60) {
                interestRate = 8.00;
            } else if (noOfDays >= 61 && noOfDays <= 184) {
                interestRate = 8.50;
            } else if (noOfDays >= 185 && noOfDays <= 365) {
                interestRate = 10.00;
            } else {
                throw new InvalidValueException("Invalid number of days");
            }
        }
        interest = (amount * interestRate * noOfDays) / (36500);
        return interest;
    }
}

class SBAccount extends Account {
    @Override
    double calculateInterest() throws InvalidValueException {
        if (amount < 0) {
            throw new InvalidValueException("Invalid input values");
        }
        interestRate = 4.0;
        return (amount * interestRate) / 100;
    }
}

class RDAccount extends Account {
    int noOfMonths;
    double monthlyAmount;

    @Override
    double calculateInterest() throws InvalidValueException {
        if (amount < 0 || noOfMonths <= 0 || monthlyAmount < 0) {
            throw new InvalidValueException("Invalid input values");
        }
        double maturityAmount = amount;
        for (int i = 0; i < noOfMonths; i++) {
            maturityAmount += monthlyAmount;
            maturityAmount += (maturityAmount * interestRate) / 1200;
        }
        return maturityAmount - amount;
    }
}

public class Exp13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Select the option:");
            System.out.println("1. Interest Calculator –SB");
            System.out.println("2. Interest Calculator –FD");
            System.out.println("3. Interest Calculator –RD");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            if (choice == 4) {
                break;
            }
            Account account = null;
            switch (choice) {
                case 1:
                    account = new SBAccount();
                    break;
                case 2:
                    account = new FDAccount();
                    break;
                case 3:
                    account = new RDAccount();
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    continue;
            }
            try {
                getInputValues(account, scanner);
                double interest = account.calculateInterest();
                System.out.println("Interest gained: Rs. " + interest);
            } catch (Account.InvalidValueException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void getInputValues(Account account, Scanner scanner) {
        System.out.println("Enter the amount:");
        account.amount = scanner.nextDouble();
        if (account instanceof FDAccount) {
            System.out.println("Enter the number of days:");
            ((FDAccount) account).noOfDays = scanner.nextInt();
            System.out.println("Enter your age:");
            ((FDAccount) account).ageOfACHolder = scanner.nextInt();
        } else if (account instanceof RDAccount) {
            System.out.println("Enter the number of months:");
            ((RDAccount) account).noOfMonths = scanner.nextInt();
            System.out.println("Enter the monthly amount:");
            ((RDAccount) account).monthlyAmount = scanner.nextDouble();
        }
    }
}
