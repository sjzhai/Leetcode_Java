/*
189. Rotate Array (need to improve)

Given an array, rotate the array to the right by k steps, where k is non-negative.

--------------------------------------------------------------------------------------------
Example 1:
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
rotate 1 steps to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
rotate 1 steps to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]

Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1
0 <= k <= 105


Follow up:

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?

--------------------------------------------------------------------------------------------

*/
//Solution 1: using second loop
class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        if(k > len){
            //Find simplified positon of k
            k = k % len;
        }
        //leftover
        int leftover = len - k - 1;
        int[] new_nums = new int[len];
        //use k to combine new array
        int l = 0;
        int start = len - k;
        while(k > 0){
            new_nums[l] = nums[start];
            start++;
            k--;
            l++;
        }
        int m = 0;
        while(m <= leftover){
            new_nums[l] = nums[m];
            m++;
            l++;
        }
        for(int q = 0; q < nums.length; q++){
            nums[q] = new_nums[q];
        }
    }
}