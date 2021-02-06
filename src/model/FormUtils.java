package model;

import com.sun.xml.internal.ws.util.StringUtils;

public class FormUtils 
{
	 public static boolean isAlphabet(String i_StringToCheck) 
	 { 
		 return ((i_StringToCheck != null) 
				 && (!i_StringToCheck.equals("")) 
				 && (i_StringToCheck.matches("[a-zA-Z]+"))); 
	 }
	 
	 public static boolean isNumeric(String i_StringToCheck)
	 {
		 boolean o_Numeric = true;
		 try {
			 int number = Integer.parseInt(i_StringToCheck);
		 } catch (NumberFormatException | NullPointerException nfe) {
			 o_Numeric = false;
		 }
		 return o_Numeric;
	 }
	 
	 public static boolean HasNoSpaces(String i_StringToCheck)
	 {
		 return (!(i_StringToCheck.contains(" ")) 
				 && i_StringToCheck != null 
				 && !i_StringToCheck.equals(""));
	 }
	 
	 public static boolean isAlphaNumeric(String i_StringToCheck)
	 {
		 return (i_StringToCheck != null) 
				 && (!i_StringToCheck.equals("")) 
				 && i_StringToCheck.matches("^[a-zA-Z0-9]*$");
	 }
}
