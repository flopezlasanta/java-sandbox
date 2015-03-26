package org.teraflopx.jsandboox.struct;

import java.util.List;

import org.junit.Test;

public class BinarySearchTreeTest {

  @Test
  public void test() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.put(40).put(25).put(10).put(32).put(78);

    int min = bst.minimum();
    int max = bst.maximum();

    List<Integer> inOrderList = bst.traverseInOrder();
    assert (inOrderList.get(0) == min);
    assert (inOrderList.get(inOrderList.size() - 1) == max);

    List<Integer> preOrderList = bst.traversePreOrder();
    assert (preOrderList.get(0) == min);

    List<Integer> postOrderList = bst.traversePostOrder();
    assert (postOrderList.get(postOrderList.size() - 1) == max);
  }
}
