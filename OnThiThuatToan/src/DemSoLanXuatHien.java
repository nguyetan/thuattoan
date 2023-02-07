import java.util.Arrays;
import java.util.Scanner;

public class DemSoLanXuatHien {

    public static void main(String[] args) {
        int[] a = { 1, 7, 2, 6, 4, 8, 3, 5, 7 };
        int[] b = { 9, 2, 5, 6, 1, 3, 5, 7 };

        int length = a.length + b.length;
        int[] result = new int[length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        System.out.println(Arrays.toString(result));

        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào 1 số nguyên bất kỳ: ");
        int num = scanner.nextInt();

        for (int i = 0; i < length; i++) {
            if (result[i] == num) {
                count++;
            }
        }
        System.out.println("Số phần tử " + num + " có trong mảng = " + count);
    }
}
