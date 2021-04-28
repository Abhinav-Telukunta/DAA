/*Motu loves to eat Samosas. A Samosas vendor prepared N boxes of samosas, 
where i-th box contains box[i] samosas. And the samosas vendor went outside,
He will be back in T hours time.

Motu can decide his eating speed of samosas per hour as S.  
Each hour, He chooses any box of samosas, and eats S samosas from that box.  
If the box has less than S samosas, he eats all of them instead, 
and won't eat any more samosas during this hour.

Motu likes to eat slowly, but he wants to finish eating all the samosas 
before the vendor come back.

Can you help Motu to find out his minimum eating speed S,
such that he can eat all the samosas within T hours, and print S.

Note:
	- You may assume that the time T is always >= Number of boxes

Input Format:
-------------
Line-1: space separated integers, box[], number of samosas in each box
Line-2: An integer T.

Output Format:
--------------
Print an integer S, minimum eating speed of Motu.


Sample Input-1:
---------------
4 8 9 13
8

Sample Output-1:
----------------
5


Sample Input-2:
---------------
15 18 12 17 22
7

Sample Output-2:
----------------
17
*/
import java.util.*;
class min_speed{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        int n=s.length;
        int[] arr=new int[n];
        int maxx=0;
        for(int i=0;i<s.length;++i) {
            arr[i]=Integer.parseInt(s[i]);
            maxx=Math.max(maxx,arr[i]);
        }
        int t=sc.nextInt();
        int low=0,high=maxx;
        while(low<=high){
            int mid=(low+high)/2;
            int hours=0;
            for(int num:arr){
                if(num<=mid) hours++;
                else hours+=Math.ceil(num*(1.0)/mid);
            }
            if(hours<=t) high=mid-1;
            else low=mid+1;
        }
        System.out.println(low);
    }
}
