#include <iostream>
#include <vector>

using namespace std;

int main(int argc, char const *argv[])
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    
    int n , k , cnt = 0 , m;
    cin >> n;
    vector<int> arr;
    for (int i = 0; i < n; i++)
    {
        cin >> k;
        arr.push_back(k);
    }
    
    cin >> m;

    for (int i = 0; i < n; i++)
    {
        if (arr[i] == m) cnt++;
    }
    
    cout << cnt << std::endl;
}
