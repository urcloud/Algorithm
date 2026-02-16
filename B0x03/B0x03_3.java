package B0x03;

import java.util.ArrayList;
import java.util.Collections;

public class B0x03_3 {
public static void main(String[] args) {
  ArrayList<Integer> v1 = new ArrayList<>();
  Collections.addAll(v1, 1,2,3,4,5,6);

// 1. range-based for
  for(int e : v1)
    System.out.print(e + " ");

// 2. index for
  for(int i = 0; i < v1.size(); i++)
    System.out.print(v1.get(i) + " ");
}
}
