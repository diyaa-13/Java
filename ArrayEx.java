import java.util.Scanner;
import java.util.Arrays;
public class ArrayEx {
    public static void main(String[] args) {
        int[] iArr;
        iArr = new int[5];
        iArr[0] = 20;
        iArr[1] = 40;
        iArr[2] = 100;
        iArr[3] = 32;
        iArr[4] = 22;

        for (int i =0 ; i < 5; i++){
            System.out.println(iArr[i]);
        }
        int[] evens = new int[]{2, 4, 6, 8,10, 12};
        for (int i:evens){
            System.out.println(i);
        }
        int[] tableof5 = {5, 10, 15, 20, 25, 30};
        int[] iArr1 = new int[5];
        System.arraycopy(iArr, 0, iArr1, 0, 5);
        for (int i: iArr1){
            System.out.println(i);
        }
        String[] fruits = new String[]{"apple","banna","cashew","grapes","pear"};
        for (String f : fruits){
            if (f.contains("ap")){
                System.out.println(f);
            }
        }
    
    }

}
