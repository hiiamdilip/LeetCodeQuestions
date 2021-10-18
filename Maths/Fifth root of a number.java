int floorRoot5(int n)
{
    if (n == 0 || n == 1) return n;
    int res = 0;
    while (res * res * res * res * res <= n) res++;
    return res-1;
}


int floorRoot5(int n)
    {
        if (n == 0 || n == 1) return n;
   
        int low = 1, high = n, ans = 0;
        while (low <= high)
        {
            int mid = (low + high) / 2;
            long mid5 = mid * mid * mid * mid * mid;
     
            if (mid5 == n) return mid;
    
            if (mid5 < n)
            {
                low = mid + 1;
                ans = mid;
            }
            else high = mid - 1;
        }
        return ans;
    }
