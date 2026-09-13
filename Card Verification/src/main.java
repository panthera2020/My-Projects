import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        CreditCardVerification creditCard = new CreditCardVerification();
        long cardNumber = 0;

        IO.println("Hello, kindly enter card details to verify ");
        try {
            cardNumber = scan.nextLong();
        }
        catch (InputMismatchException e) {
            IO.println();
            IO.println("ENTER VALID CARD NUMBER!!!");
            System.exit(0);
        }

        IO.println();
        IO.println("**********************************************");
        IO.println("**Credit card type: " + creditCard.cardType(cardNumber));
        IO.println("**Credit card number: " + cardNumber);
        IO.println("**Credit card length: " + creditCard.getCardLength(cardNumber));
        IO.println("**Credit card validity: " + (creditCard.isCardValid(cardNumber) ? "Valid" : "Invalid"));
        IO.println("**********************************************");
    }
}
