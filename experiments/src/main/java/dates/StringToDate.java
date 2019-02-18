package dates;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class StringToDate {

	public static void main(String[] args) throws ParseException {
		String fromDate = "2018-06-04 20:31:53";
		String toDate = "2018-06-05 20:35:13";
		SimpleDateFormat resultFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
		System.out.println(resultFormatter.parse(fromDate).getTime());
		System.out.println(resultFormatter.parse(toDate).getTime());
	}
}
