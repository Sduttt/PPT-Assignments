
public class questions {

    //Question 1: Move zeros -
//Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//
//        Note that you must do this in-place without making a copy of the array.
//
//        Example 1:
//        Input: nums = [0,1,0,3,12]
//        Output: [1,3,12,0,0]
//
//        Example 2:
//        Input: nums = [0]
//        Output: [0]
//
//        Constraints:
//        a. 1 <= nums.length <= 10^4
//        b. -2^31 <= nums[i] <= 2^31 - 1
    public int[] moveZero (int[] nums){
        int nzId = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[nzId] = nums[i];
                nzId++;
            }
        }
        while (nzId < nums.length){
            nums[nzId] = 0;
            nzId++;
        }
        return nums;
    }


//    Question 2: Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.
//
//Example 1:
//Input: s = "leetcode"
//Output: 0
//
//Example 2:
//Input: s = "loveleetcode"
//Output: 2
//
//Example 3:
//Input: s = "aabb"
//Output: -1
//
//Constraints:
//a. 1 <= s.length <= 10^5
//b. s consists of only lowercase English letters.

    public int noRepeatChar(String s){
        int[] frequency = new int[26];

        for (char c : s.toCharArray()) {
            frequency[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            if (frequency[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
}
