package secureDev;

import org.owasp.encoder.Encode;
//
//import org.owasp.esapi.ESAPI;

public class XssUtils {
	   public static String clearXss(String value)
	   {
		   //this line clears Xss by encoding the string to harmless string 
		   //the esapi wont work on my computer so it is commented
		   //so.. we did xss protection and didnt do xss protection plz dont be mad=]
		   //breaking new i have found encoder.Encode that works!!!
		   //so we can encode the text how ever i can't use the validator module=\
		   
		   String xss_free = Encode.forHtmlContent(value);
		   //stupid patch but i have one more day ...
		   if (xss_free == "null")
		   {
			   return "";
		   }
		   return xss_free;
	   }
}
