package code.section2.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class C11_Adjacency_Recoding_queue_version {
    public static void main(String[] args) {
//        boolean result = getDirections(new int[][]
//                        {
//                                {0, 1, 0, 0},
//                                {0, 0, 1, 0},
//                                {0, 0, 0, 1},
//                                {0, 1, 0, 0}
//                        },
//                0,
//                2
//        );
//        System.out.println(result); // true

//        boolean result2 = getDirections(new int[][]
//                        {
//                                {0, 1, 0, 0, 0},
//                                {0, 0, 0, 1, 0},
//                                {0, 1, 0, 0, 0},
//                                {0, 1, 1, 0, 0},
//                                {1, 1, 1, 1, 0}
//                        },
//                1,
//                4
//        );
//        System.out.println(result2); // false
        boolean result3 = getDirections(new int[][]
                        {
                                {0, 1, 0, 0, 0},
                                {0, 0, 0, 1, 0},
                                {0, 0, 0, 0, 0},
                                {0, 1, 0, 0, 0},
                                {1, 1, 1, 1, 0}
                        },
                1,
                1
        );
        System.out.println(result3); // false
    }

    private static boolean getDirections(int[][] matrix, int from, int to) {

        //방문 큐 선언
        //방문 체크 배열
        
        //최초 시작 정점 큐에 추가
        
        //방문 예정 큐가 있을 경우 반복
            //큐에서 정점 꺼낸다, 예정인 정점을 실제 둘러볼 준비
            //만약 도착지점이라면
                //리턴 트루

            //정점의 연결 정점 순회 반복문
                //만약 1일 경우(연결된 경우), 그리고 방문 예정 정점이 아닐 경우
                    //방문 큐에 정점 넣기기
                    //방문 체크
            //~반복문 종료
       //~ 반복문 종료
       //리턴 폴스 

        Queue<Integer> visitReservationQueue = new LinkedList<>();
        boolean[] visitReserCheck = new boolean[matrix.length];
        Arrays.fill(visitReserCheck, false);

        visitReservationQueue.add(from);
        visitReserCheck[from] = true;

        while (visitReservationQueue.size() != 0) {
            Integer searchVertex = visitReservationQueue.poll();

            if(searchVertex == to) return true; //선들이 방향성이 있고, 본인에게 돌아오는 사이클( from = 1, to = 1 ) 일때 체크를 위해 여기서 해야함

            for (int j = 0; j < matrix[searchVertex].length; j++) {
                if(matrix[searchVertex][j] == 1 && visitReserCheck[j] == false)
                {
//                    if(to == j) return true; //여기에서 도착 정점인지 체크하면, 인자 from, to가 같은 경우 return true를 하지 못한다. 왜냐면 최초에 그냥 방문한걸로 체크를 하기 때문에
                    visitReservationQueue.add(j);
                    visitReserCheck[j] = true;
                }
            }
        }

        return false;
    }
}
