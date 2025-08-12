
   import java.util.Scanner;
    public class AtmProject {
        public static void main(String[] args) {
            int correctPIN = 1234;
            double balance = 1000.0;
            Scanner sc = new Scanner(System.in);
            while (true) {
                System.out.println("\n🏦 Welcome to Rakhee Bank ATM");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                int choice = sc.nextInt();

                // 🔐 PIN Validation (Inner Loop)
                boolean accessGranted = false;
                for (int attempt = 1; attempt <= 3; attempt++) {
                    System.out.print("Enter your 4-digit PIN: ");
                    int enteredPIN = sc.nextInt();
                    if (enteredPIN == correctPIN) {
                        accessGranted = true;
                        break;
                    } else {
                        System.out.println("❌ Incorrect PIN. Attempt " + attempt + " of 3.");
                    }
                }

                if (!accessGranted) {
                    System.out.println("🚫 Access denied. Returning to main menu.");
                    continue;
                }

                // 💳 Process Transaction
                switch (choice) {
                    case 1:
                        System.out.println("💰 Current Balance: ₹" + balance);
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ₹");
                        double deposit = sc.nextDouble();
                        balance += deposit;
                        System.out.println("✅ ₹" + deposit + " deposited. New Balance: ₹" + balance);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ₹");
                        double withdraw = sc.nextDouble();
                        if (withdraw <= balance) {
                            balance -= withdraw;
                            System.out.println("✅ ₹" + withdraw + " withdrawn. Remaining Balance: ₹" + balance);
                        } else {
                            System.out.println("⚠️ Insufficient funds.");
                        }
                        break;
                    case 4:
                        System.out.println("🙏 Thank you for banking with Rakhee Bank. ");
                        break;
                    default:
                        System.out.println("❓ Invalid option. Please try again.");
                }

                if (choice == 4) {
                    break;
                }
            }


        }
    }
