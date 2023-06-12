package customexception;

public class studentNotFoundException extends RuntimeException{
	private String message;
	public studentNotFoundException(String message)
	{
		this.message=message;
	}
	public String getMessage()
	{
		return message;
	}
	

}
