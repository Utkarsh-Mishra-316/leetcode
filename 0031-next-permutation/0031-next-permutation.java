class Solution {
    public void nextPermutation(int[] arr) {
        
    int piv=-1;
        int n=arr.length;
        for(int i=n-2;i>=0;i--){
            if(arr[i]<arr[i+1]){
                piv=i;
                break;
            }
        }
        if(piv==-1){
            reverse(arr,0,n-1);
            return ;
        }
        
        for(int i=n-1;i>piv;i--){
            
            if(arr[i]>arr[piv]){
                swap(arr,i,piv);
                break;
            }
        }
        int i=piv+1;
        int j=n-1;
        while(i<=j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }
    void swap(int [] nums,int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    void reverse(int []arr,int i,int j){
        while(i<=j){
            swap(arr,i++,j--);
        }
    }
    
}