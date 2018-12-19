import java.util.*;

public class Permutation {
    public static void main(String[] args) {

        ArrayList<String> r = stringPermutation("abc");
        // should return
        // "abc", "acb",
        // "bac", "bca"
        // "cba", "cab"
        System.out.print(r);

    }

    public static ArrayList<String> stringPermutation(String s) {
        ArrayList<String> results = new ArrayList<String>();
        permutation("", s, results);
        return results;
    }

    private static void permutation(String prefix, String suffix, ArrayList<String> results) {
        if (suffix.length() == 0) {
            results.add(prefix);
            return;
        }

        for (int i = 0; i < suffix.length(); i++) {
            String newPrefix = prefix + suffix.charAt(i);
            String newSuffix = excludeChar(suffix, i);
            permutation(newPrefix, newSuffix, results);
        }
    }

    private static String excludeChar(String s, int i) {
        return s.substring(0, i) + s.substring(i + 1, s.length());
    }

    // dealing with array
    public static List<int[]> listPermutation(int[] list) {
        ArrayList<int[]> results = new ArrayList<int[]>();
        // listpermutation(list, results);
        return results;
    }

}
