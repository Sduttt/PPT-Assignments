import java.util.Arrays;

class questions{

//Q1. Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2),..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.

    public int q1(int[] nums){
        Arrays.sort(nums);
        int maxSum = 0;

        for (int i = 0; i < nums.length; i +=2) {
            maxSum += nums[i];
        }
        return maxSum;
    }

//    Q2. Alice has n candies, where the ith candy is of type candyType[i]. Alice noticed that she started to gain weight, so she visited a doctor.
//The doctor advised Alice to only eat n / 2 of the candies she has (n is always even). Alice likes her candies very much, and she wants to eat the maximum number of different types of candies while still following the doctor's advice.
//Given the integer array candyType of length n, return the maximum number of different types of candies she can eat if she only eats n / 2 of them.

    public int q2(int[] nums){
        Arrays.sort(nums);
        int uniq = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]){
                uniq++;
            }
        }
        int half = (nums.length+1)/2;
        if(uniq < half){
            return uniq;
        } else return half;
    }

//    Q3. We define a harmonious array as an array where the difference between its maximum valueand its minimum value is exactly 1.
//Given an integer array nums, return the length of its longest harmonious subsequenceamong all its possible subsequences.
//A subsequence of an array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.

    public int q3(int[] nums){
        Arrays.sort(nums);
        int maxlength = 0;
        int i = 0;
        int j = 0;

        for(j=0; j<nums.length; j++){
            while(nums[j] - nums[i] >1){
                i++;
            }
            if(nums[j] - nums[i] <= 1){
                maxlength = Math.max(maxlength, j-i+1);
            }
        }

        return maxlength;
    }

//    Q4. You have a long flowerbed in which some of the plots are planted, and some are not.
//However, flowers cannot be planted in adjacent plots.
//Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

    public boolean q4(int[] flowerbed, int n){
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 1) continue;
            else if((i == 0 || flowerbed[i-1] == 0) && (i == flowerbed.length-1 || flowerbed[i+1] == 0)){
                flowerbed[i] = 1;
                count++;
            }
        }
        return count >= n;
    }

//  Q5. Given an integer array nums, find three numbers whose product is maximum and return the maximum product.
    public int q5(int[] nums){
        Arrays.sort(nums);
        int len = nums.length;
        int output = nums[len-1] * nums[len-2] * nums[len-3];
        return output;
    }

//    Q6. Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
//You must write an algorithm with O(log n) runtime complexity.

    public int q6(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = left + (right-left)/2;

            if(nums[mid] == target) return mid;
            else if(nums[mid] > target){
                right = mid-1;
            } else left = mid+1;
        }
        return -1;
    }

//    Q7. An array is monotonic if it is either monotone increasing or monotone decreasing.
//An array nums is monotone increasing if for all i <= j, nums[i] <= nums[j]. An array nums is monotone decreasing if for all i <= j, nums[i] >= nums[j].
//Given an integer array nums, return true if the given array is monotonic, or false otherwise.

    public boolean q7(int[] nums){
        boolean increasing = true;
        boolean decreasing = true;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]){
                decreasing = false;
            } else if (nums[i] < nums[i-1]) {
                increasing = false;
            }
        }
        return increasing || decreasing;
    }

//    Q8. You are given an integer array nums and an integer k.
//    In one operation, you can choose any index i where 0 <= i < nums.length and change nums[i] to nums[i] + x where x is an integer from the range [-k, k]. You can apply this operation at most once for each index i.
//    The score of nums is the difference between the maximum and minimum elements in nums.
//    Return the minimum score of nums after applying the mentioned operation at most once for each index in it.

    public int q8(int[] nums, int k){
        int minNum = Integer.MAX_VALUE;
        int maxNum = Integer.MIN_VALUE;

        for (int num : nums) {
            minNum = Math.min(minNum, num);
            maxNum = Math.max(maxNum, num);
        }

        if (maxNum - minNum <= 2 * k) {
            return maxNum - minNum;
        }

        for (int num : nums) {
            minNum = Math.min(minNum, num + k);
            maxNum = Math.max(maxNum, num - k);
        }

        return maxNum - minNum;
    }
}




public class Main {
    public static void main(String[] args) {
        questions obj = new questions();

//        todo: Uncomment the particular solution from below to run that problem.

//        q1 solution
//        int[] nums = {1,4,3,2};
//        int result = obj.q1(nums);
//        System.out.println(result);


//        q2 solution
//        int[] nums = {3,3,3,3,3,3};
//        int result = obj.q2(nums);
//        System.out.println("Maximum number of different types of candies she can eat is " + result);


//        q3 solution
//        int[] nums = {1,3,2,2,2,5,2,3,7};
//        int result = obj.q3(nums);
//        System.out.println(result);

//        q4 solution
//        int[] flowerbed = {1,0,0,0,1};
//        int n = 2;
//        boolean result = obj.q4(flowerbed, n);
//        System.out.println(result);


//        q5 solution
//        int[] nums = {5,1,2,3,4};
//        int result = obj.q5(nums);
//        System.out.println(result);


//        q6 solution
//        int[] nums = {-1,0,3,5,9,12};
//        int target = 9;
//
//        int result = obj.q6(nums, target);
//        System.out.println(result);


//        q7 solution
//        int[] nums = {3,4,2,3};
//        boolean result = obj.q7(nums);
//        System.out.println(result);

//        q8 solution
//        int[] nums = {1};
//        int k = 0;
//        int result = obj.q8(nums, k);
//        System.out.println(result);


    }
}