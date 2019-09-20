import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LuhnProcessorTest {

  private final ByteArrayOutputStream out = new ByteArrayOutputStream();
  private Scanner scanner;
  private LuhnProcessor luhnProcessor;

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
  public void processFailedWithIncorrectType() {
    String incorrectData = "456789LL";
    InputStream in = new ByteArrayInputStream(incorrectData.getBytes());
    System.setIn(in);
    luhnProcessor = new LuhnProcessor();
    luhnProcessor.process();
    assertThat(out.toString(),
        containsString("Insert your Credit Card number for validate it please:"));
    assertThat(out.toString(),
        containsString("Please enter a correct 16 digits of credit card number."));
  }

  @Test
  public void processFailedWithIncorrectlength() {
    String incorrectData = "4568978542";
    InputStream in = new ByteArrayInputStream(incorrectData.getBytes());
    System.setIn(in);
    luhnProcessor = new LuhnProcessor();
    luhnProcessor.process();
    assertThat(out.toString(),
        containsString("Insert your Credit Card number for validate it please:"));
    assertThat(out.toString(),
        containsString("Please enter a correct 16 digits of credit card number."));
  }

  @Test
  public void processFailedWithInvalidCreditCardNumber() {
    String creditCardNumber = "4012888888881882";
    InputStream in = new ByteArrayInputStream(creditCardNumber.getBytes());
    System.setIn(in);
    luhnProcessor = new LuhnProcessor();
    luhnProcessor.process();
    assertThat(out.toString(),
        containsString("Credit Card " + creditCardNumber + " is not valid."));
  }

  @Test
  public void processSuccessWithValidCreditCardNumber() {
    String creditCardNumber = "4012888888881881";
    InputStream in = new ByteArrayInputStream(creditCardNumber.getBytes());
    System.setIn(in);
    luhnProcessor = new LuhnProcessor();
    luhnProcessor.process();
    assertThat(out.toString(), containsString("Credit Card " + creditCardNumber + " is valid."));
  }
}
