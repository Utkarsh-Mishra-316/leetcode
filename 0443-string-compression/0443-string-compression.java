class Solution {
    public int compress(char[] chars) {
 ArrayList<Character>list=new ArrayList<>();
 
 int cnt=1;
 for(int i=1;i<chars.length;i++){
 if(chars[i]==chars[i-1]){
    cnt++;
 }
 else{
    list.add(chars[i-1]);
  if(cnt>1){
    for(char ch: String.valueOf(cnt).toCharArray()){
        list.add(ch);
    }
  }
    cnt=1;
 }
 }
list.add(chars[chars.length-1]);
if(cnt>1){
    for(char ch: String.valueOf(cnt).toCharArray()){
        list.add(ch);
    }
  }
for (int i = 0; i < list.size(); i++) {
            chars[i] = list.get(i);
        }
return list.size();
    }
}