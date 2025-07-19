**Step-by-Step Logic:**



Read input size N and array arr\[] from the user.



Call findMin(arr) to find the minimum element.



Inside findMin:



Use binary search by maintaining two pointers low and high.



If arr\[mid] > arr\[high], it means the min is in the right half.



Else, the min is in the left half (including mid).



Loop until low == high and return arr\[low].



✅ **Dry Run with Examples**

**🧪 Example 1: \[4, 5, 6, 7, 0, 1, 2]**



Initial: low=0, high=6

mid=3 -> arr\[mid]=7, arr\[high]=2 -> arr\[mid] > arr\[high], so min is in right

low = mid + 1 = 4



low=4, high=6

mid=5 -> arr\[mid]=1, arr\[high]=2 -> arr\[mid] < arr\[high], min is in left

high = mid = 5



low=4, high=5

mid=4 -> arr\[mid]=0, arr\[high]=1 -> arr\[mid] < arr\[high], min is in left

high = mid = 4



low=4, high=4 => return arr\[low] = 0



**✅ Output: 0**



**🧪 Example 2: \[2, 3, 4, 5, 6, 7, 1]**

&nbsp;	Initial: low=0, high=6

&nbsp;	mid=3 -> arr\[mid]=5, arr\[high]=1 -> arr\[mid] > arr\[high]

&nbsp;	low = mid + 1 = 4



&nbsp;	low=4, high=6

&nbsp;	mid=5 -> arr\[mid]=7, arr\[high]=1 -> arr\[mid] > arr\[high]

&nbsp;	low = mid + 1 = 6



low=6, high=6 => return arr\[low] = 1

**✅ Output: 1**



**🧪 Example 3: \[1, 2, 3, 4, 5] (Not rotated)**

&nbsp;	Initial: low=0, high=4

&nbsp;	mid=2 -> arr\[mid]=3, arr\[high]=5 -> arr\[mid] < arr\[high]

&nbsp;	high = mid = 2



&nbsp;	low=0, high=2

&nbsp;	mid=1 -> arr\[mid]=2, arr\[high]=3 -> arr\[mid] < arr\[high]

&nbsp;	high = mid = 1



&nbsp;	low=0, high=1

&nbsp;	mid=0 -> arr\[mid]=1, arr\[high]=2 -> arr\[mid] < arr\[high]

&nbsp;	high = mid = 0



&nbsp;	low=0, high=0 => return arr\[low] = 1

**✅ Output: 1**





**🐞 Debug Version of findMin**

*public static int findMin(int\[] arr) {*

    *int low = 0, high = arr.length - 1;*



    *while (low < high) {*

        *int mid = low + (high - low) / 2;*

        *System.out.println("low=" + low + ", mid=" + mid + ", high=" + high);*

        *System.out.println("arr\[low]=" + arr\[low] + ", arr\[mid]=" + arr\[mid] + ", arr\[high]=" + arr\[high]);*



        *if (arr\[mid] > arr\[high]) {*

            *System.out.println("=> arr\[mid] > arr\[high], so min is in RIGHT half");*

            *low = mid + 1;*

        *} else {*

            *System.out.println("=> arr\[mid] <= arr\[high], so min is in LEFT half (including mid)");*

            *high = mid;*

        *}*

        *System.out.println("---------------------");*

    *}*



    *System.out.println("Final low=" + low + ", arr\[low]=" + arr\[low]);*

    *return arr\[low];*

*}*



***Input:***

***7***

***4 5 6 7 0 1 2***



***Output:***

***0***

📦 **Time and Space Complexity**

&nbsp;  *Let's analyze the Time Complexity and Space Complexity of your findMin function step by step:*



✅ Code for Reference

*public static int findMin(int\[] arr) {*

    *int low = 0, high = arr.length - 1;*



    *while (low < high) {*

        *int mid = low + (high - low) / 2;*



        *if (arr\[mid] > arr\[high]) {*

            *low = mid + 1;*

        *} else {*

            *high = mid;*

        *}*

    *}*



    *return arr\[low];*

*}*

⏱️ **Time Complexity**

**Let’s denote:**



N = number of elements in the input array arr.



This function performs a binary search:



In each iteration of the while (low < high) loop, the search space is halved:



Either low = mid + 1 or high = mid.



Binary search takes O(log N) steps.



**✅ Time Complexity: O(log N)**



**💾 Space Complexity**

*The algorithm uses only constant extra space:*



A few integer variables (low, high, mid).



No recursion, no additional data structures like arrays, lists, or hash maps.



**✅ Space Complexity: O(1)**





