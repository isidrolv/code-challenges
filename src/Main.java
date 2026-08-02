import java.util.HashMap;
import java.util.Map;

// Given an array of integers nums and an integer k, return the total number of continuous subarrays whose sum equals k.
// Example:
// Input: nums = [1,1,1], k = 2
// Output: 2   // subarrays [1,1] (indices 0-1) and [1,1] (indices 1-2)

// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        int k = 5;

        System.out.println(subarraySum(arr, k));
    }

    // Prefix-sum trick: if prefixSum[j] - prefixSum[i] == k, then the subarray
    // (i, j] sums to k. Track how many times each prefix sum has occurred so
    // far, so each index j is O(1) to check.
    static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixCounts = new HashMap<>();
        prefixCounts.put(0, 1);

        int sum = 0;
        int count = 0;
        for (int num : nums) {
            sum += num;
            count += prefixCounts.getOrDefault(sum - k, 0);
            prefixCounts.merge(sum, 1, Integer::sum);
            System.out.println("Current sum: " + sum + ", Count of subarrays: " + count);
        }
        return count;
    }
}