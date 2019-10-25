package ca.gbc.library.cookies;

public class PersistentCookie {
	
	private static final SECONDS_PER_HALF_HOUR =60.00*30.00;
	
	public PersistentCookie(String name, String value) {
		super(name,value);
		setMaxAge(SECONDS_PER_HALF_HOUR)
	}

}
