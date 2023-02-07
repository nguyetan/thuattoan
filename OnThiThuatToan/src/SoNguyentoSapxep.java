public class SoNguyentoSapxep {
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static int hoanDoi(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low -1);
        for (int j=low; j<high; j++)
        {
            if (arr[j] < pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return i+1;
    }
    public static void sort(int arr[], int low, int high)
    {
        if (low < high)
        {
            int pi = hoanDoi(arr, low, high);
            sort(arr, low, pi-1);
            sort(arr, pi+1, high);
        }
    }
    public static void print(int arr[])
    {
        for (int i=0; i< arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = { 1, 7, 2, 6, 4, 8, 3, 5 };
        System.out.print("So nguyen to trong mang: ");
        for (int num : arr){
            if (isPrime(num)){
                System.out.print(num + " ");
            }
        }
        System.out.println(" ");
        System.out.print("Mang ban dau: ");
        print(arr);
        sort(arr, 0, arr.length - 1);
        System.out.print("Mang da sap xep: ");
        print(arr);
    }
}
