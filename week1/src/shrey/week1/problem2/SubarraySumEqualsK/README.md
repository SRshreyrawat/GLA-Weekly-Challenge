✅ 1. First Approach: Explanation (Prefix Sum + HashMap)

Problem:
Given an array nums and an integer k, count the total number of continuous subarrays whose sum equals k.

Naive/Brute-force Approach (Just for contrast)

We could use two nested loops to check all possible subarrays and count those whose sum is k:

for (int i = 0; i < n; i++) {
    for (int j = i; j < n; j++) {
        // compute sum of nums[i] to nums[j]
    }
}
Time Complexity: O(n²)
----------------------------------------------------------------------------------------------------------------------------------
Optimized Approach Used Here: Prefix Sum + HashMap
Idea:
Use prefix sums to track cumulative sum as you iterate.

Use a HashMap to store how many times a particular prefix sum has occurred.

For current sum, check if (sum - k) has occurred before. If yes, that means a subarray ending at the current index has sum = k.

Mathematically:
If sum(i to j) = k, and
prefixSum[j] - prefixSum[i-1] = k ⇒
prefixSum[i-1] = prefixSum[j] - k
------------------------------------------------------------------------------------------------------------------------------------------
✅ 2. Code Flow Explanation

int count = 0;
int sum = 0;
HashMap<Integer, Integer> map = new HashMap<>();
map.put(0, 1);  // Base case: a sum of 0 has occurred once
Then loop:

for (int num : nums) {
    sum += num;

    if (map.containsKey(sum - k)) {
        count += map.get(sum - k);
    }

    map.put(sum, map.getOrDefault(sum, 0) + 1);
}
------------------------------------------------------------------------------------------------------------------------------------------
✅ 3. Step-by-Step Debug (Dry Run)
Input:
nums = [1, 2, 3]
k = 3
Initialize:

count = 0

sum = 0

map = {0=1}

Step 1: 
num = 1
sum = 0 + 1 = 1

sum - k = 1 - 3 = -2 → not in map → no count added

Update map: {0=1, 1=1}

Step 2:
num = 2
sum = 1 + 2 = 3

sum - k = 3 - 3 = 0 → found in map → count += map.get(0) → count = 1

Update map: {0=1, 1=1, 3=1}

Step 3:
num = 3
sum = 3 + 3 = 6

sum - k = 6 - 3 = 3 → found in map → count += map.get(3) → count = 2

Update map: {0=1, 1=1, 3=1, 6=1}

Final Answer: 2 subarrays:

[1, 2]

[3]

------------------------------------------------------------------------------------------------------------------------------------------

✅ 4. Time and Space Complexity
Time Complexity: O(n)
We traverse the array only once (single loop).

HashMap operations (get, put, containsKey) are O(1) average time.

✅ So total time = O(n)

Space Complexity: O(n)
In worst case, all prefix sums are unique ⇒ HashMap will have n entries.

✅ So total space = O(n)
