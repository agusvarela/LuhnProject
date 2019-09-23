public class Utils {

  public static boolean have16Digits(String creditCardNumber) {
    boolean valid = false;
    if (creditCardNumber.length() == 16) {
      valid = true;
    } else {
      System.out.println("You entered a number that have " + creditCardNumber.length()
          + " digits and you have to put 16 digits.");
    }
    return valid;
  }

  public static boolean isANumberType(String creditCardNumber) {
    boolean valid = false;
    try {
      long number = Long.parseLong(creditCardNumber);
      if (number <= 0) {
          throw new NumberFormatException();
      }
      valid = true;
    } catch (NumberFormatException nfe) {
      System.out.println("Wrong type inserted.");
    }
    return valid;
  }
}
