package code.section2.binarySearchTree;

import java.util.*;

public class C12 {
    public static void main(String[] args) {
//        TreeSet<Integer> treeSet = new TreeSet<>();
//        treeSet.add(2);
//        treeSet.add(3);
//        treeSet.add(5);
//
//        treeSet.stream().forEach(System.out::println);
//
//        System.out.println("=".repeat(20));
//        TreeSet<Integer> treeSet2 = new TreeSet<>();
//        treeSet2.add(5);
//        treeSet2.add(3);
//        treeSet2.add(2);
//
//        treeSet2.stream().forEach(System.out::println);
//
//        System.out.println(treeSet.equals(treeSet2));

//        int result = connectedVertices(new int[][]{
//                {0, 1},
//                {0, 2},
//                {0, 3},
//                {0, 4},
//        });

//        int result = connectedVertices(new int[][]{
//                {0, 1},
//                {6, 5},
//                {5, 4},
//                {4, 3},
//                {3, 2},
//                {2, 1}
//        });

        int result = connectedVertices(new int[][]{ //문제의 테스트케이스
                {1, 2},
                {2, 3},
                {5, 4},
                {4, 3},
                {3, 2},
                {2, 1}
        });
        System.out.println(result); // 2
    }

    public static int connectedVertices(int[][] edges) {
        // TODO:
        List<Set<Integer>> groupList = new ArrayList();

        for(int i = 0; i < edges.length; i++) //간선 하나를 시작으로 잡아고 반복문
        {
            Set<Integer> tempGroup = new TreeSet<>();
            tempGroup.add(edges[i][0]);
            tempGroup.add(edges[i][1]);


            List<Integer[]> tempList = new ArrayList<>(); //시작 간선 제외하고 나머지 간선을 리스트에 넣음
            for (int j = 0; j < edges.length; j++) { //edges를 list화, 추가한 간선은 삭제하기 위해
                if(j == i) continue; //문제구간1, 시작 간선 제외, 문제구간 2를 활성화 시키고 해당 구간이 주석이면 현재 테스트케이스에서 결과값 잘못나옴
                tempList.add(Arrays.stream(edges[j]).boxed().toArray(Integer[]::new));
            }

            int index = 0;
            while(index < tempList.size() && tempList.size() != 0) //사이클일 경우 모든 간선이 삭제 됬읅것이기 때문에 그 경우에는 반복문 탈출
            {
//                if(index == i) { //문제구간2
//                    index++;
//                    continue;
//                }

                if(tempGroup.contains(tempList.get(index)[0]) || tempGroup.contains(tempList.get(index)[1])) //둘중 하나라도 존재하면 연결된 정점
                {
                    tempGroup.add(tempList.get(index)[0]); //set은 중복 저장안하므로 두개 다 add 해도 상관없음음
                    tempGroup.add(tempList.get(index)[1]);
                    tempList.remove(index); //해당 간선은 이미 그룹으로 포함 됬기때문에 제거, 제거 하지 않으면 무한 루프되므로 제거해야함
                    index = 0;
                    continue;
                }
                index++;
            }

            //존재 하는 그룹과 동일한지 체크
            boolean containGrpCheck = false;
            for (int j = 0; j < groupList.size(); j++) { //저장된 그룹들 중 지금 찾은 그룹과 동일한 그룹이 존재하다면 그룹리스트에 추가 하지 않음
                if(groupList.get(j).equals(tempGroup))
                {
                    containGrpCheck = true;
                    break;
                }
            }

            if(!containGrpCheck) groupList.add(tempGroup);
        }

        return groupList.size();
    }
}
