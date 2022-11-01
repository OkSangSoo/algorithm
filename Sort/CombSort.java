package Sort;

import java.util.*;

public class CombSort {
    public static void Comb(ArrayList<Integer> Inp, int leng){
        double shrink = 1.3;
        int gap = leng;
        boolean sorted = false;

        int countComp = 0;
        int countSwap = 0;
        int temp;

        while(sorted == false){
            gap = (int) Math.floor(gap/shrink);
            if (gap <= 1){
                gap = 1;
                sorted = true;
            }
            int i = 0;
            while(i + gap < leng) {
                countComp += 1;
                if (Inp.get(i) > Inp.get(i + gap)) {
                    countSwap += 1;
                    temp = Inp.get(i);
                    Inp.set(i, Inp.get(i + gap));
                    Inp.set(i + gap, temp);
                    sorted = false;
                }
                i = i+1;
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
            CombSort.Comb(Inputs[i], Inputs[i].size());
        }
    }
}
