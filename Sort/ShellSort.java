package Sort;

import java.util.*;

public class ShellSort {
    public static void Shell(ArrayList<Integer> Inp, int leng){
        int shrinkRatio = 2;
        int gap = leng / shrinkRatio;

        int countComp = 0;
        int countSwap = 0;
        int temp;

        while(gap > 0){

            for(int i = gap; i < leng; i++){
                temp = Inp.get(i);
                int j;

                for(j = i; j >= gap; j -= gap){
                    if (Inp.get(j-gap) > temp) {
                        countComp += 1;
                        countSwap += 1;
                        Inp.set(j, Inp.get(j - gap));
                    }
                    else{
                        countComp+=1;
                        break;
                    }
                }
                Inp.set(j, temp);
            }
            gap /= shrinkRatio;
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
            ShellSort.Shell(Inputs[i], Inputs[i].size());
        }
    }
}
