package shrey.week1.problem3.RubySecondHouse;
import java.util.Scanner;

public class RubySecondHouse {

    public static int minCost(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;

        if (k == 1) return (n == 1) ? costs[0][0] : -1;

        int[] dp = new int[k];
        for (int j = 0; j < k; j++) {
            dp[j] = costs[0][j];
        }

        for (int i = 1; i < n; i++) {
            int[] newDp = new int[k];
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

            for (int j = 0; j < k; j++) {
                if (j == idx1) {
                    newDp[j] = costs[i][j] + min2;
                } else {
                    newDp[j] = costs[i][j] + min1;
                }
            }

            dp = newDp;
        }

        int result = Integer.MAX_VALUE;
        for (int val : dp) {
            result = Math.min(result, val);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[][] costs = new int[n][k];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < k; j++)
                costs[i][j] = sc.nextInt();

        System.out.println(minCost(costs));
    }
}

