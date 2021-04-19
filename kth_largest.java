import java.util.*;
class nth_tallest{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;++i) arr[i]=sc.nextInt();
        System.out.println(kth_largest(arr,0,n-1,k,n));
    }
    public static int kth_largest(int[] arr,int low,int high,int k,int n){
        int pivot_index=partition(arr,low,high,n);
        if(pivot_index==n-k) return arr[pivot_index];
        if(n-k<pivot_index) return kth_largest(arr,low,pivot_index-1,k,n);
        else return kth_largest(arr,pivot_index+1,high,k,n);
    }
    public static int partition(int[] arr,int l,int h,int n){
        int pivot=arr[l];
		int i=l,j=h;
		while(i<j) {
			while(i<n && arr[i]<=pivot) i++;
			while(j>=0 && arr[j]>pivot) j--;
			if(i<j) swap(arr,i,j);
		}
		swap(arr,l,j);
		return j;
    }
    public static void swap(int[] arr,int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}
