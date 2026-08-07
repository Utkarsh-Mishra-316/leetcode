class Solution {
     public static boolean  vowel(char s){
        s=Character.toLowerCase(s);
        return s=='a' || s=='e' || s=='i' || s=='o'|| s=='u';
    }
    public String sortVowels(String s) {
        
        char arr[]= s.toCharArray();
 List<Character> list= new ArrayList<>();
 for( char ch: arr) {
    if(vowel(ch)){
        list.add(ch);
    }
 }       

 int ind=0;
 Collections.sort(list);
 for(int i=0;i<arr.length;i++){
    if(vowel(arr[i])){
        arr[i]=list.get(ind++);
    }
 }
 return new String(arr);
    }
}