package B0x02;

public class B0x02_2 {
  //자바는 무조건 값에 의한 호출임
  //하지만 값이 기본형이면 값 그 자체를 복사하고, 객체라면 객체의 주소값을 복사함

  //xq, y1의 경우 기본형 int라 값 그 자체를 복사해서 넘겨서 함수 안에서 값을 바꿔도 원본에는 영향이 없음
  public static void swap1(int a, int b) {
    int tmp = a;
    a = b;
    b = tmp;
    System.out.println("swap1 내부: a = " + a + ", b = " + b);
  }

  static class IntWrapper {
    int value;
    IntWrapper(int value) {
      this.value = value;
    }
  }

  //이때 x2, y2는 객체임 따라서 x2, y2의 참조값(주소)를 복사해서 a,b로 넘기므로 객체 내부의 값이 함수 안에서 수정됨
  public static void swap2(IntWrapper a, IntWrapper b) {
    int tmp = a.value;
    a.value = b.value;
    b.value = tmp;
  }

  public static void main(String[] args) {
    //
    int x1 = 10;
    int y1 = 20;
    swap1(x1, y1);
    System.out.println("main: x1 = " + x1 + ", y1 = " + y1);  // 변경 안 됨

    IntWrapper x2 = new IntWrapper(10);
    IntWrapper y2 = new IntWrapper(20);
    swap2(x2, y2);
    System.out.println("x2 = " + x2.value + ", y2 = " + y2.value);  // 변경됨
  }
}
