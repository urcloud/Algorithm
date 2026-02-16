package B0x03;

import java.util.ArrayList;
import java.util.Collections;

public class B0x03_2 {
// C++의 STL vector가 Java에서는 ArrayList로 변환 가능
public static void main(String[] args) {

  // vector<int> v1(3,5)
  ArrayList<Integer> v1 =
      new ArrayList<>(Collections.nCopies(3, 5));

  System.out.println(v1.size());
  v1.add(7);   // push_back

  // vector<int> v2(2)
  ArrayList<Integer> v2 =
      new ArrayList<>(Collections.nCopies(2, 0));

  v2.add(1, 3);   // insert

  // vector<int> v3 = {1,2,3,4}
  ArrayList<Integer> v3 = new ArrayList<>();
  Collections.addAll(v3, 1, 2, 3, 4);

  v3.remove(2);   // erase

  // vector<int> v4;
  ArrayList<Integer> v4 = new ArrayList<>(v3); // 복사

  System.out.println("" +
      v4.get(0) +
      v4.get(1) +
      v4.get(2));

  v4.remove(v4.size() - 1); // pop_back
  v4.clear(); // clear
}
}