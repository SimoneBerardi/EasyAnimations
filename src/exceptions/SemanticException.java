package exceptions;

import java.util.List;


public class SemanticException extends Exception
{

	private List<String> errors;
	private String newLine = "\n";
	
	public SemanticException() {
		super();
	}

	public SemanticException(List<String> errors)
	{
		this.errors = errors;
	}
	
	@Override
	public String getMessage()
	{
		String result = "";
		for(int i=0; i<errors.size(); i++)
		{
			result = result + "Semantic error: " +  errors.get(i) + newLine;
		}
		return result;
	}

}