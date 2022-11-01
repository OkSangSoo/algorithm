package Recursive;

import java.util.*;

public class FibonacciCalc {
    static int Recursion(int n){
        if (n <= 1) return n;
        else return Recursion(n-1) + Recursion(n-2);

    }
    static void FC(ArrayList<Integer> inputs, int inputnum){
        for(int i = 0; i < inputnum; i++){
            int result = Recursion(inputs.get(i));
            System.out.println(result);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputnum = sc.nextInt();
        ArrayList<Integer> inputs = new ArrayList<Integer>();

        for (int i = 0; i < inputnum; i++){
            inputs.add(sc.nextInt());
        }

        FC(inputs, inputnum);
    }
}
