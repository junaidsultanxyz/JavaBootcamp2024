package yes;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//         Q - 1 : Factorial
        System.out.print("Number for factorial : ");
        int q1Input = input.nextInt();

        System.out.println("Q - 1 : " + Factorial(q1Input));



        System.out.println();
//         Q - 2 : Palindrome
        System.out.print("Palindrome check : ");
        input.nextLine();
        String q2Input = input.nextLine();

        if (Palindrome(FormatText(q2Input))){
            System.out.println("Q - 2 : it is palindrome");
        }
        else { System.out.println("Q - 2 : it is not palindrome"); }



        System.out.println();
//         Q - 3 : Digit Counter
        System.out.print("Enter a number : ");
        int q3Number = input.nextInt();
        System.out.print("Enter a digit to find in number : ");
        int q3Digit = input.nextInt();

        System.out.println("Q - 3 : " + CountDigit(q3Number, q3Digit));



        System.out.println();
//         Q - 4 : Handshake Counter
        System.out.print("Enter number of people : ");
        int q4Number = input.nextInt();

        System.out.println("Q - 4 : " + HandshakeCount(q4Number) + " Handshakes");


        System.out.println();
//         Q - 5 : GCD
        System.out.print("Enter 1st Number : ");
        int q5Input1 = input.nextInt();
        System.out.print("Enter 2nd Number : ");
        int q5Input2 = input.nextInt();

        System.out.println("Q - 5 : " + GCD(q5Input1, q5Input2) + " is the GCD");


        System.out.println();
        // Q - 6 : Power
        System.out.print("Enter a number : ");
        int q6Input = input.nextInt();
        System.out.print("Enter the power : ");
        int q6InputPow = input.nextInt();

        System.out.println("Q - 6 : " + Power(q6Input, q6InputPow));



        System.out.println();
        /* Q - 7 : Reverse */
        System.out.print("Enter a String : ");
        input.nextLine();
        String q7Input = input.nextLine();

        System.out.println("Q - 7 : " + Reverse(q7Input, q7Input.length()));



        System.out.println();
        // Q - 8 : Power
        System.out.print("Enter the power : ");
        int q8Input = input.nextInt();
        System.out.println("Q - 8 : " + MinProduct(q8Input));
    }


    // Q - 1
    public static long Factorial(int num){
        long fac = 1;
        for (int i = num; i >= 1; i--){ fac *= i; }
        return fac;
    }

    // Q - 2
    /*public static boolean Palindrome(String input){
        boolean isPalindrome = true;
        input = input.toUpperCase();

        char[] charInput = input.toCharArray();
        ArrayList<Character> newInput = new ArrayList<>();

        for (int i = 0; i < input.length(); i++){
            if ((charInput[i] >= 'A' && charInput[i] <= 'Z') || (charInput[i] >= '0' && charInput[i] <= '9')){
                newInput.add(charInput[i]);
            }
        }

        for (int i = 0; i < newInput.size(); i++){
            if (!(newInput.get(i) == newInput.get(newInput.size() - 1 - i))){
                isPalindrome = false;
                break;
            }
        }

        return isPalindrome;
    }*/
    // Q - 2

    public static String FormatText(String str){
        str = str.toUpperCase();

        String formatString = "";

        for (int i = 0; i < str.length(); i++){
            if ((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) >= '0' && str.charAt(i) <= '9')){
                formatString += str.charAt(i);
            }
        }

        return formatString;
    }

    public static boolean Palindrome(String str){
        if (str.isEmpty() || str.length() == 1){ return true; }

        if(str.charAt(0) == str.charAt(str.length()-1))
            return Palindrome(str.substring(1, str.length()-1));

        return false;
    }

    // Q - 3
    public static int CountDigit(int number, int digit){
        if (number == 0) { return 0; }

        int lastDigit = number % 10;
        int count = (lastDigit == digit) ? 1 : 0;

        return count + CountDigit(number / 10, digit);
    }


    // Q - 4
    public static int HandshakeCount(int people){
        if (people == 1){ return 0; }

        int count = people - 1;

        return count + HandshakeCount(count);
    }

    // Q - 5
    public static int GCD(int x, int y){
        if (y == 0) { return x; }

        return GCD(y, x % y);
    }

    // Q - 6
    public static long Power(int base, int exponent){
        if (exponent == 0){ return 1; }

        return base * Power(base, exponent - 1);
    }


    // Q - 7
    public static String Reverse(String str, int length){
        if (length == 0){ return ""; }

        return str.charAt(length - 1) + Reverse(str, length - 1);
    }


    // Q - 8
    private static final long _MOD = 1000000007;

    public static long MinProduct(int input) {
        long max = (1L << input) - 1;
        long max2 = max - 1;
        long count = (1L << (input - 1)) - 1;
        long power = ModPower(max2, count, _MOD);
        return (power * (max % _MOD)) % _MOD;
    }

    private static long ModPower(long base, long exp, long mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}
