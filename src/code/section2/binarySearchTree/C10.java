package code.section2.binarySearchTree;

import java.util.Arrays;

public class C10 {

    public static void main(String[] args) {
        int[][] result = createMatrix(new int[][]{
                {0, 2, 0},
                {2, 4, 1},
                {1, 3, 1},
                {2, 1, 0},
        });

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }

    }

    public static int[][] createMatrix(int[][] edges) { //1차원 배열은 간선의 정보, 2차원 배열은 간선의 갯수
        // TODO:

        int vertextCtn = 0;
        for(int i = 0; i < edges.length; i++) //정점 갯수 구하기
        {
            int[] subArr = Arrays.copyOfRange(edges[i], 0, edges[i].length -1);
            int tempVertextCtn = (int)(Arrays.stream(subArr).max().getAsInt());
            if(tempVertextCtn > vertextCtn) vertextCtn = tempVertextCtn;
        }

        int[][] result = new int[vertextCtn + 1][vertextCtn + 1];

        for(int i = 0; i < edges.length; i++)
        {
            int startVer = edges[i][0];
            int endVer = edges[i][1];
            result[startVer][endVer] = 1;

            if(edges[i][2] == 1) // 양방향
            {
                result[endVer][startVer] = 1;
            }
        }

        return result;
    }
}
