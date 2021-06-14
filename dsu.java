/*Vihaar is working with strings. 
He is given two strings A and B, and another string T,
where the length of A and B is same.

You can find the relative groups of letters from A and B,
using the following rule set:
	- Equality rule: 'p' == 'p'
	- Symmetric rule: 'p' == 'q' is same as 'q' == 'p'
	- Transitive rule: 'p' == 'q' and 'q' == 'r' indicates 'p' == 'r'.
	
Vihaar has to form the relatively smallest string of T,
using the relative groups of letters.

For example, if A ="pqr" and B = "rst" , 
then we have 'p' == 'r', 'q' == 's', 'r' == 't' .

The relatives groups formed using above rule set are as follows: 
[p, r, t] and [q,s. And String T ="tts", then relatively smallest string is "ppq".

You will be given the strings A , B and T.
Your task is to help Vihaar to find the relatively smallest string of T.

Input Format:
-------------
Three space separated strings, A , B and T

Output Format:
--------------
Print a string, relatively smallest string of T.


Sample Input-1:
---------------
kmit ngit mgit

Sample Output-1:
----------------
ggit

Explanation: 
------------
The relative groups using A nd B are [k, n], [m, g], [i], [t] and
the relatively smallest string of T is "ggit"


Sample Input-2:
---------------
attitude progress apriori

Sample Output-2:
----------------
aaogoog

Explanation: 
------------
The relative groups using A nd B are [a, p], [t, r, o], [i, g] and [u, e, d, s]
the relatively smallest string of T is "aaogoog"
*/
import java.util.*;
class dsu{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String b=sc.next();
        String t=sc.next();
        int n=a.length();
        int[] union=new int[26];
        for(int i=0;i<26;++i) union[i]=i;
        for(int i=0;i<n;++i){
            char charA=a.charAt(i);
            char charB=b.charAt(i);
            int nodeA=(charA-'a');
            int nodeB=(charB-'a');
            int parentA=find(union,nodeA);
            int parentB=find(union,nodeB);
            if(parentA!=parentB){
                if(parentA<parentB) union[parentB]=parentA;
                else union[parentA]=parentB;
            }
        }
        for(int i=0;i<26;++i) union[i]=find(union,i);
        //System.out.println(Arrays.toString(union));
        String ans="";
        for(int i=0;i<t.length();++i){
            char ch=t.charAt(i);
            int idx=(ch-'a');
            int num=union[idx];
            ans+=((char)(num+'a'));
        }
        System.out.println(ans);
    }
    public static int find(int[] union,int node){
        if(union[node]==node) return node;
        return union[node]=find(union,union[node]);
    }
}
