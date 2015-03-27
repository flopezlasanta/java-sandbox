package org.teraflopx.jsandboox.struct;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class BinarySearchTreeTest {

  @Test
  public void test() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.put(40).put(25).put(10).put(32).put(78);

    int min = bst.minimum();
    assertEquals(min, 10);
    System.out.println("Min: " + min);

    int max = bst.maximum();
    assertEquals(max, 78);
    System.out.println("Max: " + max);

    List<Integer> inOrderList = bst.traverseInOrder();
    System.out.println("InOrder: " + inOrderList);
    assertTrue(inOrderList.get(0) == min);
    assertTrue(inOrderList.get(inOrderList.size() - 1) == max);

    List<Integer> preOrderList = bst.traversePreOrder();
    System.out.println("PreOrder: " + preOrderList);
    assertTrue(preOrderList.get(preOrderList.size() - 1) == max);

    List<Integer> postOrderList = bst.traversePostOrder();
    System.out.println("PostOrder: " + postOrderList);
    assertTrue(postOrderList.get(0) == min);
  }
}
