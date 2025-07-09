import java.util.Scanner;

public class B0x00_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] arr = new int[N];
        for(int i=0; i<N; i++) {
            arr[i] = scanner.nextInt();
        }
        
        int result = func2(arr, N);

        System.out.println(result);
    }

    public static int func2(int[] arr, int N) {
        int result = 0;
        for(int i=0; i<N; i++) {
            for(int j=N-1; j>i; j--) {
                if(arr[i] + arr[j] == 100) {
                    result = 1;
                    break;
                }
            }
        }

        //시간복잡도 O(N^2)
        return result;
    }
}