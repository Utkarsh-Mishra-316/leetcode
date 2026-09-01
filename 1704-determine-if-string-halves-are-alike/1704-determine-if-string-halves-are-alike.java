class Solution {
    static boolean vowel(char ch){
        ch=Character.toLowerCase(ch);
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
 
    }
    public boolean halvesAreAlike(String s) {
        char [] arr=s.toCharArray();
        int n=s.length();
        int a=0;
        int b=0;
        for(int i=0;i<n/2;i++){
if(vowel(arr[i])){
    a++;
}
        }
        for(int i=n/2;i<n;i++){
if(vowel(arr[i])){
    b++;
}
   
        }

        return a==b;
    }
}