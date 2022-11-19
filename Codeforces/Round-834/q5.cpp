
#include <bits/stdc++.h>

using namespace std;

int main()
{
    int t ;
    cin>>t;
    while(t-->0){
    int n,H;
    cin>>n>>H;
    vector<int> arr(n);
    for(int i=0;i<n;i++)
    cin>>arr[i];
    sort(arr.begin(),arr.end());
    int ans=0;
    for(int k1=0;k1<=2;k1++)
    {
        int idx=0,k=0;
		long long h=H;
        while(idx<n)
        {
            if(h>arr[idx]) h+= arr[idx++]/2;
            else if(k==3)break;
            else
            {
                if(k==k1)h*=3;
                else
                h*=2;
                k++;    
            }
        }
        ans=max(ans,idx);
    }
    cout<<ans<<"\n";
}
}