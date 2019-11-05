package ca.gbc.library.cookies;

import javax.servlet.http.Cookie;

public class PersistentCookie extends Cookie {
	
	private static final float SECONDS_PER_HALF_HOUR = 60*30;
	
	public PersistentCookie(String name,String value) {
		super(name,value);
		setMaxAge((int) SECONDS_PER_HALF_HOUR);
	}

}
