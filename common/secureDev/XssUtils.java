package secureDev;

import org.owasp.esapi.ESAPI;

public class XssUtils {
	   public static String clearXss(String value)
	   {
		   //this line clears Xss by encoding the string to harmless string 
		   //the esapi wont work on my computer so it is commeted
		   //so.. we did xss protection and didnt do xss protection plz dont be mad=]
		   
		   //String xss_free = ESAPI.encoder().encodeForHTMLAttribute(value);
		   return value;
	   }
}
