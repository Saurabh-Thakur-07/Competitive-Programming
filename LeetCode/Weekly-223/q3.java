class Solution {
    int[] par;
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        par = new int[n];
        for(int i=0;i<n;i++)
            par[i]=i;
        for(int[] swap : allowedSwaps)
        {
            merge(swap[0],swap[1]);
        }
        // for(int val : par)
        //     System.out.print(val+" ");
        // System.out.println();
        int ans = 0;
        HashMap<Integer,HashMap<Integer,Integer>> map = new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int value = source[i];
            int parent = find(i);
            map.putIfAbsent(parent,new HashMap<>());
            HashMap<Integer,Integer> valCount = map.get(parent);
            valCount.put(value,valCount.getOrDefault(value,0)+1);
            map.put(parent,valCount);
        }
        for(int i=0;i<n;i++)
        {
            int value = target[i];
            int parent = find(i);
            HashMap<Integer,Integer> valCount = map.get(parent);
            
            if(valCount.containsKey(value)==false)
            {
                // System.out.println(value + " "+parent);
                ans++;
                
            }
            else
            {
                int val = valCount.get(value);
                if(val == 1)
                    valCount.remove(value);
                else
                    valCount.put(value,val-1);
                map.put(parent,valCount);
            }
        }
        return ans;
    }
    public boolean merge(int idx1 , int idx2)
    {
        int par1 = find(idx1);
        int par2 = find(idx2);
        if(par1 == par2)
        {
            return true;
        }
        par[par2] = par1;
        return false;
    }
    public int find(int idx)
    {
        if(par[idx] == idx)
        {
            return idx;
        }
        int i = find(par[idx]);
        par[idx] = i;
        return i;
    }
}
