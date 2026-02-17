package B0x04;

import java.util.Arrays;

// 야매 연결 리스트
// 제일 마지막 원소를 O(N)에 확인할 수 있는데, O(1)에 확인할 수 있게끔 고민해보기
public class B0x04_1 {

  // 원소를 배열로 관리하고 pre와 nxt에 이전, 다음 원소의 포인터 대신 배열 상의 인덱스를 저장하는 방식으로 구현한 연결 리스트
  // 메모리 누수의 문제 때문에 실무에서는 절대 쓸 수 없는 방식
  // dat[i]는 i번지 원소의 값, pre[i]는 i번지 원소에 대해 이전 원소의 인덱스, nxt[i]는 다음 원소의 인덱스
  // pre나 nxt의 값이 -1이면 해당 원소의 이전, 다음 원소가 존재하지 않는다는 의미
  // unused는 현재 사용되지 않는 인덱스, 새로운 원소가 들어갈 수 있는 인덱스, 원소가 추가된 이후에는 1씩 증가됨
  // 0번지는 연결 리스트의 시작 원소로 고정되어 있음, 0번지는 값이 들어가지 않고 단지 시작점을 나타내기 위한 dummy node
  // 삽입과 삭제 등의 기능을 구현할 때 원소가 아예 없는 경우에 대한 예외처리를 해야 하는데, 관념적으로 dummy node를 두면 예외처리가 덜 번거로움
  // 길이가 필요하다면 따로 len 변수를 두고 원소가 추가될 때 1 증가시키고 제거될 때 1 감소시키면 됨
  static final int MX = 1000005;
  static int[] dat = new int[MX];
  static int[] pre = new int[MX];
  static int[] nxt = new int[MX];
  static int unused = 1;

  // insert, erase 함수에 공통으로 있는 인자인 addr은 앞에서 말한 각 원소의 주소, 배열 상에서 몇 번지인지를 의미함
  // unused가 가리키는 곳이 새로운 원소가 들어갈 자리
  // 새 원소의 pre 값에 삽입할 위치의 주소를 대입해야 함
  // 새 원소의 nxt 값에 삽입할 위치의 nxt 값을 대입해야 함
  // 삽입할 위치의 nxt와 삽입할 위치의 다음 원소의 pre를 새 원소로 바꿔야 함
  // unused 칸을 다 썼으니 unused를 1 증가시켜서 다음 insert에는 비어있는 번지를 쓸 수 있게끔 해야 함
  static void insert(int addr, int num) {
    dat[unused] = num;
    pre[unused] = addr;
    nxt[unused] = nxt[addr];

    // 맨 마지막 원소의 뒤에 새 원소를 추가하는 상황이라면 삽입할 위치의 다음 원소가 존재하지 않음
    // 그런데도 pre[nxt[addr]]=unused; 로 써버리면 pre[-1]에 접근할 수 있음
    // 따라서 nxt[addr]가 -1이 아닐 때에만 pre[nxt[addr]에 unused를 대입하도록 했음
    if (nxt[addr] != -1)
      pre[nxt[addr]] = unused;

    nxt[addr] = unused;
    unused++;
  }

  // 삭제하고 싶은 원소의 이전 위치의 nxt를 삭제할 위치의 nxt로 변경
  // 다음 위치의 pre를 삭제할 위치의 pre로 변경
  // 정작 삭제할 위치의 dat, pre, nxt는 전혀 건드리지 않음, 앞으로 이 값들은 아무 의미가 없어짐, 앞으로 그 어떤 nxt나 pre도 제거된 원소의 번지를 가리키지 않기 때문
  // 이런 상황이니까 굳이 dat, nxt, pre 값을 -1과 같은 다른 값으로 덮을 필요가 없고 그냥 내버려두면 됨
  // 이러한 구현 방법 때문에 이 야매 연결 리스트에서는 제거된 원소가 프로그램이 종료될 때까지 메모리를 점유하고 있게 됨, 실무에서는 구현 불가능한 이유
  static void erase(int addr) {
    nxt[pre[addr]] = nxt[addr];
    // pre[addr]이 -1인지는 체크를 하지 않아도 되는데 nxt[addr]이 -1인지는 체크를 해야 하는 이유
    // dummy node의 존재로 인해 그 어떤 원소를 지우더라도 pre[addr]은 -1이 아님이 보장되지만 nxt[addr]는 제일 마지막 원소를 지우는 상황에서 값이 -1일 수 있기 때문에 그럼
    if (nxt[addr] != -1)
      pre[nxt[addr]] = pre[addr];
  }

  // traverse 함수에서는 연결 리스트의 모든 원소들을 출력
  // 연결 리스트에서는 0번지에서 출발해 nxt에 적힌 값을 보고 계속 넘어가면서 dat을 출력하는 방식으로 구현해야 함
  // cur라는 변수에 각 원소들의 주소가 담겨서 이동하는 방식
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
