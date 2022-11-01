package Recursive;

import java.util.*;

public class EuclidGcd {
    static void Recursion(int a, int b){
        if(b == 0) System.out.println(a);
        else if(a % b == 0 ) System.out.println(b);
        else{
            Recursion(b,a % b);
        }
    }
    static void gcd(ArrayList<int[]> inputs, int inputnum){
        for(int i = 0; i < inputnum; i++){
            Recursion(inputs.get(i)[0], inputs.get(i)[1]);
        }
    }
    public static void main(String[] args) {
        ArrayList<int[]> inputs = new ArrayList<int[]>();
        Scanner sc = new Scanner(System.in);
        int inputnum = sc.nextInt();

        for (int i = 0; i < inputnum; i++){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            if (num1 >= num2){
                int[] temp = new int[]{num1, num2};
                inputs.add(temp);
            }
            else{
                int[] temp = new int[]{num2, num1};
                inputs.add(temp);
            }
        }

        gcd(inputs, inputnum);
    }
}
