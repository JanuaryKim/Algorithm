package code.section2.combination;

public class C07_balckjack {
    public static void main(String[] args) {
        System.out.println(boringBlackjack(new int[]{1, 2, 3, 4}));
    }

    public static int boringBlackjack(int[] cards) {
        // TODO:
        int result = 0;
        for (int i = 0; i < cards.length; i++) {
            for (int j = i + 1; j < cards.length; j++) {
                for (int z = j + 1; z < cards.length; z++) {
                    int sum = cards[i] + cards[j] + cards[z];
                    if(checkDemical(sum))
                    {
                        result++;
                    }
                }
            }
        }
        return result;
    }

    public static boolean checkDemical(int value) {
        for (int k = 2; k <= value / 2; k++) { //소수 판별
            if(value % k == 0) return false;
        }
        return true;
    }
}
