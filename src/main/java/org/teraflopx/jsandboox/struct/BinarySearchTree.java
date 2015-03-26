package org.teraflopx.jsandboox.struct;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

  private Node root;

  public BinarySearchTree put(int value) {
    if (root == null) {
      root = new Node(value);
      return this;
    }

    put(root, new Node(value));
    return this;
  }

  private void put(Node parent, Node node) {
    if (parent.getKey() == node.getKey())
      return;

    if (parent.getKey() > node.getKey()) {
      if (parent.getLeft() == null)
        parent.setLeft(node);
      else
        put(parent.getLeft(), node);
    } else if (parent.getKey() < node.getKey()) {
      if (parent.getRight() == null)
        parent.setRight(node);
      else
        put(parent.getRight(), node);
    }
  }


  public int minimum() {
    Node node = root;
    while (node.getLeft() != null)
      node = node.getLeft();
    return node.getKey();
  }

  public int maximum() {
    Node node = root;
    while (node.getRight() != null)
      node = node.getRight();
    return node.getKey();
  }

  public List<Integer> traverseInOrder() {
    List<Integer> list = new ArrayList<Integer>();
    if (root != null)
      traverseInOrder(list, root);
    return list;
  }

  public List<Integer> traversePreOrder() {
    List<Integer> list = new ArrayList<Integer>();
    if (root != null)
      traversePreOrder(list, root);
    return list;
  }

  public List<Integer> traversePostOrder() {
    List<Integer> list = new ArrayList<Integer>();
    if (root != null)
      traversePostOrder(list, root);
    return list;
  }

  private void traverseInOrder(List<Integer> list, Node node) {
    if (node == null)
      return;

    traverseInOrder(list, node.getLeft());
    list.add(node.getKey());
    traverseInOrder(list, node.getRight());
  }

  private void traversePreOrder(List<Integer> list, Node node) {
    if (node == null)
      return;

    list.add(node.getKey());
    traversePreOrder(list, node.getLeft());
    traversePreOrder(list, node.getRight());
  }

  private void traversePostOrder(List<Integer> list, Node node) {
    if (node == null)
      return;

    traversePostOrder(list, node.getLeft());
    traversePostOrder(list, node.getRight());
    list.add(node.getKey());
  }

  public class Node {
    private int key;
    private Node left;
    private Node right;

    public Node(int key) {
      this.key = key;
    }

    public int getKey() {
      return key;
    }

    public void setLeft(Node left) {
      this.left = left;
    }

    public Node getLeft() {
      return left;
    }

    public void setRight(Node right) {
      this.right = right;
    }

    public Node getRight() {
      return right;
    }
  }
}
