package com.gessica.arithmetic.tree20_09;

public class Node {
	public int value;
    public Node left;
    public Node right;

    public Node() {
        this(0);
    }

    public Node(int v) {
        this.value = v;
        this.left = null;
        this.right = null;
    }
}
