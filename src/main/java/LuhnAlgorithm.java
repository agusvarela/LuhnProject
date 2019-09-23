import java.util.Arrays;

public class LuhnAlgorithm {

  public boolean isAValidCreditCardNumber(int[] creditCardNumber) {
    boolean isValid = false;
    if (creditCardNumber.length != 16) {
      return isValid;
    }

    for (int i = creditCardNumber.length - 2; i >= 0; i-=2) {
      int digit = creditCardNumber[i] * 2;
      creditCardNumber[i] = digit < 9 ? digit : digit - 9;
    }
    int sum = Arrays.stream(creditCardNumber).sum();
    int reminder = sum % 10;

    if (reminder == 0) {
      isValid = true;
    }
    return isValid;
  }
  
  
}
