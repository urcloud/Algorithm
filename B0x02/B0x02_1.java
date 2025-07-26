package B0x02;

public class B0x02_1 {
  public static void func1(int a) {
    a = 5;
  }

  public static void func2(int[] arr) {
    arr[0] = 10;
  }

  static class Pt {
    int x, y;
  }

  public static void func3(Pt a) {
    a.x = 10;
  }

  public static void main(String[] args) {
    // 자바는 항상 "값"을 넘김. t의 값인 0이 func의 매개변수 a에 복사되기 때문에 a=5를 해도 원래의 t는 바뀌지 않음
    int t = 0;
    func1(t);
    System.out.println(t); // 출력: 0

    // int[] arr, 배열은 객체(참조형)이기 때문에, 함수에 배열을 넘기면 배열 주소가 값으로 전달되기 때문에 arr[0]=10;을 하면 원본 배열이 변경됨
    int[] arr = {1, 2, 3};
    func2(arr);
    System.out.println(arr[0]);  // 출력: 10

    // 자바는 tmp 객체의 참조값(주소)을 func에 값으로 넘기므로 함수 안에서 그 주소를 따라가 내부 값인 a.x를 바꾸면 원본도 바뀜
    // c++은 구조체를 값 자체로 넘겨서 복사본이 수정되고, java는 주소를 값으로 넘겨서 원본이 수정됨
    // 따라서 c++의 경우 0. java의 경우 10이 출력됨
    Pt tmp = new Pt();
    tmp.x = 0;
    tmp.y = 0;

    func3(tmp);
    System.out.println(tmp.x);  // 출력: 10
  }
}