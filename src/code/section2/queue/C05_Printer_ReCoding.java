package code.section2.queue;

import java.util.LinkedList;
import java.util.Queue;

public class C05_Printer_ReCoding {
    public static void main(String[] args) {
//        int bufferSize = 2;
//        int capacities = 10;
//        int[] documents = new int[]{7, 4, 5, 6};
//
//        int output = queuePrinter(bufferSize, capacities, documents);
//        System.out.println(output);// 8

//        int bufferSize = 2;
//        int capacities = 10;
//        int[] documents = new int[]{1, 4, 5, 6};
//
//        int output = queuePrinter(bufferSize, capacities, documents);
//        System.out.println(output);// 8

        int bufferSize = 2;
        int capacities = 100;
        int[] documents = new int[]{1, 4, 5, 6};

        int output = queuePrinter(bufferSize, capacities, documents);
        System.out.println(output);// 8
    }

    private static int queuePrinter(int bufferSize, int capacities, int[] documents) {
        //규칙 : 프린트와, 작업추가, 작업목록 1칸 이동이 1초에 일어날 수 있는 행위들

        //시간 변수
        //프린터 작업 목록 큐

        //처리해야할 문서가 남아있거나 || 작업 목록큐의 합이 0이 아닐때 동안 반복문
            //시간 1 증가
            //만약 작업큐의 사이즈가 2라면
                // 선입선출한다

            //만약 처리해야할 문서가 존재하다면
                //만약 작업 목록의 합 + 다음 문서용량이 capa를 넘지 않을때
                    //작업 목록큐에 문서를 넣는다.
                    //작업 문서 인덱스 증가
                //넘는다면
                    //임의의 작업 0을 넣음
            //없다면
                //임의의 작업 0을 넣음
        //~반복문 종료
        int time = 0;
        int curDocIdx = 0;
        Queue<Integer> printWaitQueue = new LinkedList<>();

        while (curDocIdx < documents.length || printWaitQueue.stream().mapToInt(i -> i).sum() != 0) {
            time++;
            if (printWaitQueue.size() >= bufferSize) {
                printWaitQueue.poll();
            }

            if(curDocIdx < documents.length) //위에서도 동일하게 검사를 하지만, 아직 출력이 되지 않은 문서가 큐에 남아있을 경우에도 반복문을 돌기때문에
            {
                if (printWaitQueue.stream().mapToInt(i -> i).sum() + documents[curDocIdx] <= capacities) {
                    printWaitQueue.add(documents[curDocIdx++]); //curDocIdx < documents.length를 다시 한번 안했을때 현재 코드 에러
                }
                else printWaitQueue.add(0);//위에 if문에서 continue 해버리면 중복되는 해당 코드를 하나로 줄일 수 있다
            }
            else printWaitQueue.add(0);
        }

        return time;
    }
}
