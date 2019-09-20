import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MainTest {

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
  public void mainSuccess() {
    String creditCardNumber = "4012888888881881";
    InputStream in = new ByteArrayInputStream(creditCardNumber.getBytes());
    System.setIn(in);
    String[] args = {""};
    Main.main(args);
    assertThat(out.toString(), containsString("Credit Card " + creditCardNumber + " is valid."));
  }
}
