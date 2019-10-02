package stock;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
 import java.util.Scanner;
public class PassWordValidator{
 
    private static Pattern pattern;
    private static Matcher matcher;
 public static void main(String args[]){
     
    
    
 }
    private static final String PASSWORD_PATTERN = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
//    Be between 8 and 40 characters long
//    Contain at least one digit.
//    Contain at least one lower case character.
//    Contain at least one upper case character.
//    Contain at least on special character from [ @ # $ % ! . ].
    
    public static void PasswordValidator() {
        pattern = Pattern.compile(PASSWORD_PATTERN);
    }
 
    public static boolean validate(String password) {
    	 PasswordValidator();
        matcher = pattern.matcher(password);
        return matcher.matches();
 
    }
}