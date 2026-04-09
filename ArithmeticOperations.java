import java.util.Scanner;
public class ArithmeticOperations {
    public int num1 , num2;
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
        ArithmeticOperations op = new ArithmeticOperations();
        Scanner scan = new Scanner (System.in);
        System.out.println("Enter 1st Number :");
        op.num1 = scan.nextInt();
        System.out.println("Enter 2nd Number :");
        op.num2 = scan.nextInt();
        if (op.num2 == 0){
            System.out.println("Number cannot be 0 !");
            System.exit(0);
        }

        int sum = op.addNums(op.num1 , op.num2);
        int diff = op.subNums(op.num1 , op.num2);
        long prod = op.mulNums(op.num1 , op.num2);
        float div = op.divNums(op.num1 , op.num2);
        float rem = op.modNums(op.num1 , op.num2);
        System.out.println("Sum :"+ sum);
        System.out.println("Difference :"+ diff);
        System.out.println("Product :"+ prod);
        System.out.println("Division :"+ div);
        System.out.println("Reminder :"+ rem);
        scan.close();
    }
    
}
