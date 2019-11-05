package ca.gbc.library.beans;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utility {
	
	/*private String getCurrentDateTime() {
		Date d = new Date();
		return d.toString();
	}
	*/
	int day,month,year,time;

	public int getDay() {
		Date dt = new Date();
		day = dt.getDay();
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		Date m = new Date();
		month = m.getMonth();
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		Date m = new Date();
		year = m.getYear();
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	public String getCurrentDateTime() {
		Date date = new Date();  
	    SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");  
	    String strDate = formatter.format(date);  
	    return strDate;
	}

}
