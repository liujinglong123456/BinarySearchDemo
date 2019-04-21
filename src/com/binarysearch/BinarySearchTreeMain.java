package com.binarysearch;
import com.binarysearch.tree.BinarySearchTree;
import com.binarysearch.tree.Node;

/**
 * 二分搜索树测试
 */
public class BinarySearchTreeMain {

    public static void main(String[] args) {
        //测试向二分搜索树中添加元素
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(28,28);
        binarySearchTree.insert(16,16);
        binarySearchTree.insert(30,30);
        binarySearchTree.insert(13,13);
        binarySearchTree.insert(22,22);
        binarySearchTree.insert(29,29);
        binarySearchTree.insert(100,100);
        binarySearchTree.insert(42,42);
        binarySearchTree.show();
        binarySearchTree.removeMin();
        System.out.println("删除后-----------------------------------");
        binarySearchTree.show();
        binarySearchTree.removeMax();

//        Node minimumNode = binarySearchTree.queryMinimumNode();
//        System.out.println("最小节点Key为:" + minimumNode.key + " " + "Value为:" + minimumNode.value);
//        Node maximumNode = binarySearchTree.queryMaximumNode();
//        System.out.println("最大节点Key为:" + maximumNode.key + " " + "Value为:" + maximumNode.value);
    }

    /**
     * 展示二分搜索树结构
     * @param tree
     */
    private static void show(BinarySearchTree tree) {
        tree.show();
    }

    /**
     * 测试元素查找
     * @param tree
     */
    private static void query(BinarySearchTree tree) {
        Node node = tree.query(53);
        if (node != null) {
            System.out.println("当前元素已找到，Key为:" + node.key + " " + "Value为:" + node.value);
        }else{
            System.out.println("元素未找到");
        }
    }

    private static void queryMinimumNode(BinarySearchTree tree) {
        Node minimumNode = tree.queryMinimumNode();
        System.out.println("最小节点Key为:" + minimumNode.key + " " + "Value为:" + minimumNode.value);
    }

    private static void queryMaximumNode(BinarySearchTree tree) {
        Node maximumNode = tree.queryMaximumNode();
        System.out.println("最大节点Key为:" + maximumNode.key + " " + "Value为:" + maximumNode.value);
    }
}
