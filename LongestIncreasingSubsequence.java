package Main;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {10, 22, 9, 33, 21, 50, 41, 60, 80};

        // Find the length of the LIS
        int lisLength = findLISLength(nums);
        System.out.println("Length of Longest Increasing Subsequence: " + lisLength);

        // Find and print the actual LIS
        int[] lis = findLIS(nums);
        System.out.println("Longest Increasing Subsequence: " + Arrays.toString(lis));
    }

    private static int findLISLength(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        // Initialize the dp array with 1 as the minimum LIS length for each element
        Arrays.fill(dp, 1);

        // Dynamic Programming to find the LIS length
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        // Find the maximum value in the dp array, which represents the LIS length
        return Arrays.stream(dp).max().orElse(0);
    }

    private static int[] findLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        // Initialize the dp array with 1 as the minimum LIS length for each element
        Arrays.fill(dp, 1);

        // Dynamic Programming to find the LIS length
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        // Find the maximum value in the dp array, which represents the LIS length
        int lisLength = Arrays.stream(dp).max().orElse(0);

        // Build the actual LIS using the dp array
        int[] lis = new int[lisLength];
        int currentIndex = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == lisLength && (currentIndex == n - 1 || nums[i] < lis[currentIndex + 1])) {
                lis[currentIndex--] = nums[i];
                lisLength--;
            }
        }

        return lis;
    }
}

