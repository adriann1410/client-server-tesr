package projekt;

import java.io.Serializable;

public class Pytanie implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String pytanie;
	public String[] odpowiedzi = new String[4];
	
	public Pytanie(String pytanie, String[] odpowiedzi){
		this.pytanie = pytanie;
		this.odpowiedzi = odpowiedzi;
	}
}
