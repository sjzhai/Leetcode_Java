/*
278. First Bad Version

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.


--------------------------------------------------------------------------------------------
Example 1:
Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.

Example 2:
Input: n = 1, bad = 1
Output: 1

Constraints:
1 <= bad <= n <= 231 - 1
--------------------------------------------------------------------------------------------

*/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        //Binary Search to find middle val: 
        //If true, version in left section
        //If false，version in right section
        int left = 0;
        int right = n;
        while(left < right){
            int mid = left + ((right - left) / 2);
            boolean boolVal = isBadVersion(mid);
            if(boolVal == true){
                //find one more left
                boolean boolLeft = isBadVersion(mid-1);
                if(boolLeft == false){
                    return mid;
                }
                right = mid - 1;
            }else if(boolVal == false){
                //find one more right
                boolean boolRight = isBadVersion(mid+1);
                if(boolRight == true){
                    return mid+1;
                }
                left = mid + 1;
            }
        }
        return 0;
    }
}