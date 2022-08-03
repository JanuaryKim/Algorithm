package code.section2.queue;

import java.util.*;

public class C04_Box_ReCoding {
    public static void main(String[] args) {
        Integer[] boxes = new Integer[]{5, 1, 4, 6};
        int output = paveBox(boxes);
        System.out.println(output); // 3


        Integer[] boxes2 = new Integer[]{1, 5, 7, 9};
        int output2 = paveBox(boxes2);
        System.out.println(output2); // 1
    }

    public static int paveBox(Integer[] boxes) {
        // TODO:

        //인자를 큐로 변환한 변수 선언
        //최대 처리갯수 변수 선언
        //시간 변수 선언

        //큐안에 존재하는 동안 반복
            //시간 1증가
            //큐안에 첫 데이터 확인하여 시간과 일치하면 무한 반복문 시작
                //큐안에 데이터가 시간과 같거나 작다면
                    //처리갯수 증가
                    //처리큐에서 처리 팝 삭제

                //만약 큐안에 데이터가 없거나, 다음 처리의 값이 현재 시간보다 큰 경우
                    //현재 처리 갯수가 최대 처리 개숫보다 큰 경우 값 스윕
                    //반복문 종료
            //~반복문
        //~반복문 종료

        Queue<Integer> customer = new LinkedList(Arrays.asList(boxes));
        int maxOutCtn = 0;
        int time = 0;

        while (!customer.isEmpty())
        {
            time++;
            if (customer.peek().equals(time))
            {
                int tempOutCtn = 0;
                while (customer.peek() <= time)
                {
                    if ((int) customer.peek() <= time)
                    {
                        tempOutCtn++;
                        customer.poll();
                    }

                    if(customer.isEmpty())  break;
                }
                if(tempOutCtn > maxOutCtn) maxOutCtn = tempOutCtn;
            }
        }
        return  maxOutCtn;
    }
}
