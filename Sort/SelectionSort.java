package Sort;

import java.util.*;

public class SelectionSort {
    public static void Selection(ArrayList<Integer> Inp, int leng){
        int countComp = 0;
        int countSwap = 0;
        int temp;

        for (int i = 0; i < leng-1; i++){
            int Jmin = i;
            for (int j = i+1; j < leng; j++){
                countComp += 1;
                if (Inp.get(j)<Inp.get(Jmin)) {
                    Jmin = j;
                }
            }
            if (Jmin != i){
                countSwap += 1;
                temp = Inp.get(i);
                Inp.set(i, Inp.get(Jmin));
                Inp.set(Jmin, temp);
            }
        }

        System.out.println(countComp + " " + countSwap);


    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputnum = sc.nextInt();
        ArrayList<Integer>[] Inputs = new ArrayList[inputnum];
        for(int i = 0; i < inputnum; i++){
            ArrayList<Integer> tempList = new ArrayList<Integer>();
            int numbers = sc.nextInt();
            for (int j = 0; j < numbers; j++){
                tempList.add(sc.nextInt());
            }
            Inputs[i] = tempList;
        }

        for(int i = 0; i < inputnum; i++){
            SelectionSort.Selection(Inputs[i], Inputs[i].size());
        }

    }
}
