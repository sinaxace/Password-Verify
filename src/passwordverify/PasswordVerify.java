package passwordverify;
import java.util.Scanner;

/**
 *
 * @author SinaM
 */
class PasswordVerify {

    public static void main(String[] args) {
        System.out.println("Enter a password for your new account!");
        Scanner pass = new Scanner(System.in);
        String password = pass.nextLine(); //First attempt at making password
        rule(password); //Takes the user to my String method
        System.out.println("Congratulations! Your password is valid.");
    }

    public static String rule(String condition) {
        Scanner pass = new Scanner(System.in);
        while (condition.length() < 8 || condition.matches("^[a-zA-Z0-9]+$") != true || twoDigit(condition) == false) //If any of these conditions apply, it will keep looping
        {
            System.out.println("Your password must have 8 characters or more AND it cannot contain any special characters. \nTwo numbers are also a minimum requirement.");
            condition = pass.next();
        }
        return condition;
    }

    public static boolean twoDigit(String checkPass) //This boolean method checks whether there's two or more digits in the user's password
    {
        int limit = 0;
        for (int index = 0; index < checkPass.length(); index++) {
            char element = checkPass.charAt(index);//charAt checks all the password String's characters using the for loop index
            if (Character.isDigit(element))//isDigit will count all the numbers in a String
            {
                limit++;
            }
        }
        if (limit < 2)//condition to check digit limit
        {
            return false;//the loop in rule String method will keep running
        } else {
            return true;//the while loop in rule will break
        }
    }
}
/*References
https://stackoverflow.com/questions/33467536/how-to-check-if-a-string-is-made-only-of-letters-and-numbers
https://stackoverflow.com/questions/33558844/java-password-check-program-check-that-the-password-has-2-digits-only-lette
*/
