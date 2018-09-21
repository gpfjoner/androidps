package com.joner.mnbj.utils.tree;

import com.joner.mnbj.R;
import com.joner.mnbj.utils.Logger;
import com.joner.mnbj.utils.tree.annotation.TreeNodeId;
import com.joner.mnbj.utils.tree.annotation.TreeNodeLabel;
import com.joner.mnbj.utils.tree.annotation.TreeNodePid;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gpfei on 2018/8/21.
 * tree 工具类
 */

public class TreeHelper {
    /**
     * 泛型 将用户传入的数据转换
     *
     * @param datas 用户数据
     * @param <T>
     * @return 转换后的数据
     */
    public static <T> List<Node> convertDatas2Nodes(List<T> datas) throws IllegalAccessException {
        List<Node> nodes = new ArrayList<Node>();
        Node node = null;
        //循环遍历用户数据
        for (T t : datas) {
            int ip = -1;
            int pId = -1;
            String lable = null;
            node = new Node();
            Class aClass = t.getClass();
            Field[] fields = aClass.getDeclaredFields();
            for (Field file : fields) {
                if (file.getAnnotation(TreeNodeId.class) != null) {
                    file.setAccessible(true);
                    ip = file.getInt(t);
                }
                if (file.getAnnotation(TreeNodePid.class) != null) {
                    file.setAccessible(true);
                    pId = file.getInt(t);
                }
                if (file.getAnnotation(TreeNodeLabel.class) != null) {
                    file.setAccessible(true);
                    lable = (String) file.get(t);
                    Logger.e("TreeHelper", "TreeNodeLabel:" + lable);
                }

            }
            node = new Node(ip, pId, lable);
            nodes.add(node);

        }
        /**
         * 设置node间的节点关系
         *   用集合中的每一个node与剩余进行比较。
         */
        for (int i = 0; i < nodes.size(); i++) {

            Node childernNode  = nodes.get(i);

            for (int j = i + 1; j < nodes.size(); j++) {

                Node fatherNode = nodes.get(j);

                if (fatherNode.getpId() == childernNode.getId()) {

                    childernNode.getChildern().add(fatherNode);
                    fatherNode.setParent(childernNode);

                } else if (fatherNode.getId() == childernNode.getpId()) {

                    childernNode.getChildern().add(fatherNode);
                    fatherNode.setParent(childernNode);
                }

            }
        }

        for (Node n : nodes) {
            setNodeIcon(n);
        }
        Logger.e("TreeHelper", "TreeHelper nodes: :" + nodes.size() + ".nodes:");
        return nodes;
    }

    /**
     * 给Node 节点设置图标
     *
     * @param n
     */
    private static void setNodeIcon(Node n) {
        if (n.getChildern().size() > 0 && n.isExpand()) {
            n.setIcon(R.drawable.tree_ex);//打开图标
        } else if (n.getChildern().size() > 0 && !n.isExpand()) {
            n.setIcon(R.drawable.tree_ec);//关闭图标
        } else {
            n.setIcon(-1);//无图标
        }
    }

    public static <T> List<Node> getShortedNodes(List<T> datas, int defaultExpandLevel) throws IllegalAccessException {
        List<Node> nodes = convertDatas2Nodes(datas);
        List<Node> result = new ArrayList<Node>();
        //获取根节点
        List<Node> rootNodes = getRootNodes(nodes);
        for (Node node : rootNodes) {
            addNode(result, node, defaultExpandLevel, 1);
        }


        return result;
    }

    /**
     * 将该节点所有子节点加入进去
     *
     * @param result
     * @param node
     * @param defaultExpandLevel
     * @param currentLevel
     */
    private static void addNode(List<Node> result, Node node, int defaultExpandLevel, int currentLevel) {
        result.add(node);
        if (defaultExpandLevel > currentLevel) {
            node.setExpand(true);
        }
        if (node.isLeaf()) {
            return;
        }
        //递归调用
        for (int i = 0; i < node.getChildern().size(); i++) {
            addNode(result, node.getChildern().get(i), defaultExpandLevel, currentLevel + 1);
        }

    }

    /**
     * 获取根节点
     *
     * @param nodes
     * @return
     */
    private static List<Node> getRootNodes(List<Node> nodes) {
        List<Node> root = new ArrayList<>();
        for (Node r : nodes) {
            if (r.isRoot()) {
                root.add(r);
            }
        }
        return root;
    }

    /**
     * 获取显示节点信息集合
     *
     * @param nodes
     * @return
     */
    public static List<Node> filerVisibleNodes(List<Node> nodes) {
        List<Node> resultNode = new ArrayList<>();
        for (Node node : nodes) {
            if (node.isRoot() || node.isParentExpand()) {
                setNodeIcon(node);
                resultNode.add(node);
            }
        }
        return resultNode;
    }


}
