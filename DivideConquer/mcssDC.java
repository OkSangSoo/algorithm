package DivideConquer;

import java.util.*;

public class mcssDC {
    static int findMaxSum(int[] a, int left, int right){
        if (a.length == 0) return 0;
        else{
            if(left == right){
                return a[left];
            }

            int mid = (left + right) / 2;

            int maxLeft = 0;
            int sum = 0;
            for (int i = mid; i >= left; i--){
                sum += a[i];
                if(sum > maxLeft) maxLeft = sum;
            }

            int maxRight = 0;
            sum = 0;
            for (int i = mid + 1; i <= right; i++){
                sum += a[i];
                if(sum > maxRight) maxRight = sum;
            }

            int maxTotal = maxLeft + maxRight;

            int leftMax = findMaxSum(a, left, mid);
            int rightMax = findMaxSum(a, mid + 1, right);
            int maxLeftRight = leftMax >= rightMax ? leftMax : rightMax;

            int max = maxLeftRight >= maxTotal ? maxLeftRight : maxTotal;

            return max;
        }

    }
    static void MD(ArrayList<int[]> inputs, int inputnum){
        for(int i = 0; i < inputnum; i++){
            int[] tempArray = inputs.get(i);
            int result = findMaxSum(tempArray, 0, tempArray.length - 1);
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

        MD(inputs, inputnum);
    }
}
