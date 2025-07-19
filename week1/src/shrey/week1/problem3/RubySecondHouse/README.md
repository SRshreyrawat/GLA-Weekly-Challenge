✅ Problem Statement 
You are given n houses and k colors.
Each house must be painted with one of the k colors.
No two adjacent houses can have the same color.
costs[i][j] represents the cost of painting house i with color j.

👉 Your task: Find the minimum total cost to paint all houses following the constraint.
-------------------------------------------------------------------------------------------
✅ High-Level Approach (Optimized Dynamic Programming)
This is a variation of the "Paint House II" problem.

Brute-force approach:
Try every possible coloring.

Time Complexity: O(n * k²)

Optimized Approach (used in this code):
Use dynamic programming with a trick:

At each house, remember the minimum and second minimum cost from the previous house.

For current color:

If it's same as the previous min-color → use 2nd min cost.

Else → use min cost.

Time Complexity: O(n * k)
--------------------------------------------------------------------------------------------------------------------------------------
✅ Code Walkthrough + Flow
Step 1: Input
int n = sc.nextInt();  // number of houses
int k = sc.nextInt();  // number of colors

int[][] costs = new int[n][k];  // cost[i][j]


Step 2: Handle edge case
if (k == 1) return (n == 1) ? costs[0][0] : -1;
If only 1 color is available:

1 house → ok

1 house → Not possible to paint adjacent houses with different colors → return -1

Step 3: Initialize dp
int[] dp = new int[k];
for (int j = 0; j < k; j++) {
    dp[j] = costs[0][j];  // cost of painting first house
}


Step 4: For each house (from 2nd to last)
for (int i = 1; i < n; i++) {
    int[] newDp = new int[k];
For each house, create a newDp for this row.

Step 4a: Find min1 and min2 from previous dp
int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
int idx1 = -1;

for (int j = 0; j < k; j++) {
    if (dp[j] < min1) {
        min2 = min1;
        min1 = dp[j];
        idx1 = j;
    } else if (dp[j] < min2) {
        min2 = dp[j];
    }
}
min1 = smallest cost, min2 = second smallest

idx1 = color index with minimum cost

Step 4b: Update newDp
for (int j = 0; j < k; j++) {
    if (j == idx1) {
        newDp[j] = costs[i][j] + min2;
    } else {
        newDp[j] = costs[i][j] + min1;
    }
}
If current color j is same as previous minimum color, we must take second minimum to avoid adjacent conflict.

Else, take minimum.

Step 5: Replace dp with newDp
dp = newDp;

Step 6: Return minimum cost from final dp
int result = Integer.MAX_VALUE;
for (int val : dp) {
    result = Math.min(result, val);
}
return result;


-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
🪵 Dry Run Example

Input:

n = 3 (houses)
k = 3 (colors)
costs = [
  [1, 5, 3],
  [2, 9, 4],
  [3, 6, 1]
]
Step-by-step:
House 0: dp = [1, 5, 3] → min1 = 1 (idx1=0), min2 = 3

House 1:

color 0 → same as min1 → 2 + min2 = 5

color 1 → 9 + min1 = 10

color 2 → 4 + min1 = 5
→ new dp = [5, 10, 5]

House 2:

min1 = 5 (idx=0), min2 = 5

color 0 → 3 + 5 = 8

color 1 → 6 + 5 = 11

color 2 → 1 + 5 = 6
→ new dp = [8, 11, 6]

✔️ Final result = min(8, 11, 6) = 6
----------------------------------------------------------------------------------------------------------------------
✅ Time and Space Complexity (Step-by-Step)
🕒 Time Complexity:
Outer loop over houses: n

Inner operations: each step finds min1 & min2 in O(k)

Another inner loop to update dp also O(k)

✅ Total time: O(n * k)

💾 Space Complexity:
costs[][]: O(n * k) — input

dp[] and newDp[]: O(k)

✅ Extra space: O(k)
