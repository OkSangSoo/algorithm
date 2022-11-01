import java.util.*;

public class MergeSortIter {
    int count;

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
    }

    void sort(int[] v, int n){
        int size = 1;
        while(size < n){
            for(int i = 0; i < n; i += 2*size){
                int low = i;
                int mid = (low + size - 1) < (n - 1) ? (low + size - 1) : (n -1);
                int high = (i + 2*size - 1) < (n - 1) ? (i + 2*size - 1) : (n - 1);
                merge(v, low, mid, high);
            }
            size *= 2;
        }
    }
    void MSI(ArrayList<int[]> inputs, int inputnum){
        for(int i = 0; i < inputnum; i ++){
            count = 0;
            int[] tempArray = inputs.get(i);
            sort(tempArray, tempArray.length);
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

        MergeSortIter ms = new MergeSortIter();
        ms.MSI(inputs, inputnum);
    }
}

