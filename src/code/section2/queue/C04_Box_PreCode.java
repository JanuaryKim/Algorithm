package code.section2.queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class C04_Box_PreCode {

    public static void main(String[] args) {
            System.out.println(paveBox(new Integer[]{5, 1, 4, 6}));
    }

    public static int paveBox(Integer[] boxes) {
        // TODO:
        int time = 0;
        int maxPopCtn = 0;

        Queue<Integer> queue = new LinkedList<>(Arrays.asList(boxes));
        while (!queue.isEmpty()) { //박스 처리가 남아 있는 동안 반복
            time++; //한 사이클당 시간 증가

            int tempCtn = 0; //처리 가능시 처리 갯수
            while(queue.peek() <= time) //첫 사람의 박스 처리 시간이 충족 됬을 경우 반복문 진입
            {
                tempCtn++;
                queue.poll();

                if(queue.isEmpty()) //박스 처리 후 대기인원이 더 이상 남지 않았을 경우 반복문 탈출
                    break;
            }
            if(tempCtn > maxPopCtn) maxPopCtn = tempCtn; //이번에 처리 갯수가 최대 처리 갯수보다 클 경우 횟수 저장
        }
        return maxPopCtn;
    }
}
