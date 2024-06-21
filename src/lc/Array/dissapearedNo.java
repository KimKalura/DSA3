package lc.Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class dissapearedNo {

    //Find All Numbers Disappeared in an Array:
    //Given an array nums of n integers where nums[i] is in the range [1, n], return an array of all the integers
    // in the range [1, n] that do not appear in nums.

    //Input: nums = [4,3,2,7,8,2,3,1]
    //Output: [5,6]

    //Input: nums = [1,1]
    //Output: [2]

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> findMissingNumbers1 = findMissingNumbers1(nums);
        System.out.println(findMissingNumbers1);  // Output: [5, 6]
    }


    //adaugam toate nr intr-un set
    //parcurgem array-ul nums si verificam daca setul contine numerele de la 1..n; nr lipsa le stocam in lista
    public static List<Integer> findMissingNumbers1(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            numSet.add(num);
        }

        for (int i = 1; i <= nums.length; i++) {
            if (!numSet.contains(i)) {
                result.add(i);
            }
        }

        return result;
    }


    public static List<Integer> findMissingNumbers2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        // Mark numbers as visited by negating the corresponding index value
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Collect the indices that are still positive
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }

        return result;
    }


}
