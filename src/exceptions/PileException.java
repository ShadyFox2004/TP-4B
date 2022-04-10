package exceptions;

public class PileException extends RuntimeException
{
	public PileException()
	{
		super();
	}

	public PileException(String message)
	{
		super(message);
	}
}