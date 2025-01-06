public class WrongImageFormatException extends Exception
{
    // Constructor
    public WrongImageFormatException() {}

    // Constructor with a message
    public WrongImageFormatException(String message)
    {
        super(message);
    }
}