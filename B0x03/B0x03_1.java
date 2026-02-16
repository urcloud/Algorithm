package B0x03;

public class B0x03_1 {

// 임의의 위치의 원소를 추가하고 제거하기
static int len;   // C++의 int& len 역할

  static void insert(int idx, int num, int[] arr) {
    for (int i = len; i > idx; i--) {
      arr[i] = arr[i - 1];
    }
    arr[idx] = num;
    len++;
  }

  static void erase(int idx, int[] arr) {
    for (int i = idx; i < len - 1; i++) {
      arr[i] = arr[i + 1];
    }
    len--;
  }

  static void printArr(int[] arr) {
    for (int i = 0; i < len; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println("\n");
  }

  static void insert_test() {
    System.out.println("***** insert_test *****");
    int[] arr = new int[10];
    arr[0] = 10;
    arr[1] = 20;
    arr[2] = 30;
    len = 3;

    insert(3, 40, arr); // 10 20 30 40
    printArr(arr);

    insert(1, 50, arr); // 10 50 20 30 40
    printArr(arr);

    insert(0, 15, arr); // 15 10 50 20 30 40
    printArr(arr);
  }

  static void erase_test() {
    System.out.println("***** erase_test *****");
    int[] arr = {10, 50, 40, 30, 70, 20, 0, 0, 0, 0};
    len = 6;

    erase(4, arr); // 10 50 40 30 20
    printArr(arr);

    erase(1, arr); // 10 40 30 20
    printArr(arr);

    erase(3, arr); // 10 40 30
    printArr(arr);
  }

  public static void main(String[] args) {
    insert_test();
    erase_test();
  }
}