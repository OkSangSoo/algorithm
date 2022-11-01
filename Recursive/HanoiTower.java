package Recursive;

import java.util.*;

public class HanoiTower {
    //Stack<Integer> Cstack = new Stack<Integer>();
    ArrayList<Integer> Clist = new ArrayList<Integer>();
    void Recursion(int n, int a, int b , int c){
        if (n > 0){
            Recursion(n-1, a, c ,b);
            if(c == 3){
                //Cstack.push(n);
                //System.out.print(Cstack.peek() + " ");
                Clist.add(n);
                System.out.print(Clist.get(Clist.size()-1) + " ");
            }
            else if(a == 3){
                //Cstack.pop();
                //System.out.print(Cstack.peek() + " ");
                Clist.remove(Clist.size()-1);
                System.out.print(Clist.get(Clist.size()-1)+" ");
            }
            //System.out.println("Disk " + n + " move from " + a + " to " + c);
            Recursion(n-1, b, a, c);
        }
    }

    void HT(ArrayList<Integer> inputs , int inputnum){
        for(int i = 0; i < inputnum; i++){
            //Cstack.clear();
           // Cstack.push(0);
            Clist.clear();
            Clist.add(0);
            Recursion(inputs.get(i), 1,2,3);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputnum = sc.nextInt();
        ArrayList<Integer> inputs = new ArrayList<Integer>();

        for (int i = 0; i < inputnum; i++){
            inputs.add(sc.nextInt());
        }
        HanoiTower ht = new HanoiTower();
        ht.HT(inputs, inputnum);
    }
}
