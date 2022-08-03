package code.section2.binarySearchTree;

import java.util.ArrayList;
import java.util.List;

public class C11 {
    public static void main(String[] args) {

        System.out.println(getDirections(new int[][]
                        {
                                {0, 1, 0, 0},
                                {0, 0, 1, 0},
                                {0, 0, 0, 1},
                                {0, 1, 0, 0}
                        },
                0,
                2));
    }
    static int TO = 0;

    public static boolean getDirections(int[][] matrix, int from, int to) {
        // TODO:

        TO = to;
        List<Integer> path = new ArrayList<>();
        path.add(from);
        return recursion(matrix, from, path);
    }

    public static boolean recursion(int[][] matrix, int from, List<Integer> list)
    {
        if(matrix[from][TO] == 1) return true; //현재 정점에서 최종정점까지 간선이 있는지 체크

        for (int i = 0; i < matrix[from].length; i++) {
            if(matrix[from][i] == 1)
            {
                if(!list.contains(i)) {
                    ArrayList<Integer> newList = new ArrayList<>();
                    newList.addAll(list); //깊은 복사
                    if(recursion(matrix, i, newList))
                        return true;
                }
            }
        }

        return false;
    }
}
