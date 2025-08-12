
    import java.util.Scanner;
    public class ATMProject2 {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            double balance = 1000.0;

            // 🌸 User sets their PIN privately
            System.out.print("Set your 4-digit PIN (keep it secret): ");
            int correctPIN = sc.nextInt();


                System.out.println("\n🏦 Welcome to Rakhee Bank ATM");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit");
                System.out.println("3. Withdraw");
                System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

                // 🔐 Validate PIN (max 3 attempts)
                boolean accessGranted = false;
                for (int attempt = 1; attempt <= 3; attempt++) {
                    System.out.print("Enter your PIN: ");
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
                    //continue;
                }

                // 💳 Process transaction
                switch (choice) {
                    case 1:
                        System.out.println("💰 Current Balance: ₹" + balance);
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ₹");
                        double deposit = sc.nextDouble();
                        balance += deposit;
                        System.out.println("✅ ₹" + deposit + " deposited. New Balance: ₹" + balance);
                        if (balance >= 100000) {
                            System.out.println("🎉 Lakshmi smiles upon you! Your balance has crossed ₹1 lakh!");
                        }
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
                        System.out.println("🙏 Thank you for banking with Rakhee Bank. May your wealth be blessed!");
                        return;
                    default:
                        System.out.println("❓ Invalid option. Please try again.");
                }
            }
        }




