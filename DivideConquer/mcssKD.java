package DivideConquer;

import java.util.*;

public class mcssKD {
    int start = -1;
    int end = -1;

    int maxSum(int[] a, int n){
        int maxSum = 0;
        int thisSum = 0;
        int i = 0;
        for (int j = 0; j < n; j++){
            thisSum += a[j];
            if(thisSum > maxSum){
                maxSum = thisSum;
                start = i;
                end = j;
            }
            else if(thisSum <= 0){
                i = j + 1;
                thisSum = 0;
            }
        }
        return maxSum;
    }
    void MK(ArrayList<int[]> inputs, int inputnum){
        for(int i = 0; i < inputnum; i++){
            int[] tempArray = inputs.get(i);
            start = -1;
            end = -1;
            int result = maxSum(tempArray, tempArray.length);
            System.out.println(result + " " + start + " " + end);

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

        mcssKD mk = new mcssKD();
        mk.MK(inputs, inputnum);
    }
}
