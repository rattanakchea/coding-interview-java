// Palnindrome Partitioning II

// Given a string s, partition s such that every substring of the partition is a palindrome.

// Return the minimum cuts needed for a palindrome partitioning of s.

// Example:

// Input: "aab"
// Output: 1
// Explanation: The palindrome partitioning ["aa","b"] could be produced using 1 cut.

// Input "abc"
// Output: 2
// Explanation: The palindrome partitioning ["a","b","c"] could be produced using 1 cut.

// Using recursive with cache is still too slow. Need to use DP to pass all tests.
// This solution is still quite slow compare to others, but it passes all the tests.

class Solution {
    Map<String, Integer> cache = new HashMap<>();
    
    public int minCut(String s) {
//         if (s.length() == 0) return 0;
        
//         if (cache.containsKey(s))
//             return cache.get(s);
        
//         if (isPalindrome(s)) return 0;
        
//         int cut = Integer.MAX_VALUE;
        
//         for (int i = 0; i < s.length() - 1; i++){
//             int localCut = 1 + minCut(s.substring(0, i + 1)) + minCut(s.substring(i + 1));
//             cut = Math.min(cut, localCut);
//         }
        
//         cache.put(s, cut);
        
//         return cut;
        
        return dp(s);
    }
    
    private int dp(String s){
        int[][] dp = new int[s.length()][s.length()];
        // fill array with max value
        for (int[] arr: dp){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        
        // base case
        for (int i = 0; i < dp.length; i++){
            dp[i][i] = 0;
        }
        
        for (int size = 1; size < s.length(); size++){
            for (int i = 0; i < dp.length - size; i++){
                
                int endIndex = size + i;
                // if whlle string is palandrome
                if ( isPalindrome(s, i, endIndex) ){
                    dp[i][endIndex] = 0;
                    continue;
                }
                
                
                for (int j = i; j < endIndex; j++){
                    dp[i][endIndex] = Math.min(1 + dp[i][j] + dp[j+1][endIndex], dp[i][endIndex]);
                }
            }   
            
        }

        return dp[0][dp.length - 1];
    }
    
    private boolean isPalindrome(String s, int i, int j){
        while(i < j){
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        
        return true;
    }
    
    private boolean isPalindrome(String s){
        for (int i = 0; i < s.length()/2; i++){
            if ( s.charAt(i) != s.charAt(s.length() - 1 - i) )
                return false;
        }
        
        return true;
    }
}