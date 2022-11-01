package DivideConquer;

import java.util.*;

public class MergeSort {
    int count = 0;
    void merge(int[] v, int low, int mid, int high){
        int i, j, k;
        int[] tmp = new int[v.length];

        for(i = low; i <= high; i++){
            tmp[i] = v[i];
        }

        i = k = low;
        j = mid + 1;

        while(i <= mid && j <= high){
            count += 1;
            if(tmp[i] <= tmp[j]){
                v[k++] = tmp[i++];
            }
            else{
                v[k++] = tmp[j++];
            }
        }
        while(i <= mid){
            v[k++] = tmp[i++];
        }
        while(j <= high){
            v[k++] = tmp[j++];
        }
        /*
        for(int s = 0; s < tmp.length; s ++){
            System.out.print(tmp[s] + " ");
        }
        System.out.println();

         */

    }

    void sort(int[] v, int low, int high){
        int mid;
        if(low == high) return;

        mid = (low + high) / 2;

        sort(v, low, mid);
        sort(v, mid + 1, high);
        merge(v, low, mid, high);
    }


    void MS(ArrayList<int[]> inputs, int inputnum){
        for(int i = 0; i < inputnum; i ++){
            count = 0;
            int[] tempArray = inputs.get(i);
            sort(tempArray, 0, tempArray.length - 1);
            System.out.println(count);
            /*
            for(int s = 0; s < tempArray.length; s ++){
                System.out.print(tempArray[s] + " ");
            }
            System.out.println();

             */
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

        MergeSort ms = new MergeSort();
        ms.MS(inputs, inputnum);
    }
}
