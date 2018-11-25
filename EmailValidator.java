import java.util.regex.*;
public class EmailValidator {
	public static boolean emailValidation(String email) {
		boolean status = false;
		
		 String EMAIL_PATTERN = 
				  "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				  + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		 
		Pattern pattern = Pattern.compile(EMAIL_PATTERN);
		Matcher matcher = pattern.matcher(email);
		
		if (matcher.matches()) {
			status = true;
		}
		else {
			status = false;
		}
		
		return status;
	}
}
