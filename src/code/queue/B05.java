package code.queue;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class B05 {
    public static void main(String[] args) {
//        int bufferSize = 2;
//        int capacities = 10;
//        int[] documents = new int[]{7, 4, 5, 6};
        int bufferSize = 2;
        int capacities = 7;
        int[] documents = new int[]{7, 4, 5, 6};

        System.out.println(queuePrinter(bufferSize, capacities, documents));
    }

    public static int queuePrinter(int bufferSize, int capacities, int[] documents) {
        // TODO:
        int docIdx = 0; //처리중인 문서의 인덱스
        Queue<Integer> printQueue = new LinkedList<>(); //처리 문서 큐

        int time = 0; //시간 변수

        while (docIdx < documents.length || !printQueue.isEmpty()) { //아직 처리할 문서가 남았거나, 출력 중인 문서가 남은 경우 반복
            time++;
            if (printQueue.size() >= bufferSize) { //출력이 진행되어 출력큐에 끝에 도달한 문서가 존재할 경우
                printQueue.poll();
            }


            if(docIdx < documents.length) //작업큐에 추가할 작업이 있을 경우
            {
                if(printQueue.stream().mapToInt(i->i).sum() + documents[docIdx] <= capacities){ //현재 출력큐에 총 문서 크기 + 추가될 문서의 크기가 출력큐의 용량보다 작을 경우
                    printQueue.offer(documents[docIdx]); //추가될 문서 출력큐에 추가
                    docIdx++; //처리할 문서 인덱스 증가
                    continue; //처리할 문서가 추가 됬을 경우 반복문의 조건으로 이동하여 시간 증가 시키기 위함
                }
            }
            printQueue.offer(0); //처리 문서를 추가하지 못한 경우 임의의 처리(빈처리) 추가

            if(printQueue.stream().mapToInt(i->i).sum() == 0) //출력큐에 진짜 처리할 문서가 존재하지 않을 경우 (해당 조건이 존재하지 않을 경우 무한 루프에 빠짐)
                break;
        }
        return time;
    }
}
