package com.binarysearch.tree;


/**
 * Author:   ljl
 * Date :    2018-02-09
 * Description:二分搜索树
 * History:
 *     <author>     <time>     <version>   <desc>
 */

public class BinarySearchTree {

    /** 二分搜索树的根节点 */
    private Node root = null;
    /** 用于统计整个二分搜索树中的节点Node数量 */
    private int count = 0;

    /**
     * 向二分搜索树中插入元素
     * @param key 元素的key
     * @param value 元素的值
     */
    public void insert(int key,int value){
        root = insert(root,key,value);
    }

    /**
     * 根据Key来查找节点Node
     * @param key
     * @return 如果找到则返回Node，否则返回空
     */
    public Node query(int key) {
        return query(root,key);
    }

    /**
     * 根据Key查找元素
     * @param node
     * @param key
     * @return
     */
    private Node query(Node node,int key){
        if (node == null) {
            //如果当前节点不存在，就返回空。
            return null;
        }
        if (key == node.key) {
            //如果此时找到了，就返回node。
            return node;
        }
        else if (key < node.key) {
            //如果key小于当前节点，则从当前节点的左侧节点进行递归查找。
            return query(node.left,key);
        }else{
            //如果key大于当前节点，则从当前节点的右侧节点进行递归查找。
            return query(node.right,key);
        }
    }

    /**
     * 向二分搜索树根节点中插入元素
     * @param node 根节点
     * @param key 元素的key
     * @param value 元素的值
     * @return
     */
    private Node insert(Node node,int key,int value){
        if (node == null) {
            count ++;
            //如果这时二分搜索树的根节点为空。
            //那么，就将当前添加的元素，作为这个二分树的顶级根节点。
            return new Node(key,value);
        }
        if (value == node.value) {
            //处理插入的元素，值相同的情况下，进行替换
            node.value = value;
            return node;
        }
        else if (value < node.value){
            //处理插入的元素小于当前节点的值
            //小于当前节点时，插入的元素需要与当前节点中的左侧元素进行比较
            //因此，这是递归过程，递归调用当前方法，并传入节点left以及插入的元素信息。
            node.left = insert(node.left,key,value);
            return node;
        }else{
            //处理插入的元素大于当前节点的值
            //大于当前节点时，插入的元素需要与当前节点中的右侧元素进行比较
            //同样是递归过程，递归调用当前方法，并传入节点right以及插入的元素信息。
            node.right = insert(node.right,key,value);
            return node;
        }
    }

    /**
     * 删除最小节点的元素
     * @return 返回删除后新的节点的根
     */
    public Node removeMin() {
        if (root != null) {
            return removeMin(root);
        }
        return null;
    }

    /**
     * 删除最大节点的元素
     * @return 返回删除后新的节点的根
     */
    public Node removeMax() {
        if (root != null) {
            return removeMax(root);
        }
        return null;
    }

    /**
     * 删除以Node为根的树中的最小节点
     * @param node
     * @return 返回删除后新的节点的根
     */
    private Node removeMin(Node node) {
        if (node.left == null) {
            Node right = node.right;
            count--;
            return right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    /**
     * 删除以Node为根的树中的最大节点
     * @param node
     * @return 返回删除后新的节点的根
     */
    private Node removeMax(Node node) {
        if (node.right == null) {
            Node left = node.left;
            count--;
            return left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    /**
     * 查找二分搜索树中的最小节点
     * @return
     */
    public Node queryMinimumNode() {
        return queryMinimumNode(root);
    }

    private Node queryMinimumNode(Node node) {
        if (node.left == null) {
            //如果这时已经到达最左侧子节点，其左侧已经不再有子节点了
            //此时该节点就是最小节点
            return node;
        }
        //递归继续向左侧的子节点进行深度查找。
        return queryMinimumNode(node.left);
    }

    /**
     * 查找二分搜索树中的最大节点
     * @return
     */
    public Node queryMaximumNode() {
        return queryMaximumNode(root);
    }

    private Node queryMaximumNode(Node node) {
        if (node.right == null) {
            //如果这时已经到达最右侧子节点，其右侧已经不再有子节点了
            //此时该节点就是最大节点
            return node;
        }
        //递归继续向右侧的子节点进行深度查找。
        return queryMaximumNode(node.right);
    }

    public void show() {
        root.show();
    }

    /**
     * 获取当前二分搜索树中的节点数量
     * @return
     */
    public int size() {
        return count;
    }

    /**
     * 二分搜索树是否为空
     * @return
     */
    public boolean isEmpty() {
        return count == 0 || root == null;
    }
}
