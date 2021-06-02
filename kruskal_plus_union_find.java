/*Budget Padmanabham planned to visit the tourist places.
There are N tourist places in the city.
The tourist places are numbered from 1 to N.
You are given the routes[] to travel between the tourist places in the city.
where routes[i]=[place-1, place-2, price], A route is a bi-directional route.
You can travel from place-1 to place-2 or place-2 to place-1 with the given price.

Your task is to help Budget Padmanabham to find the cheapest route plan,
to visit all the tourist places in the city. If you are not able to find such plan, print -1.

Input Format:
-------------
Line-1: Two space separated integers N and R,number of places and routes.
Next R lines: Three space separated integers, start, end and price.
 
Output Format:
--------------
Print an integer, minimum cost to visit all the tourist places.


Sample Input-1:
---------------
4 5
1 2 3
1 3 5
2 3 4
3 4 1
2 4 5

Sample Output-1:
----------------
8

Explanation:
------------
The cheapest route plan is as follows:
1-2, 2-3, 3-4 and cost is 3 + 4 + 1 = 8


Sample Input-2:
---------------
4 3
1 2 3
1 3 5
2 3 4

Sample Output-2:
----------------
-1
*/

import java.util.*;
class places{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int r=sc.nextInt();
        ArrayList<int[]>edges=new ArrayList<>();
        for(int i=0;i<r;++i){
            int u=sc.nextInt();
            int v=sc.nextInt();
            int w=sc.nextInt();
            edges.add(new int[]{u-1,v-1,w});
        }
        int[] union=new int[n];
        for(int i=0;i<n;++i) union[i]=i;
        for(int[] edge:edges){
            int nodeA=edge[0];
            int nodeB=edge[1];
            int parentA=find(union,nodeA);
            int parentB=find(union,nodeB);
            if(parentA!=parentB) union[parentA]=parentB;
        }
        for(int i=0;i<n;++i) union[i]=find(union,i);
        int cnt=0;
        for(int i=0;i<n;++i){
            if(union[i]==i) cnt++;
        }
        if(cnt>1) System.out.println(-1);
        else{
            Collections.sort(edges,(a,b)->{return a[2]-b[2];});
            int num_edges=0,curr_idx=0;
            union=new int[n];
            for(int i=0;i<n;++i) union[i]=i;
            int ans=0;
            while(num_edges!=n-1){
                int[] edge=edges.get(curr_idx);
                int nodeA=edge[0];
                int nodeB=edge[1];
                int parentA=find(union,nodeA);
                int parentB=find(union,nodeB);
                if(parentA!=parentB){
                    union[parentA]=parentB;
                    ans+=edge[2];
                    num_edges++;
                }
                curr_idx++;
                
            }
            System.out.println(ans);
        }
    }
    public static int find(int[] union,int node){
        if(union[node]==node) return node;
        return union[node]=find(union,union[node]);
    }
}