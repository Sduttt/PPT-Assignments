import java.util.*;

class questions{

//Q1. Given three integer arrays arr1, arr2 and arr3 sorted in strictly increasing order, return a sorted array of only the integers that appeared in all three arrays.


//    Q2. Given two **0-indexed** integer arrays nums1 and nums2, return *a list* answer *of size* 2 *where:*
//- answer[0] *is a list of all **distinct** integers in* nums1 *which are **not** present in* nums2*.*
//- answer[1] *is a list of all **distinct** integers in* nums2 *which are **not** present in* nums1.
//**Note** that the integers in the lists may be returned in **any** order. Don't use hashmap.

    public List<List<Integer>> q2(int[] nums1, int[] nums2){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> distinctNums1 = new ArrayList<>();
        List<Integer> distinctNums2 = new ArrayList<>();

        for (int i = 0, j = 0; i < nums1.length || j < nums2.length; ) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    distinctNums1.add(nums1[i]);
                    i++;
                } else if (nums2[j] < nums1[i]) {
                    distinctNums2.add(nums2[j]);
                    j++;
                } else {
                    i++;
                    j++;
                }
            } else if (i < nums1.length) {
                distinctNums1.add(nums1[i]);
                i++;
            } else if (j < nums2.length) {
                distinctNums2.add(nums2[j]);
                j++;
            }
        }

        result.add(distinctNums1);
        result.add(distinctNums2);

        return result;
    }


//    Q3. Given a 2D integer array matrix, return the transpose of matrix.
    public int[][] q3(int[][] matrix){
        int m = matrix.length;;
        int n = matrix[0].length;

        int[][] output = new int[n][m];

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++){
                output[i][j] = matrix[j][i];
            }
        }
        return output;
    }

//   Q4. Given an integer array nums of 2n integers, group these integers into n pairs (a1, b1), (a2, b2), ..., (an, bn) such that the sum of min(ai, bi) for all i is maximized. Return the maximized sum.

    public int q4(int[] nums){
        Arrays.sort(nums);
        int sum = 0;
        for(int i = 0; i < nums.length; i+=2){
            sum += nums[i];
        }
        return sum;
    }

//    Q5. You have n coins and you want to build a staircase with these coins. The staircase consists of k rows where the ith row has exactly i coins. The last row of the staircase **may be** incomplete. Given the integer n, return *the number of **complete rows** of the staircase you will build*.

    public int q5(int n){
        int count = 0;
        int i = 1;
        while(n >= i){
            n -= i;
            count++;
            i++;
        }
        return count;
    }

// Q6. Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

    public int[] q6(int[] nums){
        int[] result = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[i] * nums[i];
        }
        Arrays.sort(result);
        return result;
    }

//    Q7. You are given an m x n matrix M initialized with all 0's and an array of operations ops, where ops[i] = [ai, bi] means M[x][y] should be incremented by one for all 0 <= x < ai and 0 <= y < bi.
//Count and return *the number of maximum integers in the matrix after performing all the operations*

    public int q7(int m, int n, int[][] ops){
        int minA = m;
        int minB = n;

        for (int[] op : ops) {
            minA = Math.min(minA, op[0]);
            minB = Math.min(minB, op[1]);
        }

        return minA * minB;
    }

//    Q8. Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].*Return the array in the form* [x1,y1,x2,y2,...,xn,yn].

    public int[] q8(int[] nums, int n){
        int[] result = new int[2 * n];
        int index = 0;

        for (int i = 0; i < n; i++) {
            result[index++] = nums[i];
            result[index++] = nums[n + i];
        }

        return result;
    }
}




public class Main {
    public static void main(String[] args) {
        questions obj = new questions();

//        todo: Uncomment the particular solution from below to run that problem.

//        q1 solution


//        q2 solution
//        int[] nums1 = {1, 2, 3};
//        int[] nums2 = {2, 4, 6};
//
//        List<List<Integer>> distinctIntegers = obj.q2(nums1, nums2);
//
//        System.out.println("Distinct integers in nums1 not present in nums2: " + distinctIntegers.get(0));
//        System.out.println("Distinct integers in nums2 not present in nums1: " + distinctIntegers.get(1));


//        q3 solution

//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] transpose = obj.q3(matrix);
//        System.out.println("Transpose of matrix: " + Arrays.deepToString(transpose));

//        q4 solution
//        int[] nums = {1,4,3,2};
//        System.out.println("Maximized sum: " + obj.q4(nums));

//        q5 solution
//        int n = 6;
//        System.out.println("Number of complete rows: " + obj.q5(n));

//        q6
//        int[] nums = {-4,-1,0,3,10};
//        int[] result = obj.q6(nums);
//        System.out.println(Arrays.toString(result));

//        q7
//        int m = 3;
//        int n = 3;
//        int[][] ops = {{2,2},{3,3}};
//        System.out.println("Number of maximum integers: " + obj.q7(m, n, ops));

//        q8
//        int[] nums = {2,5,1,3,4,7};
//        int n = 3;
//        int[] result = obj.q8(nums, n);
//        System.out.print("Shuffled array: [");
//        for (int i = 0; i < result.length; i++) {
//            if (i > 0) {
//                System.out.print(", ");
//            }
//            System.out.print(result[i]);
//        }
//        System.out.println("]");


    }
}