#{ 
 # Driver Code Starts
#Initial Template for Python 3

# } Driver Code Ends
#User function Template for python3

class Solution:
    def count(self, n):
        # Code here
        edges = (n*(n-1))//2
        return 2**edges
        
        

#{ 
 # Driver Code Starts.
if __name__ == '__main__': 
    t = int(input())
    for _ in range (t):
        n = int(input())
        ob = Solution()
        res = ob.count(n)
        print(res)
# } Driver Code Ends