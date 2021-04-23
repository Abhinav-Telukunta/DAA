/*Giridhar is given a array of N integers arr[], 
The array contains both +ve nad -ve numbers.

iridhar is trying to find the sum of sub-array which is hieghest.
Where the sum is the sum of all elements of contiguous subarray[] of arr[],
and subarray[] should be atleast 1 in length.

Your task is to help Giridhar to find the Sum of subarray which is highest.

Input Format:
-------------
Line-1: An integer N.
Line-2: N space separated integers, List[].

Output Format:
--------------
An integer, print the highest sum of subarray.
 

Sample Input-1:
---------------
9
-3 1 -2 4 -2 2 3 -5 4

Sample Output-1:
----------------
7

Explanation:
------------
Contiguous subarray [4,-1,2,3] has highest sum = 7


Sample Input-2:
---------------
2
1 -2

Sample Output-2:
----------------
1

Explanation:
------------
Contiguous subarray [1] has biggest sum = 1
*/
import java.util.*;
class maximum_subarray_sum_dc{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;++i) arr[i]=sc.nextInt();
        int ans=get_maximum(arr,0,n-1);
        System.out.println(ans);
    }
    public static int get_maximum(int[] arr,int low,int high){
        if(low==high) return arr[low];
        int mid=(low+high)/2;
        return Math.max(Math.max(get_maximum(arr,low,mid),get_maximum(arr,mid+1,high)),sum_of_left_and_right(arr,low,mid,high));
    }
    public static int sum_of_left_and_right(int[] arr,int low,int mid,int high){
        int lsum=Integer.MIN_VALUE,rsum=Integer.MIN_VALUE;
        int sum=0;
        for(int i=mid;i>=low;--i){
            sum+=arr[i];
            lsum=Math.max(lsum,sum);
        }
        sum=0;
        for(int i=mid+1;i<=high;++i){
            sum+=arr[i];
            rsum=Math.max(rsum,sum);
        }
        return Math.max(lsum+rsum,Math.max(lsum,rsum));
    }
}
