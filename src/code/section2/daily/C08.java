package code.section2.daily;

public class C08 {
    public static void main(String[] args) {
        String output = convertDoubleSpaceToSingle("string  with  double  spaces");
        System.out.println(output); // --> "string with double spaces"
    }

    public static String convertDoubleSpaceToSingle(String str) {
        // TODO:

        return str.replace("  ", " ");
    }
}
