class LUPrefix {
    boolean f[] = new boolean[100005];
    int cur;
    LUPrefix(int n) {
        cur = 0;
        for (int i = 1; i <= n + 1; i ++) f[i] = false;
    }
    
    public void upload(int video) {
        f[video] = true;
    }
    
    public int longest() {
        while (f[cur + 1]==true) ++ cur;
        return cur;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */
