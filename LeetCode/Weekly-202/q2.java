class Solution {
    public int minOperations(int n) {
        int mid = n/2;
        int val = 0;
        if(n%2==0)
        val += mid*2;
        else
        val += mid*2+1;
        int ans = - (mid*(2 + (mid-1)*2))/2;
        ans += mid*val;
        return ans;
    }
}
