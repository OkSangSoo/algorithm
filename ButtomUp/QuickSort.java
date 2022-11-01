import java.util.ArrayList;
import java.util.Scanner;

public class QuickSort {
    static int countCompH;
    static int countCompL;
    static int countSwapH;
    static int countSwapL;
    static int partitionL(int[] a, int low, int high){
        int pivot = a[low];
        int j = low;
        for(int i = low + 1; i <= high; i++){
            countCompL += 1;
            if(a[i] < pivot){
                j = j + 1;

                countSwapL += 1;
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        int pivot_pos = j;

        countSwapL+= 1;
        int tmp = a[low];
        a[low] = a[pivot_pos];
        a[pivot_pos] = tmp;

        return pivot_pos;
    }
    static void QSL(int[] a, int low, int high){
        if (low >= high) return;
        int p = partitionL(a, low, high);
        QSL(a, low, p - 1);
        QSL(a, p+1, high);
    }

    static int partitionH(int[] a, int low, int high){
        int pivot = a[low];
        int i = low - 1;
        int j = high + 1;
        while(true) {
            do{
                i += 1;
                countCompH += 1;
            } while (a[i] < pivot);
            do{
                countCompH += 1;
                j -= 1;
            } while (a[j] > pivot);

            if (i < j) {
                countSwapH += 1;
                int tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
            else return j;
        }
    }
    static void QSH(int[] a, int low, int high){
        if (low >= high) return;
        int p = partitionH(a, low, high);
        QSH(a, low, p);
        QSH(a, p+1, high);
    }
    static void QS(ArrayList<int[]> inputs, int inputnum){
        for(int i = 0; i < inputnum; i++){
            countCompH = 0;
            countCompL = 0;
            countSwapH = 0;
            countSwapL = 0;

            int[] tempArrayH = inputs.get(i);
            int[] tempArrayL = new int[tempArrayH.length];
            for(int j = 0; j < tempArrayH.length; j++){
                tempArrayL[j] = tempArrayH[j];
            }

            QSH(tempArrayH, 0, tempArrayH.length - 1 );
            QSL(tempArrayL, 0, tempArrayL.length - 1);

            System.out.println(countSwapH + " " + countSwapL + " " + countCompH + " " + countCompL);
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

        QS(inputs, inputnum);
    }
}
