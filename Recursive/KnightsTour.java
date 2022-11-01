package Recursive;

import java.util.*;

public class KnightsTour {
    int[][] board;
    int[][] path;
    int[][] direction = {{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}};

    boolean Recursion(int m, int n, int[] pos, int counter){
        int[] next = new int[2];

        if(counter == m * n) return true;

        for(int i = 0; i < 8; i++){
            next[0] = pos[0] + direction[i][0];
            next[1] = pos[1] + direction[i][1];

            if (next[0] >= 0 && next[1] >= 0 && next[0] < n && next[1] < m){
                if (board[next[1]][next[0]] != 1) {
                    board[next[1]][next[0]] = 1;
                    path[next[1]][next[0]] = counter + 1;
                    if (Recursion(m, n, next, counter + 1)) return true;

                    board[next[1]][next[0]] = 0;
                }
            }
        }

        return false;
    }

    void KT(ArrayList<int[]> inputs, int inputnum){
        for(int i = 0; i< inputnum; i++){
            //System.out.println(Arrays.toString(inputs.get(i)));
            int m = inputs.get(i)[0];
            int n = inputs.get(i)[1];
            board = new int[m][n];
            path = new int[m][n];
            int[] pos = {inputs.get(i)[3]-1, inputs.get(i)[2]-1};
            board[pos[1]][pos[0]] = 1;
            path[pos[1]][pos[0]] = 1;
            boolean result = Recursion(m, n, pos, 1);
            if (result) {
                System.out.println(1);
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        System.out.print(path[j][k] + " ");
                    }
                    System.out.println();
                }
            }
            else System.out.println(0);

        }

    }

    public static void main(String[] args) {
        ArrayList<int[]> inputs = new ArrayList<int[]>();
        Scanner sc = new Scanner(System.in);
        int inputnum = sc.nextInt();

        for (int i = 0; i < inputnum; i++){
            int[] temp = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()};
            inputs.add(temp);
        }

        KnightsTour kt = new KnightsTour();
        kt.KT(inputs,inputnum);
    }
}
