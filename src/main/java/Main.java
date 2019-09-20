public class Main {

  public static void main(String args[]) {
    System.out.println("****************************");
    System.out.println("WELCOME TO LUHN VALIDATOR");
    System.out.println("****************************\n");

    LuhnProcessor luhnProcessor = new LuhnProcessor();
    luhnProcessor.process();
  }
}
