package Recursive;

import java.util.*;

public class FastFibonacci {
    static int[][] matrixMult(int[][] a, int[][] b){
        int[][] result = {{(a[0][0] * b[0][0] + a[0][1] * b[1][0]) % 1000, (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % 1000},
                {(a[1][0] * b[0][0] + a[1][1] * b[1][0]) % 1000, (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % 1000}};
        return result;
    }
    static int[][] matrixPow(int[][] a){
        int[][] result = {{(a[0][0] * a[0][0] + a[0][1] * a[1][0]) % 1000, (a[0][0] * a[0][1] + a[0][1] * a[1][1]) % 1000},
                {(a[1][0] * a[0][0] + a[1][1] * a[1][0]) % 1000, (a[1][0] * a[0][1] + a[1][1] * a[1][1]) % 1000}};
        return result;
    }
    static int[][] Recursion(int t, int[][] matrix){
        if(t <= 1) return matrix;
        else if(t % 2 == 1){
            return matrixMult(matrix, matrixPow(Recursion((t-1)/2, matrix)));
        }
        else{
            return matrixPow(Recursion(t/2, matrix));
        }
    }


    static void FF(ArrayList<Integer> inputs, int inputnum){
        for(int i = 0; i < inputnum; i++){
            int[][] matrix = {{1,1},{1,0}};
            if(inputs.get(i) ==0) System.out.println(0);
            else {
                int[][] result = Recursion(inputs.get(i), matrix);
                System.out.println(result[0][1]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputnum = sc.nextInt();
        ArrayList<Integer> inputs = new ArrayList<Integer>();

        for (int i = 0; i < inputnum; i++){
            inputs.add(sc.nextInt());
        }

        FF(inputs, inputnum);
    }
}
