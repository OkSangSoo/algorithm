package Recursive;

import java.util.*;

public class FastExponential {
    static int Recursion(int x, int n){
        if(n == 0) return 1;
        else if(n % 2 == 1){
            return (int) (x * (Math.pow(Recursion(x, (n-1)/2) % 1000, 2)));
        }
        else{
            return (int) Math.pow(Recursion(x,n/2) % 1000,2);
        }
    }

    static void FE(ArrayList<int[]> inputs, int inputnum){
        for(int i = 0; i < inputnum; i ++){
            int result = Recursion(inputs.get(i)[0], inputs.get(i)[1]);
            System.out.println(result%1000);
        }
    }
    public static void main(String[] args) {
        ArrayList<int[]> inputs = new ArrayList<int[]>();
        Scanner sc = new Scanner(System.in);
        int inputnum = sc.nextInt();

        for (int i = 0; i < inputnum; i++){
            int num1 = sc.nextInt();
            int num2 = sc.nextInt();
            int[] temp = new int[]{num1, num2};
            inputs.add(temp);
        }

        FE(inputs,inputnum);
    }
}
