class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] instructions = new int[] {1, 5, 6, 2};
        int length = solution.createSortedArray(instructions);
        System.out.println("Length of longest substring without repeating characters: " + length);
    }

    public int createSortedArray(int[] instructions) {

        int coste = 0;
        int[] nums = new int[instructions.length];
        int topNums = 0;

        for(int i=0; i<instructions.length; i++) {
            if (nums.length == 0) {
                nums[topNums] = instructions[i];
            } else if (instructions[i] < nums[topNums]) {
                nums[i] = instructions[i];
            }            
        }




        return coste;
    }

}


