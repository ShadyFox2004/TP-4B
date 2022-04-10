package exceptions;

public class ConstructeurException extends RuntimeException
{
	public ConstructeurException()
	{
		super();
	}

	public ConstructeurException(String message)
	{
		super(message);
	}
}
