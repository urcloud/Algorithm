package B0x03;

import java.util.Scanner;

public class B0x03_4 {
  // 주어진 길이 N의 int 배열 arr에서 합이 100인 서로 다른 위치의 두 원소가 존재하면 1을, 존재하지 않으면 0을 반환하는 함수 func2(int arr[], int N)을 작성하라.
  // arr의 각 수는 0 이상 100 이하이고 N은 1000 이하이다.

  // 시간복잡도 O(N)으로 해결하기
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int[] arr = new int[N];

    for (int i = 0; i < N; i++) {
      arr[i] = scanner.nextInt();
    }

    System.out.println(func2(arr, arr.length));
    scanner.close();
  }

  public static int func2(int[] arr, int N) {
    int[] occur = new int[101];

    for(int i=0; i<N; i++) {
      if(occur[100 - arr[i]] == 1)
        return 1;

      occur[arr[i]] = 1;
    }

    return 0;
  }
}
