#include <iostream>
#include <vector>

using namespace std;
long long ans;
int n , cnt = 1;

long long fibo(int k) {
    if (k == 1 or k == 2) return 1;
    else {
        cnt++;
        return fibo(k - 1) + fibo(k - 2);
    }
}

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    cin >> n;
    ans = fibo(n);

    cout << cnt << "\n" << n - 2 << std::endl;
}