import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class JustPractice3 {
    public static void main(String[] args) {
//        int output = movingStuff(new int[]{70, 50, 80, 50}, 100);
//        System.out.println(output); // 3

//        int output = movingStuff(new int[]{60, 80, 120, 90, 130}, 140);
//        System.out.println(output); // 4

        int output = movingStuff(new int[]{60, 73, 80, 87, 103, 109, 119, 123, 128, 129, 136, 146, 153, 168, 182}, 200);
        System.out.println(output); // 11
    }

    public static int movingStuff(int[] stuff, int limit) {

        List<Integer> stuffList = Arrays.stream(stuff).boxed().collect(Collectors.toList());
        Collections.sort(stuffList);
        List<Integer> box = new ArrayList<>();
        int boxCtn = 0;

        while(stuffList.size() != 0)
        {
            box.add(stuffList.get(stuffList.size()-1));
            stuffList.remove(stuffList.size()-1);
            for(int i = stuffList.size()-1; i >= 0 ; --i)
            {
                if(box.get(0) + stuffList.get(i) <= limit)
                {
                    box.add(stuffList.get(i));
                    stuffList.remove(i);
                    break;
                }
            }
            boxCtn++;
            box.clear();
        }
        return boxCtn;
    }
}
//            box.add(stuffList.get(0));
//            stuffList.remove(0);
//
//            if(stuffList.size() == 0 || box.size() >= 2 || box.stream().mapToInt(i->i).sum() + stuffList.get(0) > limit){
//                boxCtn++;
//                box.clear();
//            }
//            if(stuffList.size() == 0) break;