public class IncorrectInputException extends Exception{
    public IncorrectInputException() {
        System.out.println("Incorrect input");
    }

    public IncorrectInputException(String message) {
        super(message);
    }
}
