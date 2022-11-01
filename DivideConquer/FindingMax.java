package DivideConquer;

import java.util.*;

public class FindingMax {

    static int Recursion(int a[], int left, int right){
        if (left == right) return a[left];
        else{
            int half = (left + right) / 2;
            int leftMax = Recursion(a, left, half);
            int rightMax = Recursion(a, half + 1, right);
            return leftMax >= rightMax ? leftMax : rightMax;
        }
    }
    static void FM(ArrayList<int[]> inputs, int inputnum){
        for(int i = 0; i < inputnum; i++){
            int[] target = inputs.get(i);
            int result = Recursion(target,0,target.length-1);
            System.out.println(result);
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputnum = sc.nextInt();

        ArrayList<int[]> inputs = new ArrayList<int[]>();

        for (int i = 0; i < inputnum; i ++){
            int arraySize= sc.nextInt();
            int[] tempArray = new int[arraySize];
            for(int j = 0; j < arraySize; j++){
                tempArray[j] = sc.nextInt();
            }
            inputs.add(tempArray);
        }

        FM(inputs, inputnum);
    }
}
