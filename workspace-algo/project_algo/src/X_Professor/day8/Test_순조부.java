package X_Professor.day8;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Test_순조부 {

    static int numAmount;
    static int[] select;
    static int[] list;
    static boolean[] visit;

    static int nthArray;

    public static void main(String[] args) throws IOException {

        numAmount = 4;
        list = new int[] {1, 2, 3, 4};
        select = new int[numAmount];
        visit = new boolean[list.length];

        duplePermutation(0);

    }

    static void permutation(int cnt) {
        if (cnt == numAmount) {
            System.out.println(++nthArray + "th Permutation : " + Arrays.toString(select));
            return;
        }

        for(int i=0; i<list.length; i++) {
            if (!visit[i]) {
                visit[i] = true;
                select[cnt] = list[i];
                permutation(cnt+1);
                visit[i] = false;
            }
        }
    }

    static void combination(int idx, int cnt) {
        if (cnt == numAmount) {
            System.out.println(++nthArray + "th Combination : " + Arrays.toString(select));
            return;
        }

        for(int i=idx; i<list.length; i++) {
            select[cnt] = list[i];
            combination(i+1, cnt+1);
        }
    }

    static void subset(int cnt) {
        if (cnt == visit.length) {
            ArrayList<Integer> subset = new ArrayList<>();

            for(int i=0; i<visit.length; i++) {
                if (visit[i]) {
                    subset.add(list[i]);
                }
            }

            System.out.println(subset);
            return;
        }

        visit[cnt] = true;
        subset(cnt+1);

        visit[cnt] = false;
        subset(cnt+1);

    }

    static void duplePermutation(int cnt) {
        if (cnt == numAmount) {
            System.out.println(++nthArray + "th Permutation : " + Arrays.toString(select));
            return;
        }

        for(int i=0; i<list.length; i++) {
            select[cnt] = list[i];
            duplePermutation(cnt+1);
        }
    }
}