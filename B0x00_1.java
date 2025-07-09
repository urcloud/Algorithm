import java.util.Scanner;

public class B0x00_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int count = 0;

        for(int i=1; i<=N; i++) {
            if(i%3==0 || i%5==0) {
                count++;
            }
        }

        //시간복잡도 O(N)
        System.out.println(count);
    }
}