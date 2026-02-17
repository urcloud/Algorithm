package B0x04;

import java.util.Arrays;

// B0x04_1 코드 마지막 원소 찾는 방법 O(1)로 수정
// 마지막 원소를 찾으려면 nxt를 끝까지 따라가야 해서 O(N)인데, 마지막 원소의 주소를 따로 저장하면 바로 알 수 있음
public class B0x04_2 {
  static final int MX = 1000005;
  static int[] dat = new int[MX];
  static int[] pre = new int[MX];
  static int[] nxt = new int[MX];
  static int unused = 1;
  //마지막 원소의 주소, 리스트 비어있으면 tail=0, insert, erase할 때만 갱신
  static int tail = 0;

  // insert에서 마지막에 추가될 때 tail 갱신하기
  // 연결 리스트에서 insert, erase할 때 상황만 체크하면 항상 tail이 최신 상태 유지가 됨
  // head랑 tail 포인터 유지하기 방법 사용
  static void insert(int addr, int num) {
    dat[unused] = num;
    pre[unused] = addr;
    nxt[unused] = nxt[addr];

    if (nxt[addr] != -1)
      pre[nxt[addr]] = unused;

    nxt[addr] = unused;

    if (nxt[unused] == -1)
      tail = unused;

    unused++;
  }

  // erase에서 마지막을 삭제할 때 tail 갱신하기
  static void erase(int addr) {
    nxt[pre[addr]] = nxt[addr];

    if (nxt[addr] != -1)
      pre[nxt[addr]] = pre[addr];

    if (addr == tail)
      tail = pre[addr];
  }

  static void traverse() {
    int cur = nxt[0];
    while (cur != -1) {
      System.out.print(dat[cur] + " ");
      cur = nxt[cur];
    }
    System.out.println("\n");
  }

  static void insert_test() {
    System.out.println("****** insert_test *****");
    insert(0, 10); // 10(address=1)
    traverse();

    insert(0, 30); // 30(address=2) 10
    traverse();

    insert(2, 40); // 30 40(address=3) 10
    traverse();

    insert(1, 20); // 30 40 10 20(address=4)
    traverse();

    insert(4, 70); // 30 40 10 20 70(address=5)
    traverse();
  }

  static void erase_test() {
    System.out.println("****** erase_test *****");

    erase(1); // 30 40 20 70
    traverse();

    erase(2); // 40 20 70
    traverse();

    erase(4); // 40 70
    traverse();

    erase(5); // 40
    traverse();
  }

  public static void main(String[] args) {
    Arrays.fill(pre, -1);
    Arrays.fill(nxt, -1);

    insert_test();
    erase_test();
  }
}
