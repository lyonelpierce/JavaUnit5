import java.util.stream.Collectors;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Set;

class MissingNumber {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 4, 5};
        int maxNumber = 5;

        int missingNumber = findMissingNumber(numbers, maxNumber);
        int missingNumber1 = findMissingNumber1(numbers, maxNumber);
        int missingNumber2 = findMissingNumber2(numbers, maxNumber);

        System.out.println("O(n) runtime, O(n) memory. The missing number is: " + missingNumber);
        System.out.println("O(n log n) runtime, O(1) runspace. The missing number is: " + missingNumber1);
        System.out.println("O(n) runtime, O(1) runspace. The missing number is: " + missingNumber2);
    }

    public static int findMissingNumber(int[] nums, int maxNum) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        for (int num = 1; num <= maxNum; num++) {
            if (!numSet.contains(num)) {
                return num;
            }
        }
        return 0;
    }

    public static int findMissingNumber1(int[] nums, int maxNum) {
        Arrays.sort(nums);
        if (nums[0] != 1) {
            return 1;
        }
        if (nums[nums.length - 1] != maxNum) {
            return maxNum;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                return nums[i - 1] + 1;
            }
        }
        return 0;
    }

    public static int findMissingNumber2(int[] nums, int maxNum) {
        int expectedSum = (maxNum * (maxNum + 1)) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        int missingNum = expectedSum - actualSum;
        if (missingNum > 0 && missingNum <= maxNum) {
            return missingNum;
        }
        return 0;
    }
}