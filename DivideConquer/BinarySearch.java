package DivideConquer;

import java.util.*;

public class BinarySearch {
    static int BS(int[] a, int left, int right, int value){
        int mid;
        if (left > right) return -1;
        else{
            mid = (left + right) / 2;
            if(a[mid] == value) return mid;
            else if(a[mid] > value) return BS(a, left, mid - 1, value);
            else return BS(a, mid + 1, right, value);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> inputs = new ArrayList<int[]>();

        int inputnum = sc.nextInt();

        for(int i = 0; i < inputnum; i++){
            int arraySize = sc.nextInt();
            int targetNum = sc.nextInt();
            int[] tempArray = new int[arraySize];
            for(int j = 0; j < arraySize; j++){
                tempArray[j] = sc.nextInt();
            }
            int result = BS(tempArray, 0, arraySize - 1, targetNum);
            System.out.println(result);
        }
    }
}
