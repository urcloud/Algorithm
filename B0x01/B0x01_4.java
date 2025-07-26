package B0x01;

import java.util.Scanner;

public class B0x01_4 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();

    int result = 1;
    while (result * 2 <= N) {
      result *= 2;
    }

    //시간복잡도 O(logN)
    System.out.println(result);
  }
}
