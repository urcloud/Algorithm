package B0x01;

import java.util.Scanner;

public class B0x01_3 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int x = (int) Math.sqrt(N);
    int result = 0;

    if(x==Math.sqrt(N)) {
      result = 1;
    }

    //시간복잡도 O(1)
    System.out.println(result);



    //강사님 코드
    /*
    int func3(int N) {
    for(int i=1; i*i<=N; i++) {
      if(i*i==N) return 1;
    }

    //시간복잡도 O(루트N)
    return 0
    */
  }
}
