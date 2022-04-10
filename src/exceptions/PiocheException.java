package exceptions;

public class PiocheException extends RuntimeException
{
	public PiocheException()
	{
		super();
	}

	public PiocheException(String message)
	{
		super(message);
	}
}