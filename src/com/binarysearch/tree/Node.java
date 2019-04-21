package com.binarysearch.tree;

import java.security.Key;

/**
 * Author:   ljl
 * Date :    2018-02-09
 * Description:二分搜索树节点Node，主要用于表示当前节点，以及左侧和右侧的Node节点。
 * History:
 *     <author>     <time>     <version>   <desc>
 */

public class Node {

    /** 节点中元素的键 */
    public int key;
    /** 节点中元素的值 */
    public int value;
    /** 左侧节点(左侧节点的值应小于根节点) */
    Node left;
    /** 右侧节点(右侧节点的值应大于根节点) */
    Node right;

    /**
     * 构造方法，创建一个新的节点时，需提供这个节点的key和value。
     * @param key 键
     * @param value 节点的值
     */
    public Node(int key,int value){
        this.key = key;
        this.value = value;
    }

    public void show() {
        System.out.println("---------------------------------------");
        System.out.println("Value:" + value);
        if (left != null && right != null) {
            System.out.println("LeftValue:" + left.value + " " + "RightValue:" + right.value);
            System.out.println("---------------------------------------");
            left.show();
            right.show();
        }else{
            if (left != null) {
                System.out.println("LeftKey:" + left.key);
                left.show();
            }
            if (right != null) {
                System.out.println("RightKey:" + right.key);
                right.show();
            }
        }
    }
}
