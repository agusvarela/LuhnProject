import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LuhnAlgorithmTest {

  private final ByteArrayOutputStream out = new ByteArrayOutputStream();
  private LuhnAlgorithm luhn;

  @Before
  public void setUp() {
    System.setOut(new PrintStream(out));
    luhn = new LuhnAlgorithm();
  }

  @After
  public void cleanUpStreams() throws IOException {
    System.setOut(null);
    out.close();
  }

  @Test
  public void creditCardNumberIsValid() {
    int[] creditCardNumber = {4, 0, 1, 2, 8, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 1};
    assertThat(luhn.isAValidCreditCardNumber(creditCardNumber), is(true));
  }

  @Test
  public void creditCardNumberIsNotValid() {
    int[] creditCardNumber = {4, 0, 1, 2, 8, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 2};
    assertThat(luhn.isAValidCreditCardNumber(creditCardNumber), is(false));
  }

  @Test
  public void creditCardNumberIsNotValidWithLessDigitThan16() {
    int[] creditCardNumber = {4, 0, 1, 2, 8, 8, 8, 8, 8, 8};
    assertThat(luhn.isAValidCreditCardNumber(creditCardNumber), is(false));
  }

  @Test
  public void creditCardNumberIsNotValidWithMoreDigitsThan16() {
    int[] creditCardNumber = {4, 0, 1, 2, 8, 8, 8, 8, 8, 8, 8, 8, 1, 8, 8, 2, 3, 8, 7, 7};
    assertThat(luhn.isAValidCreditCardNumber(creditCardNumber), is(false));
  }
}
