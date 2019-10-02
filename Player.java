package game;

public class Player {

	private String name;
	private char mark;
	
	public Player(String name, char mark) 
	{
		this.name = name;
		this.mark = mark;
	}

	public String getName() {
		return name;
	}

	public char getMark() {
		return mark;
	}
	
	public String toString()
	{
		String str;
		str =( name +'('+ mark +')');
		return str;
	}
	
	
	
	
}
