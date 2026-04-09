import java.util.Scanner;
public class Calculator {
    public int num1 , num2 , ch;
    public int addNums (int n1 , int n2){
        return n1 + n2;
    }
    public int subNums (int n1 , int n2){
        return n1 - n2;
    }
    public long mulNums (int n1 , int n2){
        return n1 * n2;
    }
    public float divNums (int n1 , int n2){
        return n1 / n2;
    }
    public float modNums (int n1 , int n2){
        return n1 % n2;
    }

    public static void main(String[] args){
        Calculator c = new Calculator();
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter 1st Number :");
        c.num1 = scan.nextInt();
        System.out.println("Enter 2nd Number :");
        c.num2 = scan.nextInt();
        if (c.num2 == 0){
            System.out.println("Number cannot be 0 !");
            System.exit(0);
        }
        while (true){
            System.out.println("\nEnter Operation you want to perform :\n 1.Addition\n 2.Subtraction\n 3.Multiplication\n 4.Division\n 5.Modulus\n");
            c.ch = scan.nextInt();
            if (c.ch == 0){
            System.out.println("Invalid Choice !");
            System.exit(0);
            }
            switch(c.ch){
                case 1:
                    int sum = c.addNums(c.num1 , c.num2);
                    System.out.println("\nSum :"+ sum);
                    break;

                case 2:
                    int diff = c.subNums(c.num1 , c.num2);
                    System.out.println("\nDifference :"+ diff);
                    break;

                case 3:
                    long prod = c.mulNums(c.num1 , c.num2);
                    System.out.println("\nProduct :"+ prod);
                    break;

                case 4:
                    float div = c.divNums(c.num1 , c.num2);
                    System.out.println("\nDivision :"+ div);
                    break;

                case 5:
                    float rem = c.modNums(c.num1 , c.num2);
                    System.out.println("\nReminder :"+ rem);
                    break;
                
                default:
                    System.out.println("\nInvalid Choice !!!");


            }
            
        }

    }
}