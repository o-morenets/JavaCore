package epam.jat;

class FindSingleNumber {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 1, 3, 3, 0};
        int singleNumber = new FindSingleNumber().singleNumber(nums);
        System.out.println("Single Number: " + singleNumber);
    }

    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }
}
