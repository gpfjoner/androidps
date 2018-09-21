package com.joner.mnbj.adapter;

import android.content.Context;
import android.provider.DocumentsContract;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.joner.mnbj.R;
import com.joner.mnbj.utils.Logger;
import com.joner.mnbj.utils.tree.Node;
import com.joner.mnbj.utils.tree.TreeHelper;
import com.joner.mnbj.utils.tree.TreeListAdapter;

import java.util.List;

/**
 * Created by gpfei on 2018/8/21.
 */

public class SimpleTreeListViewAdapter<T> extends TreeListAdapter<T> {

    public SimpleTreeListViewAdapter(Context context, List<T> datas, int defaltLevel, ListView mTree) throws IllegalAccessException {
        super(context, datas, defaltLevel, mTree);
    }

    @Override
    public View getConverView(Node node, int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.tree_list_item, parent, false);
            //  convertView = mInflater.inflate(R.layout.tree_list_item, null);
            viewHolder = new ViewHolder();
            viewHolder.mIcon = convertView.findViewById(R.id.ivicon);
            viewHolder.mTextCont = convertView.findViewById(R.id.tvtext);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (node.getIcon() == -1) {
            viewHolder.mIcon.setVisibility(View.INVISIBLE);
        } else {
            viewHolder.mIcon.setVisibility(View.VISIBLE);
            viewHolder.mIcon.setImageResource(node.getIcon());
        }
        viewHolder.mTextCont.setText(node.getName());
        Logger.e("getConverView", "getName:" + node.getName() + ",node.getId():" + node.getId() + ",node.getpId():" + node.getpId());
        return convertView;
    }

    /**
     * 动态插入节点
     *
     * @param position
     * @param s
     */
    public void addExtraNode(int position, String s) {
        Node node = mVisibleNodes.get(position);
        int i = mAllNodes.indexOf(node);
        //存储当前的插入的数据

        Node extraNode = new Node(-1, node.getId(), s);
        extraNode.setParent(node);
        node.getChildern().add(extraNode);
        mAllNodes.add(i + 1, extraNode);

        mVisibleNodes = TreeHelper.filerVisibleNodes(mAllNodes);
        notifyDataSetChanged();


    }

    private class ViewHolder {
        ImageView mIcon;
        TextView mTextCont;

    }
}
