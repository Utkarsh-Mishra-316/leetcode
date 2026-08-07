class Solution {
    public static boolean  vowel(char s){
        s=Character.toLowerCase(s);
        return s=='a' || s=='e' || s=='i' || s=='o'|| s=='u';
    }
    public String reverseVowels(String s) {
        int left=0;
        char arr[]= s.toCharArray();
        int right =s.length()-1;
        while(left<right){
             while(left<right && !vowel(arr[left])){
                left++;
            }
           while(left<right && !vowel(arr[right])){
                right--;
            }
            if(  left<right){
                char ch= arr[left];
                arr[left]=arr[right];
                arr[right]=ch;
                left++;
                right--;
            }
            
        }
        return new String(arr);
    }
}