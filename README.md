import java.util.*;

public class CyclicSubstring {
    public static int maxCyclicUniqueSum(String S) {
        int n = S.length();
        String T = S + S;  
        
        Set<Character> seen = new HashSet<>();
        int left = 0;
        int currentSum = 0;
        int maxSum = 0;
        
        for (int right = 0; right < T.length(); right++) {
            char ch = T.charAt(right);
            int val = ch - 'a' + 1;
            
          
            while (seen.contains(ch) || (right - left + 1) > n) {
                char leftChar = T.charAt(left);
                seen.remove(leftChar);
                currentSum -= (leftChar - 'a' + 1);
                left++;
            }
            
            seen.add(ch);
            currentSum += val;
            
            maxSum = Math.max(maxSum, currentSum);
        }
        
        return maxSum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine().trim();
        
        System.out.println(maxCyclicUniqueSum(S));
        
        sc.close();
    }
}
