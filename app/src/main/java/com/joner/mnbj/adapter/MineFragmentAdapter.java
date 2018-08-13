package com.joner.mnbj.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.joner.mnbj.R;

/**
 * Created by gpfei on 2018/8/13.
 */

public class MineFragmentAdapter extends BaseAdapter {

    private String[] msgInfor;
    private Context context;
    private int[] images = new int[]{R.drawable.one, R.drawable.two, R.drawable.three, R.drawable.four, R.drawable.five};

    public MineFragmentAdapter(String[] msgInfor, Context context) {
        this.msgInfor = msgInfor;
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return msgInfor[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewholder viewholder = null;
        if (convertView == null) {
            viewholder = new MyViewholder();
            convertView = LayoutInflater.from(context).inflate(R.layout.mine_fragment_item, null);

            viewholder.title = convertView.findViewById(R.id.ivItemIcon);
            viewholder.tvItemInfor = convertView.findViewById(R.id.tvItemInfor);
            convertView.setTag(viewholder);
        } else {
            viewholder = (MyViewholder) convertView.getTag();
        }
        viewholder.title.setImageResource(images[position]);
        viewholder.tvItemInfor.setText(msgInfor[position]);
        return convertView;
    }

    class MyViewholder {
        ImageView title;
        TextView tvItemInfor;

    }

}
