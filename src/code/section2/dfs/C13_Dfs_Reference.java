package code.section2.dfs;

public class C13_Dfs_Reference {
    public static void main(String[] args) {
        System.out.println(barcode(8));
    }

    private static String barcode(int leng) {
        return aux("", leng);
    }

    public static boolean isValid(String str)
    {
        StringBuffer sB = new StringBuffer(str);
        String reverse = sB.reverse().toString();

        int halfLeng = str.length()/2;

        System.out.println("original : " + str);
        System.out.println("reverse : " + reverse);

        for (int i = 1; i <= halfLeng; i++) {

            String subStr1 = reverse.substring(0, i);
            String subStr2 = reverse.substring(i, i+i);
            System.out.printf("(%d ~ %d) %s 이랑 (%d ~ %d) %s 가 같냐?", 0, i, subStr1, i, i+i, subStr2);
            System.out.println();
            if (subStr1.equals(subStr2)) {
                return false;
            }
        }
        return true;
    }

    public static String aux(String s, int leng) {
        String chr = "123";

        if(s.length() == leng) return s;

        for (int i = 0; i < chr.length(); i++) {
            String curStr = s + chr.charAt(i);
            if (isValid(curStr)) {

                String founded = aux(curStr, leng);
                if(founded != null) return founded;
            }

        }

        return null;
    }
}
