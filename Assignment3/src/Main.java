import java.util.*;

class questions{

//Q1. Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to the target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
    public int q1(int[] nums, int target){
        Arrays.sort(nums);
        int closest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length-2; i ++) {
            int left = i+1;
            int right = nums.length-1;
            while (left < right){
                int current = nums[i] + nums[left] + nums[right];
                if(Math.abs(current-target) < Math.abs(closest-target)){
                    closest = current;
                }
                if(current < target){
                    left++;
                } else if (current > target){
                    right --;
                } else return current;
            }
        }
        return closest;
    }

//Q2. Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
//           ● 0 <= a, b, c, d < n
//           ● a, b, c, and d are distinct.
//           ● nums[a] + nums[b] + nums[c] + nums[d] == target
//You may return the answer in any order.

    public List<List<Integer>> q2(int[] nums, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }

                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return quadruplets;
    }

//Q4. Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//You must write an algorithm with O(log n) runtime complexity.

    public int q4(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(right >= left){
            int mid = left + (right - left)/2;
            if(target == nums[mid]){
                return mid;
            }
            if(target > nums[mid]){
                left = mid+1;
            }
            if (target < nums[mid]){
                right = mid - 1;
            }
        }
        return left;
    }

//   Q5. You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significantto least significant in left-to-right order. The large integer does not contain any leading 0's.
// Increment the large integer by one and return the resulting array of digits.

    public int [] q4(int[] digits){
        int n = digits.length - 1;
        int carry = 1;

        for (int i = n; i >= 0; i--) {
            int sum = digits[i] + carry;

            if(sum <= 9){
                digits[i] = sum;
                return digits;
            } else{
                digits[i] = 0;
            }
        }

        int[] result = new int[n+2];
        result[0] = carry;
        return result;
    }

//  Q6.  Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//You must implement a solution with a linear runtime complexity and use only constant extra space.

    public int q6(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

//  Q7.  You are given an inclusive range [lower, upper] and a sorted unique integer array nums, where all elements are within the inclusive range.
//    A number x is considered missing if x is in the range [lower, upper] and x is not in nums.
//    Return the shortest sorted list of ranges that exactly covers all the missing numbers. That is, no element of nums is included in any of the ranges, and each missing number is covered by one of the ranges.

    public List<String> q7(int[] nums, int lower, int upper) {
        List<String> result = new ArrayList<>();
        int n = nums.length;

        if(nums[0] > lower){
            result.add(getRange(lower, nums[0] - 1));
        }

        for (int i = 0; i < n - 1; i++) {
            if(nums[i] + 1 < nums[i+1]){
                result.add(getRange(nums[i] + 1, nums[i+1] - 1));
            }
        }

        if(nums[n-1] < upper){
            result.add(getRange(nums[n-1] + 1, upper));
        }

        return result;
    }

    private String getRange(int lower, int upper){
        return lower == upper ? String.valueOf(lower) : (lower + "->" + upper);
    }


//Q8. Given an array of meeting time intervals where intervals[i] = [starti, endi], determine if a person could attend all meetings.

    public boolean q8(int[][] nums){
        Arrays.sort(nums, (a, b) -> a[0] - b[0]);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i][1] >= nums[i+1][0]) {
                return false;
            }
        }
        return true;
    }

}




public class Main {
    public static void main(String[] args) {
        questions obj = new questions();

//        todo: Uncomment the particular solution from below to run that problem.

//        q1 solution
//        int[] nums = {-1,2,1,-4};
//        int target = 1;
//        int result = obj.q1(nums, target);
//        System.out.println(result);


//        q2 solution
//        int[] nums = {1,0,-1,0,-2,2};
//        int target = 0;
//        List<List<Integer>> quadruplets = obj.q2(nums, target);
//
//        for (List<Integer> quadruplet : quadruplets) {
//            System.out.println(quadruplet);
//        }

//
//        q4 solution
//        int[] nums = {1,3,5,6};
//        int n = 4;
//        int result = obj.q4(nums, n);
//        System.out.println(result);
//


//        q5 solution
//        int[] digits = {8, 9, 9};
//        int[] result = obj.q4(digits);
//        System.out.print("Result: " + Arrays.toString(result));


//        q6 solution
//        int[] nums = {1, 2, 1, 3, 2};
//        int res = obj.q6(nums);
//        System.out.println(res);


//        q7 solution
//        int[] nums = {0, 1, 3, 50, 75};
//        int lower = 0;
//        int upper = 99;
//        List<String> result = obj.q7(nums, lower, upper);
//        System.out.println(result);

//        q8 solution
//        int[][] nums = {{0,30},{5,10},{15,20}};
//        boolean result = obj.q8(nums);
//        System.out.println(result);



    }
}