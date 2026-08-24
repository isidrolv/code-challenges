import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] instructions = new int[]{1, 5, 6, 2};
//        int length = solution.createSortedArray(instructions);
//        System.out.println("Length of longest substring without repeating characters: " + length);

        //int[] nums = new int[]{1,2,3,4,5,6,7};
        int[] nums = new int[]{1,2,14,15};
        int[] result = solution.resultArray(nums);
        System.out.println("Result array: " + Arrays.toString(result));
    }

    public int createSortedArray(int[] instructions) {

        int coste = 0;
        int[] nums = new int[instructions.length];
        int topNums = 0;

        for (int i = 0; i < instructions.length; i++) {
            if (nums.length == 0) {
                nums[topNums] = instructions[i];
            } else if (instructions[i] < nums[topNums]) {
                nums[i] = instructions[i];
            }
        }


        return coste;
    }


    public int[] resultArray(int[] nums) {
        List<Integer> arr1 = new ArrayList<>();
        List<Integer> arr2 = new ArrayList<>();
        arr1.add(nums[0]);
        arr2.add(nums[1]);
        for (int i = 2; i < nums.length; i++) {
            if (arr1.getLast() > arr2.getLast()) {
                arr1.add(nums[i]);
            } else {
                arr2.add(nums[i]);
            }
        }

        arr1.addAll(arr2);
        return arr1.stream().mapToInt(Integer::intValue).toArray();
    }

}


