package B0x04;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

// C++에는 STL의 list가 있듯 Java에는 LinkedList가 있음
public class B0x04_3 {
  public static void main(String[] args) {

    LinkedList<Integer> L = new LinkedList<>(Arrays.asList(1, 2)); // 1 2

    ListIterator<Integer> t = L.listIterator(); // begin()
    int first = t.next(); // t가 1을 가리키도록 이동

    L.addFirst(10); // 10 1 2
    System.out.println(first); // 1

    L.addLast(5); // 10 1 2 5

    // insert(t, 6) → t 위치 앞에 삽입
    t.previous(); // 다시 1 위치로
    t.add(6);     // 10 6 1 2 5

    t.next(); // 1
    t.next(); // 2

    // erase(t)
    t.remove(); // 2 제거 → 10 6 1 5

    int nextVal = t.next(); // erase 이후 다음 원소 = 5
    System.out.println(nextVal);

    for (int i : L) System.out.print(i + " ");
    System.out.println();

    ListIterator<Integer> it = L.listIterator();
    while (it.hasNext())
      System.out.print(it.next() + " ");
  }
}