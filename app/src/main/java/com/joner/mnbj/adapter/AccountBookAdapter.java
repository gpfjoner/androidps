package com.joner.mnbj.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.joner.mnbj.R;
import com.joner.mnbj.entity.AccountBookEntity;

import java.util.ArrayList;

public class AccountBookAdapter extends RecyclerView.Adapter<AccountBookAdapter.AccountBookHolder> {

    private Context context;
    private ArrayList<AccountBookEntity> data;

    public AccountBookAdapter(Context context, ArrayList<AccountBookEntity> entities) {
        this.context = context;
        this.data = entities;
    }

    @NonNull
    @Override
    public AccountBookHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_accountbook_item, parent, false);
        return new AccountBookHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccountBookHolder holder, int position) {
        holder.setData(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class AccountBookHolder extends RecyclerView.ViewHolder {

        ImageView typeIcon;
        TextView accountContent;
        TextView accountNum;

        public AccountBookHolder(View itemView) {
            super(itemView);
            typeIcon = itemView.findViewById(R.id.type_icon);
            accountContent = itemView.findViewById(R.id.account_content);
            accountNum = itemView.findViewById(R.id.account_num);
        }

        public void setData(AccountBookEntity entity){
            accountContent.setText(entity.getContent());
            accountNum.setText("+"+entity.getMoney());
            Glide.with(context).load("https://upload-images.jianshu.io/upload_images/5315387-b4531ed8dddc89c0.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1000/format/webp")
                    .asBitmap().into(typeIcon);
        }
    }
}
