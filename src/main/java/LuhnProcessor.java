import java.util.Scanner;
import java.util.stream.Stream;

public class LuhnProcessor {

  private Scanner scanner = new Scanner(System.in);
  private LuhnAlgorithm luhnAlgorithm = new LuhnAlgorithm();

  public void process() {
    System.out.print("Insert your Credit Card number for validate it please: ");
    // Credit Card number input
    String creditCardNumber = scanner.nextLine();

    if (!(Utils.isANumberType(creditCardNumber) && Utils.have16Digits(creditCardNumber))) {
      System.out.println("Please enter a correct 16 digits of credit card number.");
      return;
    }

    String validString = " is not valid";
    int[] creditCardDigits =
        Stream.of(creditCardNumber.split("")).mapToInt(Integer::parseInt).toArray();

    if (luhnAlgorithm.isAValidCreditCardNumber(creditCardDigits)) {
      validString = " is valid";
    }
    System.out.println("Credit Card " + creditCardNumber + validString + ".");
  }
}
