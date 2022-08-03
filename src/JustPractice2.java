import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class JustPractice2 {
    public static void main(String[] args) {
//        String[][] strings = new String[][]{{new String()}};
//        System.out.println(convertListToHashMap(strings));


        int[] ss = new int[]{1,2};

        List<Integer> ssl = Arrays.stream(ss).boxed().collect(Collectors.toList());
        Collections.sort(ssl);

        String[][] strings = new String[][]{{"a","1"},{"b","2"}};
        System.out.println(convertListToHashMap(strings));

        String str = "   ";
        Stream<Character> characterStream = str.chars() //배열을
                .mapToObj(c -> (char) c);

    }

    public static HashMap<String, String> convertListToHashMap(String[][] arr) {
        // TODO:

        HashMap<String, String> result = new LinkedHashMap<>();

        Stream<String[]> arr1 = Stream.of(arr);
        arr1.filter(sArr-> sArr.length != 0).filter(sArr-> !result.containsKey(sArr[0])).forEach(sArr-> result.put(sArr[0],sArr[1]));

        return result;

    }
}
