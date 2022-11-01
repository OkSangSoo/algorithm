package Sort;

import java.util.*;


public class InsertionSort {
    public static void Insertion(ArrayList<Integer> Inp, int leng){
        int countComp = 0;
        int countSwap = 0;
        int temp;

        for (int i = 1; i < leng; i ++){
            for (int j = i; j > 0; j--){
                countComp += 1;
                if (Inp.get(j-1) > Inp.get(j)){
                    countSwap += 1;
                    temp = Inp.get(j-1);
                    Inp.set(j-1, Inp.get(j));
                    Inp.set(j, temp);
                }
                else{
                    break;
                }
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
            InsertionSort.Insertion(Inputs[i], Inputs[i].size());
        }
    }
}
