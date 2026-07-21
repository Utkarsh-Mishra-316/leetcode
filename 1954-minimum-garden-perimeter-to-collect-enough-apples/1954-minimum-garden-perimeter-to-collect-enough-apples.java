class Solution {
    public long minimumPerimeter(long neededApples) {
        long sum=0;
        long cnt=0;
        while(sum<neededApples){
            cnt++;
            sum+=(12*cnt*cnt);

        }
        return (8*(cnt));
    }
}
