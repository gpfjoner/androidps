package com.joner.mnbj.utils.tree;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.joner.mnbj.utils.tree.Node;
import com.joner.mnbj.utils.tree.TreeHelper;

import java.util.List;

/**
 * Created by gpfei on 2018/8/21.
 */

public abstract class TreeListAdapter<T> extends BaseAdapter {

    protected Context mContext;
    protected List<Node> mAllNodes;
    protected List<Node> mVisibleNodes;
    protected LayoutInflater mInflater;
    protected ListView mTree;

    /**
     * node 点击事件
     * 监听
     */
    public interface OnTreeNodeClickListener {
        void onClick(Node node, int position);
    }

    private OnTreeNodeClickListener mListener;

    public void setOnTreeClickListener(OnTreeNodeClickListener mListener) {
        this.mListener = mListener;
    }

    public TreeListAdapter(Context context, List<T> datas, int defaltLevel, ListView mTree) throws IllegalAccessException {
        mContext = context;
        mAllNodes = TreeHelper.getShortedNodes(datas, defaltLevel);
        mVisibleNodes = TreeHelper.filerVisibleNodes(mAllNodes);
        mInflater = LayoutInflater.from(context);
        this.mTree = mTree;
        mTree.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                expandOrClosed(position);
                if (mListener != null) {
                    mListener.onClick(mVisibleNodes.get(position), position);
                }
            }
        });
    }

    /**
     * 设置点击时，节点的打开或者关闭
     *
     * @param position
     */
    private void expandOrClosed(int position) {
        Node node = mVisibleNodes.get(position);
        if (node != null) {
            if (node.isLeaf()) {
                return;
            }
            node.setExpand(!node.isExpand());//设置该节点的点击 反转
            //刷新可见列表
            mVisibleNodes = TreeHelper.filerVisibleNodes(mAllNodes);
            notifyDataSetChanged();
        }

    }

    @Override
    public int getCount() {
        return mVisibleNodes.size();
    }

    @Override
    public Object getItem(int position) {
        return mVisibleNodes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Node node = mVisibleNodes.get(position);
        convertView = getConverView(node, position, convertView, parent);
        //设置内边距
        convertView.setPadding(node.getLevel() * 30, 3, 3, 3);
        return convertView;
    }

    public abstract View getConverView(Node node, int position, View convertView, ViewGroup parent);
}
