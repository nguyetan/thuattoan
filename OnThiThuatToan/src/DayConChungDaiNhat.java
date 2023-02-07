import java.util.Arrays;

import static java.lang.Math.max;

public class DayConChungDaiNhat {
    public static void dayConDaiNhat(int[] a, int[] b) {

        int aLength = a.length;
        int bLength = b.length;

        int[][] dp = new int[aLength + 1][bLength + 1];
        int maxLength = 0;
        int x_endIndex = 0;

        for (int i = 0; i <= aLength; i++) {
            for (int j = 0; j <= bLength; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;

                    if (maxLength < dp[i][j]) {

                        maxLength = dp[i][j];
                        x_endIndex = i - 1;
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        int[] result = new int[maxLength];

        if (x_endIndex + 1 - (x_endIndex - maxLength + 1) >= 0)
            System.arraycopy(a, x_endIndex - maxLength + 1, result, 0, x_endIndex + 1 - (x_endIndex - maxLength + 1));

        if (result.length > 0) {
            System.out.println("Day con chung dai nhat cua 2 mang: " + Arrays.toString(result));
        }
    }

    public static void findSubArrayMax(int []a) {
        int best = Integer.MIN_VALUE, sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = max(a[i], sum + a[i]);
            best = max(best, sum);
        }
        System.out.println(" ");
    }

    public static void dayConTongLon(int []a) {
        int best = Integer.MIN_VALUE, sum = 0;
        int best_start = 0, best_end = 0, current_start = 0;
        for (int i = 0; i < a.length; i++) {
            if (sum + a[i] < a[i]) {
                current_start = i;
                sum = a[i];
            } else {
                sum += a[i];
            }

            if (best < sum) {
                best = sum;
                best_start = current_start;
                best_end = i;
            }
        }
        System.out.println("Day con cua mang a co tong: " + best +
                " start from " + best_start + " to " + best_end + "\n");
    }

    public static void main(String[] args) {
        int[] a = {1, 7, 2, 5, 4, 8, 3, 5, 7};
        int[] b = {9, 2, 5, 6, 1, 3, 5, 7};

        dayConDaiNhat(a, b);
        dayConTongLon(a);

    }
}
