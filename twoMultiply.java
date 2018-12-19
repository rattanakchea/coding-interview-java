import java.util.*;

public class TwoMultiply {
    public static int[] twoMultiply(int[] nums, int target) {
        Set set = new HashSet();
        for (int i = 0; i < nums[i]; i++) {
            int complement = target / nums[i];

            if (set.contains(complement)) {
                return new int[] { nums[i], complement };
            }
            set.add(nums[i]);
        }
        return new int[] {};
    }
}
