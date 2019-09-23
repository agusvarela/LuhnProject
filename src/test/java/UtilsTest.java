import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class UtilsTest {

  private final ByteArrayOutputStream out = new ByteArrayOutputStream();

  @Before
  public void setUp() {
    System.setOut(new PrintStream(out));
  }

  @After
  public void cleanUpStreams() throws IOException {
    System.setOut(null);
    out.close();
  }

  @Test
  public void have16DigitsIsTrue() {
    String creditCardNumber = "4012888888881881";
    assertThat(Utils.have16Digits(creditCardNumber), is(true));
  }

  @Test
  public void have16DigitsIsFalseWithLessDigits() {
    String creditCardNumber = "40128888888";
    assertThat(Utils.have16Digits(creditCardNumber), is(false));
    assertEquals("You entered a number that have " + creditCardNumber.length()
        + " digits and you have to put 16 digits." + System.lineSeparator(), out.toString());
  }

  @Test
  public void have16DigitsIsFalseWithMoreDigits() {
    String creditCardNumber = "401288888888188178123";
    assertThat(Utils.have16Digits(creditCardNumber), is(false));
    assertEquals("You entered a number that have " + creditCardNumber.length()
        + " digits and you have to put 16 digits." + System.lineSeparator(), out.toString());
  }

  @Test
  public void isNumberTypeIsTrue() {
    String creditCardNumber = "4012888888881881";
    assertThat(Utils.isANumberType(creditCardNumber), is(true));
  }

  @Test
  public void isNumberTypeIsFalseWithFloatNumber() {
    String creditCardNumber = "40128.8888888";
    assertThat(Utils.isANumberType(creditCardNumber), is(false));
    assertEquals("Wrong type inserted." + System.lineSeparator(), out.toString());
  }

  @Test
  public void isNumberTypeIsFalseWithChars() {
    String creditCardNumber = "401288888888" + "Here";
    assertThat(Utils.isANumberType(creditCardNumber), is(false));
    assertEquals("Wrong type inserted." + System.lineSeparator(), out.toString());
  }

  @Test
  public void isNumberTypeIsFalseWithSpecialCharacters() {
    String creditCardNumber = "401288888888" + "*/";
    assertThat(Utils.isANumberType(creditCardNumber), is(false));
    assertEquals("Wrong type inserted." + System.lineSeparator(), out.toString());
  }
  
  @Test
  public void isNumberTypeIsFalseWithNegativeNumber() {
    String creditCardNumber = "-40128888888";
    assertThat(Utils.isANumberType(creditCardNumber), is(false));
    assertEquals("Wrong type inserted." + System.lineSeparator(), out.toString());
  }
}
