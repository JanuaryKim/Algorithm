package code.section2.powerSet;

import java.util.ArrayList;
import java.util.Arrays;

public class C09_sideDishes_sub {

    public static void main(String[] args) {
        ArrayList<String[]> output = missHouseMeal(new String[]{"eggroll", "kimchi", "fishSoup"});

        for (String[] dishes : output) {
            System.out.println(Arrays.toString(dishes));
        }
    }
    public static ArrayList<String[]> missHouseMeal(String[] sideDishes) {
        // TODO:
        Arrays.sort(sideDishes);
        ArrayList<String[]> result = new ArrayList<>();
        result.add(new String[0]);
        result.add(sideDishes);

        int combiCtn = sideDishes.length - 1;
        int firstIdx = 0;

        while(combiCtn != 0)
        {
            String[] curDishes = new String[combiCtn];
            curDishes[0] = sideDishes[firstIdx];


        }
        return result;
    }

    private static void recursion(ArrayList<String[]> list, String[] curDishes, String[] sideDishes, int combiCtn, int curDishesIdx)
    {

    }

}
