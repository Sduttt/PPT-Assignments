import java.util.Arrays;

class questions{

//💡 Q1. Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//You may assume that each input would have exactly one solution, and you may not use the same element twice.
//You can return the answer in any order.
     public int[] q1(int[] nums, int target){
        int[] solution = new int[2];

        for(int i=0; i<nums.length-1; i++){
            for (int j=i+1; j<nums.length; j++){
                if(nums[i]+nums[j] == target){
                    solution[0] = i;
                    solution[1] = j;
                    break;
                }
            }
        }
        return solution;
    }


//💡 Q2. Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
//Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
//- Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
//- Return k.

    public int q2(int[] nums, int val){
         int i = 0;
         int k = 0;
         while (i < nums.length){
             if(nums[i] != val){
                 nums[k] = nums[i];
                 k++;
             }
             i++;
         }
        System.out.println("Result array is: " + Arrays.toString(nums));
         return k;
    }


//    Q3. Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
//        You must write an algorithm with O(log n) runtime complexity.

    public int q3(int[] nums, int target){
         int left = 0;
         int right = nums.length - 1;
         while (left <= right) {
             int mid = left + (right-left) / 2;
            if(nums[mid] == target){
                return mid;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else if (nums[mid] < target) {
                left = mid+1;
            }
         }
         return left;
    }

// Q4. You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
//Increment the large integer by one and return the resulting array of digits.

    public int [] q4(int[] digits){
         int n = digits.length - 1;
         int carry = 1;

        for (int i = n; i >= 0; i--) {
            int sum = digits[i] + carry;

            if(sum < 9){
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

//    Q5. You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
//Merge nums1 and nums2 into a single array sorted in non-decreasing order.
//The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.

    public void  q5(int[] nums1, int[] nums2, int m, int n){
        int p1 = m-1;
        int p2 = n-1;

        while (p1 >= 0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[p1+p2+1] = nums1[p1];
                p1--;
            } else{
                nums1[p1+p2+1] = nums2[p2];
                p2--;
            }
        }

    }


//    Q6. Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

    public boolean q6 (int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            for(int j=i+1; j< nums.length; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

//    Q7.💡 Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the nonzero elements.
//    Note that you must do this in-place without making a copy of the array.

    public void q7(int nums[]){
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[right];
                nums[right] = nums[left];
                nums[left] = temp;

                left++;
            }
        }

        while (left < nums.length) {
            nums[left] = 0;
            left++;
        }

        System.out.println(Arrays.toString(nums));
    }


//    Q8. You have a set of integers s, which originally contains all the numbers from 1 to n. Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set, which results in repetition of one number and loss of another number.
//    You are given an integer array nums representing the data status of this set after the error.
//    Find the number that occurs twice and the number that is missing and return them in the form of an array.

    public void q8(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            if(nums[i] == nums[i+1]){
                nums[i+1] = nums[i]+1;
            }
        }
        System.out.println(Arrays.toString(nums));
    }


}




public class Main {
    public static void main(String[] args) {
        questions obj = new questions();

//        todo: Uncomment the particular solution from below to run that problem.

//        q1 solution

//        int[] nums = {3,3};
//        int target = 6;
//        int[] result = obj.q1(nums, target);
//        System.out.println("Indices: " + result[0] + " and " + result[1]);


//        q2 solution

//        int[] nums = {2,3,9,5,3,5,3};
//        int val = 5;
//        int result = obj.q2(nums, val);
//        System.out.println("Value of K: " + result);


//        q3 solution

//        int[] nums = {2,3,9,15,23,35,43};
//        int target = 6;
//
//        int result = obj.q3(nums, target);
//        System.out.println("Index is: " + result);


//      q4 solution

//        int[] digits = {9, 9, 9};
//        int[] result = obj.q4(digits);
//        System.out.print("Result: " + Arrays.toString(result));

//     q5 solution

//        int[] nums1 = {1, 2, 3, 0, 0, 0}; // Example input array 1
//        int[] nums2 = {2, 5, 6}; // Example input array 2
//        int m = 3; // Number of elements in nums1
//        int n = 3; // Number of elements in nums2
//
//        obj.q5(nums1, nums2, m, n);
//        System.out.println("Merged array: " + Arrays.toString(nums1));

//        q6 solution

//        int[] nums = {1, 2, 3, 4};
//        boolean result = obj.q6(nums);
//        System.out.println(result);

//        q7 solution

//        int[] nums ={0,1,0,3,12};
//        obj.q7(nums);

//        q8 solution

//        int[] nums = {1,2,3,4,4};
//        obj.q8(nums);


    }
}