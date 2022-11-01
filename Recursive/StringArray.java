package Recursive;

import java.util.*;

public class StringArray{
    ArrayList<String> result = new ArrayList<String>();

    void Recursion(char[] word, int begin, int end){
        int i;
        int range = end-begin;
        char temp;
        if (range == 1) {
            //System.out.println(word);
            String tem = "";
            for(int s = 0; s < word.length; s++) tem+=word[s];
            result.add(tem);

        }
        else{
            for(i = 0; i < range; i++){
                temp = word[begin];
                word[begin] = word[begin+i];
                word[begin+i] = temp;

                Recursion(word, begin+1, end);

                temp = word[begin];
                word[begin] = word[begin+i];
                word[begin+i] = temp;
            }
        }
    }
    void SA(ArrayList<char[]> inputs, int inputnum){
        for(int i = 0; i < inputnum; i++){
            result.clear();
            int count = 0;
            Recursion(inputs.get(i), 0, inputs.get(i).length);
            for(int j = 0; j < result.size(); j++){
                char[] tempresult = result.get(j).toCharArray();
                int weight = 0;
                for(int k = 0; k < tempresult.length; k++){
                    weight += (Math.pow(-1, k) * (tempresult[k] - 'a'));
                    //System.out.println(tempresult[k] + " : " + weight);
                }

                if(weight > 0) count += 1;
            }
            System.out.println(count);
        }
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
        StringArray sa = new StringArray();
        sa.SA(inputs, inputnum);
    }
}
