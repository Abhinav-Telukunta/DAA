/*Jagannadham is working with a set of words[], 
He wants to find out the common substring in all the words in the set,
and the substring should be the longest and also a prefix.

Can you help Jagannadham to find such substring.
If the substring is found, print it.
Otherwise, print an empty string,"".

Input Format:
-------------
Space separated strings, set of words[].

Output Format:
--------------
Print a string, the substring.


Sample Input-1:
---------------
apple applet application append

Sample Output-1:
----------------
"app"


Sample Input-2:
---------------
ant fox cat camel fish

Sample Output-2:
----------------
""

NOTE: 
	- " ", added for clarity no need to add in the output.
	- all the words consist of lowercase letters only.
*/
import java.util.*;
class common_substr{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String[] s=sc.nextLine().split(" ");
        int low=0,high=s.length-1;
        String ans=substring(s,low,high);
        System.out.println(ans);
    }
    public static String substring(String[] s,int low,int high){
        if(low==high) return s[low];
        int mid=(low+high)/2;
        String left=substring(s,low,mid);
        String right=substring(s,mid+1,high);
        return lcp(left,right);
    }
    public static String lcp(String left,String right){
        String res="";
        int min_len=Math.min(left.length(),right.length());
        for(int i=0;i<min_len;++i){
            if(left.charAt(i)==right.charAt(i)){
                res+=left.charAt(i);
            }
            else break;
        }
        return res;
    }
}
