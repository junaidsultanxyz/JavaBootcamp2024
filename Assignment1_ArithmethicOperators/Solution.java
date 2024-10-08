package folder;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
/* Q - 1 : Ramesh’s basic salary is 105000. His dearness allowance is 40% of basic salary, and house rent allowance is 20% 
of basic salary. Write a program to calculate his gross salary */

        System.out.println("Q - 1 : Gross Salary = " + (105000 + 105000*0.4 + 105000*0.2));

System.out.println();
/* Q - 2 : The distance between two cities (in km.) is 2614. Write a program to convert and print this distance in 
meters, feet, inches and centimeters */

        int km = 2614;
        
        System.out.println(
            """
            Q - 2:
            KM : """ +   km    + "\n" +
            "Feet : " +  km * 3280.84   + "\n" + 
            "Inches : " +  km * 39370.1 + "\n" +
            "Meters : " + km*10000 + "\n" +
            "CentiMeter : " +   km * 100000
        );

System.out.println();
/* Q - 3 : If the marks obtained by a student in five different subjects are 80,90,75,60,100, find out the aggregate 
marks and percentage marks obtained by the student. Assume that the maximum marks that can be 
obtained by a student in each subject is 100 */

        int aggregateMarks = (80 + 90 + 75 + 60 + 100);
        float percentage = (aggregateMarks* 100)/500 ;
        System.out.println("""
                           Q - 3 : 
                           Aggregate Marks : """ + aggregateMarks + "\n" +
                           "Percentage : " + percentage);

System.out.println();
/* Q - 4 : Temperature of a city in Fahrenheit degrees is 108F. Write a program to convert this temperature into 
Centigrade degrees */

        int tempInF = 108;
        int tempInC = (tempInF - 32)*(5/9);
        System.out.println(
            """
            Q - 4:
            Fahrenheit : """ + tempInF + "\n" +
            "Celcius : " + tempInC
        );

System.out.println();
/* Q - 5 : The length & breadth of a rectangle and radius of a circle are 36. Write a program to calculate the area 
& perimeter of the rectangle, and the area & circumference of the circle */

        int measurement = 36 ;
        System.out.println("""
            Q - 5:
            Area of Rectange : """ + measurement*measurement + "\n" +
            "Perimeter of Rectangle : " + 2*(measurement*2) + "\n" +
            "Area of Circle : " + 3.142 * (measurement*measurement) + "\n" +
            "Circumference of Circle : " + 2* 3.142* measurement
        );

System.out.println();
/* Q - 6 : Take two positive number 8 and 12 from user. Calculate and display a^n.
Assume that the power operator or built-in function is available */

        int num1 = 8, num2 = 12;
        System.out.println("""
                           Q - 6: 
                           """ +Math.pow(num1, num2));

System.out.println();
/* Q - 7 : If a five-digit number is 12345, write a program to calculate the sum of its digits? (Hint: Use the modulus 
operator ‘%’) */

        int a = 12345;
        int sum = 0;

        while(a > 0){
            sum += a%10;
            a /= 10;
        }

        System.out.println("""
                           Q - 7:
                           Sum : """ + sum
        );

System.out.println();
/* Q - 8 : In a town, the percentage of men is 52. The percentage of total literacy is 48. If total percentage of 
literate men is 35 of the total population, write a program to find the total number of illiterate men 
and women if the population of the town is 80,000 */

        double totalPopulation = 80000;
        double literacy = 0.48 * totalPopulation;
        double totalMen = 0.52 * totalPopulation;
        double IMen = totalMen - 0.35 *totalPopulation;
        double IWomen = literacy - IMen;

        System.out.println("""
                           Q - 8: 
                           Illetrate Men : """ + IMen + "\n" +
                "Illetrate Women : " + IWomen

        );

System.out.println();
/* Q - 9 : A cashier has currency notes of denominations 10, 50 and 100. If the amount to be withdrawn is input 
through the keyboard in hundreds, find the total number of currency notes of each denomination the 
cashier will have to give to the withdrawer */
        Scanner input = new Scanner(System.in);
        
        // Input the amount to be withdrawn (in hundreds)
        System.out.print("""
                         Q - 9:
                         Enter the amount to be withdrawn : """);
        int n = input.nextInt();
        int h = n / 100;
        n = n % 100;

        int f = n / 50;
        n = n % 50;

        int t = n / 10;
        n = n % 10;
    
        input.close();

        System.out.println(
            "Hundreds : " + h + "\n" +
            "Fifty : " + f + "\n" +
            "Tens : " + t + "\n" +
            "Remaining : " + n
        );

System.out.println();
/* Q - 10 : If the total selling price of 15 items and the total profit earned on them is 20%, write a program to find 
the cost price of one item */

        double totalSellingPrice = 1000;
        double profit = 20 / 100.0;

        double costTotal = totalSellingPrice / (1 + profit);
        double cost = costTotal / 15.0;
        System.out.println(
            """
            Q - 10: Assume total Selling price is 1000
            Cost OF 1 : """ + cost
        );
    }
}
