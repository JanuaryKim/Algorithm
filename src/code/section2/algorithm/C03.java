package code.section2.algorithm;

public class C03 {
    public static void main(String[] args) {
        int[][] board1 = new int[][]{
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 0},
                {0, 0, 0, 0}
        };

        int output1 = boardGame(board1, "RRDLLD");
        System.out.println(output1); // 4
    }

    public static Integer boardGame(int[][] board, String operation) {
        // TODO:
        int point = 0;
        int x = 0;
        int y = 0;
        int operIdx = 0;

        while(operIdx < operation.length())
        {
            char operChar = operation.charAt(operIdx);
            if(operChar == 'U')
                y -= 1;
            else if(operChar == 'D')
                y += 1;
            else if(operChar == 'L')
                x -= 1;
            else if(operChar == 'R')
                x += 1;

            if(x < 0 || x >= board[0].length || y < 0 || y >= board.length)
            {
                return null;
            }

            operIdx++;

            point += board[y][x];
        }

        return point;
    }
}
