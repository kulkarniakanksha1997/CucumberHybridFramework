package commonUtils;

import java.util.Date;

public class CommonUtils {

	public static final int IMPLICITE_WAIT=10;
	public static final int PAGELOAD_TIME=15;
	public static final int EXPLICITE_WAIT_BASIC_TIME=15;
	
	public   String getEmailWithTimeStamps()
	{
		Date date=new Date();
		return "Akanksha"+date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}

}
