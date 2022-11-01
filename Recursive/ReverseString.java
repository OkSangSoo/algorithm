package Recursive;

import java.util.*;

public class ReverseString {
    public static void Recursion(char[] input, int i, int j){
        if(i < j){
            char temp = input[i];
            input[i] = input[j];
            input[j] = temp;
            Recursion(input, i+1, j-1);
        }
        else{
            for(int k = 0; k < input.length; k++){
                System.out.print(input[k]);
            }
            System.out.println();
        }
    }

    public static void RS(ArrayList<char[]> inputs, int inputnum){
        for(int i = 0; i < inputnum; i++) Recursion(inputs.get(i), 0, inputs.get(i).length-1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputnum = sc.nextInt();
        sc.nextLine();
        String input;

        ArrayList<char[]> inputs = new ArrayList<char[]>();
        for (int i = 0; i < inputnum; i++){
            input = sc.nextLine();
            inputs.add(input.toCharArray());
        }

        RS(inputs, inputnum);
    }
}
