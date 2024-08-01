package meow;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        /* Question - 1 : Palindrome String */
        System.out.print("Enter any string : ");
        String q1Input = input.nextLine();

        boolean q1Check = true;
        for (int i = 0; i < q1Input.length() / 2; i++) {
            if (q1Input.charAt(i) != q1Input.charAt(q1Input.length() - 1 - i)) {
                q1Check = false;
                break;
            }
        }

        if (q1Check) { System.out.println("Q - 1 : It is palindrome"); }
        else { System.out.println("Q - 1 : It is not palindrome");}


        System.out.println();
        /* Question - 2 : UMT email id
        F2023065101@gmail.com
        bilalarif@gmail.com         */

        System.out.print("Enter UMT Email ID : ");
        String q2Input = input.nextLine();
        
        boolean q2InputReg = EmailCheckRegex(q2Input);
        
        if (q2InputReg) { System.out.println("Q - 2 : valid (RegEx)"); }
        else { System.out.println("Q - 2 : invalid (RegEx)"); }
        
        q2Input = q2Input.toUpperCase();
        String q2InputSelf = EmailCheckManual(q2Input);
        if (q2InputSelf.equalsIgnoreCase("invalid")){ System.out.println("Q - 2 : invalid (Self)");}
        else { System.out.println("Q - 2 : valid (Self) -" + q2InputSelf);}


        System.out.println();
        /* Question - 3 : 2024-7-24 to 24-7-2024 */

        LocalDate q3Input = LocalDate.now();
        String q3NewDate = q3Input.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        System.out.println("Q - 3 : " + q3NewDate);



        System.out.println();
        /* Question - 4 : add 30 days */

        LocalDate q4Date = LocalDate.now();
        q4Date = q4Date.plusDays(30);
        String q4NewDate = q4Date.format(DateTimeFormatter.ofPattern("dd-MM-YYYY"));
        System.out.println("Q - 4 : " + q4NewDate);



        System.out.println();
        /* Question - 5 : num to roman */

        System.out.print("Enter a number : ");
        int q5Input = input.nextInt();

        int[] q5Num = {1000, 500, 100, 50, 10, 5, 1};
        String[] q5Roman = { "M", "D", "C", "L",  "X", "V", "I" };

        String q5Final = "";
        for (int i = 0; i < q5Num.length; i++){
            int num = q5Input/q5Num[i];

            if (num == 0) { continue; }

            if (num == 4 && i > 0) { q5Final += q5Roman[i] + q5Roman[i-1]; }
            else { q5Final += q5Roman[i]; }

            q5Input = q5Input % q5Num[i];
        }

        System.out.println("Q - 5 : " + q5Final);



        System.out.println();
        /* Question - 6 : Bracket Format Check */

        System.out.print("Enter the brackets : ");
        String q6Input2 = input.nextLine();
        String q6Input = input.nextLine();

        if(Pattern.compile("\\(\\)|\\(\\)\\{\\}\\[\\]|\\[\\{\\(\\)\\}\\]").matcher(q6Input).matches())
            { System.out.println("Q - 6 : valid"); }
        else
            { System.out.println("Q - 6 : Invalid"); }



        System.out.println();
        /* Question - 7 : Common Prefix */

        String[] q7Input = {"flower","flow","flight" };

        if ( q7Input.length == 0 ) { System.out.println("Empty String"); }
        else if( q7Input.length == 1 ) { System.out.println(q7Input[0]); }
        else
        {
            String q7Str = q7Input[0];
            for (int i = 1; i < q7Input.length ; i++)
            {
                String q7Current = q7Input[i];

                int j = 0;
                while (j < q7Current.length() && j < q7Str.length() && q7Current.charAt(j) == q7Str.charAt(j) ){ j++; }
                if (j == 0) {
                    System.out.println("unmatched");
                    break;
                }
                q7Str = q7Current.substring( 0 , j );
            }
            System.out.println("Q - 7 : " + q7Str);

        }



        System.out.println();
        /* Question - 8 : Duplicate Removal */

        System.out.print("Enter to remove duplicate : ");
        String q8Input = input.nextLine();

        char[] q8Data = q8Input.toCharArray();

        ArrayList<Character> q8DupCheck = new ArrayList<>();
        for (char c : q8Data){
            if (!(q8DupCheck.contains(c))){ q8DupCheck.add(c); }
        }

        System.out.print("Q - 8 : ");
        for (char c : q8DupCheck){
            System.out.print(c);
        }

        input.close();
    }

    public static String EmailCheckManual(String emailInput){
        String accType = "";

        int indexOfAt = emailInput.indexOf('@');
        String checkEmailFormat = "";
    
        
        boolean check = false;
        for (int quickCheck = 0; quickCheck < 1; quickCheck++){
            
            String idPart;
            // if @ exist, read the (gmail part) and the (id part)
            if (indexOfAt != -1){
                checkEmailFormat += emailInput.substring(indexOfAt, emailInput.length()); // gmail
                idPart = emailInput.substring(0, indexOfAt);   // id
            }
            else { break; }
    
            int dotCount = 0;
                
                // if the gmail format is correct
            if (checkEmailFormat.equalsIgnoreCase("@gmail.com") && (emailInput.charAt(0) >= 'A' && emailInput.charAt(0) <= 'Z'))
            {   
                // checking accout type based on second character
                if ((idPart.charAt(1) >= 'A'  && idPart.charAt(1) <= 'Z') || idPart.charAt(1) == '.')
                {
                    accType += "Faculty";
                    
                    char[] account = idPart.toCharArray(); // FOR UNREPEATED LOOP
    
                    for (int i = 1; i < idPart.length(); i++){
                        if (idPart.charAt(i) == '.'){
                            dotCount ++;
                        } // dot check
    
                        if ((!(account[i] >= 'A' && account[i] <= 'Z' || account[i] == '.') || (dotCount > 1))){
                            check = false;
                            break;
                        }

                        check = true;
                    }
                }
                else if ((idPart.charAt(1) >= '0'  && idPart.charAt(1) <= '9'))
                {
                    accType += "Student";

                    char[] account = idPart.toCharArray(); // FOR UNREPEATED LOOP
    
                    for (int i = 1; i < idPart.length(); i++){
    
                        if (!(account[i] >= '0' && account[i] <= '9')){
                            check = false;
                            break;
                        }

                        check = true;
                    }
    
                }
                else { check = false; }
            }
            else { check = false; }
        }

        if (check) { return accType; }
        else
        {
            accType = "Invalid";
            return accType;
        }
    }

    public static boolean EmailCheckRegex(String email){
        Pattern pattern = Pattern.compile("([a-zA-Z]+\\d+|[a-zA-Z]+|[a-zA-Z]+.[a-zA-Z]+)@gmail.com");
        Matcher matcher = pattern.matcher(email);
        boolean q2Check = matcher.matches();

        return q2Check;
    }
}