package com.example.opentrends003.mvp.view.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.opentrends003.mvp.R;
import com.example.opentrends003.mvp.model.UserModel;
import com.example.opentrends003.mvp.view.adapter.viewholder.UserViewHolder;

import java.util.List;

/**
 * Created by opentrends-003 on 9/2/18.
 */

 public class UserAdapter extends RecyclerView.Adapter<UserViewHolder>{
    List<UserModel> list;
    public UserAdapter(List<UserModel> list) {
        this.list = list;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_item, parent,false);

        UserViewHolder recyclerViewHolder = new UserViewHolder(layoutView);

        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        UserModel item=list.get(position);
        holder.getFirstName().setText(item.getFirstName());
        holder.getLastName().setText(item.getLastName());
    }

    @Override
    public int getItemCount() {
        return  list==null?0:list.size();
    }

    public void setData(List<UserModel> data) {
        this.list = data;
        notifyDataSetChanged();
    }
}
