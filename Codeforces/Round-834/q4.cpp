
#include <bits/stdc++.h>

using namespace std;

int main()
{
    int t ;
    cin>>t;
    while(t-->0){
    long long n,m;
    cin>>n>>m;
    long long ans=n,k=1;
    while(n%10==0)
		n=n/10;
	while(n%5==0)
	{
		n/=5;
		if(k*2 <= m)k*=2;
		else break;
	}
	while(n%2==0)
	{
		n/=2;
		if(k*5<=m)k*=5;
		else break;
	}
	while(k*10 <= m)k*=10;
	k=(m/k)*k;
	cout<<ans*k<<endl;
}
}