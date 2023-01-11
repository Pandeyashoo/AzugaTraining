#include<bits/stdc++.h>
using namespace std;
#define M 1000000007
int main(){
    int n;
    cin>>n; 
    int ans=1;
    for(int i=0; i<n; i++){
        ans=(ans*2)%M;
    }
    // long long  ans=pow(2,n);
    // ans=ans%M;
    cout<<ans;
    return 0;
}