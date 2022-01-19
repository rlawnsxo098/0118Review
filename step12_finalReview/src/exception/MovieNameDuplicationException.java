package exception;

public class MovieNameDuplicationException extends Exception{

	public MovieNameDuplicationException() {}
	
	public MovieNameDuplicationException(String m) {
		super(m);
	}
	
}
