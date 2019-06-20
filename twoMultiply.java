import java.util.*;

class TwoMultiply {

    public static void main(String[] args) {

        HashSet result = twoMultiply(new int[] { 1, 2, 4, 5 }, 8);
        System.out.println(result);
    }

    public static HashSet twoMultiply(int[] nums, int target) {
        Set set = new HashSet();
        for (int i = 0; i < nums[i]; i++) {
            int complement = target / nums[i];

            if (set.contains(complement)) {
                return new int[] { nums[i], complement };
            }
            set.add(nums[i]);
        }
        return set;
    }
}
