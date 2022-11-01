package Sort;

import java.util.*;

public class BubbleSort {
    public static void B(ArrayList<Integer> Inp, int leng){
        int countComp = 0;
        int countSwap = 0;
        int temp;

        for(int i = 1; i < leng; i++){
            for(int j = 1; j <= leng - i; j++){
                countComp += 1;
                if(Inp.get(j-1) > Inp.get(j)){
                    countSwap += 1;
                    temp = Inp.get(j-1);
                    Inp.set(j-1, Inp.get(j));
                    Inp.set(j, temp);
                }
            }
        }

        System.out.print(countComp + " " + countSwap + " ");

    }
    public static void B1(ArrayList<Integer> Inp, int leng){
        int countComp = 0;
        int countSwap = 0;
        int temp;
        boolean swapped;

        for (int i = 1; i < leng; i++){
            swapped = false;
            for (int j = 1; j <= leng - i; j ++){
                countComp += 1;
                if(Inp.get(j-1) > Inp.get(j)){
                    countSwap += 1;
                    temp = Inp.get(j-1);
                    Inp.set(j-1, Inp.get(j));
                    Inp.set(j, temp);
                    swapped = true;
                }
            }
            if (swapped == false) break;
        }


        System.out.print(countComp + " " + countSwap + " ");

    }
    public static void B2(ArrayList<Integer> Inp, int leng){
        int countComp = 0;
        int countSwap = 0;
        int temp;
        int lastSwappedPos = leng;

        while(lastSwappedPos > 0){
            int swappedPos = 0;
            for(int i = 1; i < lastSwappedPos; i++){
                countComp += 1;
                if (Inp.get(i-1) > Inp.get(i)){
                    countSwap += 1;
                    temp = Inp.get(i-1);
                    Inp.set(i-1, Inp.get(i));
                    Inp.set(i,temp);
                    swappedPos = i;
                }

            }
            lastSwappedPos = swappedPos;
        }


        System.out.println(countComp + " " + countSwap);
    }
    public static void Bubble(ArrayList<Integer> Inp, int leng){
        ArrayList<Integer> Input1 = new ArrayList<>(Inp);
        ArrayList<Integer> Input2 = new ArrayList<>(Inp);
        ArrayList<Integer> Input3 = new ArrayList<>(Inp);
        B(Input1,leng);
        B1(Input2,leng);
        B2(Input3,leng);
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
            BubbleSort.Bubble(Inputs[i], Inputs[i].size());
        }
    }
}
