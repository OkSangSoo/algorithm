import java.util.*;

public class BalanceScale {

    static int DP(int gap){
        int[] mass = {1,2,5,10,20,50,100};
        int numMass = mass.length;
        int[] massUsed = new int[gap+1];
        int[] lastMass = new int[gap+1];

        for (int m = 1; m <= gap; m++){
            int minMass = m;
            int newMass = 1;
            for(int j = 0; j < numMass; j++){
                if(mass[j] > m) continue;;
                if(massUsed[m - mass[j]] + 1 < minMass){
                    minMass = massUsed[m - mass[j]] + 1;
                    newMass = mass[j];
                }
            }
            massUsed[m] = minMass;
            lastMass[m] = newMass;
        }

        return massUsed[gap];
    }
    static void calculator(int[] a, int size){

        int gap = 0;
        for(int i = 0; i < size; i++){
            if (gap <= 0) gap += a[i];
            else gap -= a[i];
        }
        if (gap < 0) gap = gap * (-1);

        System.out.println(DP(gap));
/*
        int[] mass = {1,2,5,10,20,50,100};
        int pickMass;
        int count = 0;

        for(pickMass = 6; pickMass >= 0; pickMass--){
            count += gap / mass[pickMass];
            gap = gap % mass[pickMass];
        }
        System.out.println(count);

 */
    }

    static void BS(ArrayList<int[]> inputs, int inputnum){
        for (int i = 0; i < inputnum; i++){
            int[] tempArray = inputs.get(i);
            calculator(tempArray, tempArray.length);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<int[]> inputs = new ArrayList<int[]>();

        int inputnum = sc.nextInt();
        for(int i = 0; i < inputnum; i ++){
            int arraySize = sc.nextInt();
            int[] tempArray = new int[arraySize];
            for (int j = 0; j < arraySize; j ++){
                tempArray[j] = sc.nextInt();
            }
            inputs.add(tempArray);
        }
        BS(inputs, inputnum);
    }
}
