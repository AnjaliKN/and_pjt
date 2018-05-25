package com.example.opentrends003.mvp.view.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.opentrends003.mvp.R;

/**
 * Created by opentrends-003 on 9/2/18.
 */

public class UserViewHolder extends RecyclerView.ViewHolder {
    private TextView firstName;
    private TextView lastName;

    public UserViewHolder(View itemView) {
        super(itemView);
        firstName = itemView.findViewById(R.id.first_name);
        lastName = itemView.findViewById(R.id.last_name);

    }

    public TextView getFirstName() {
        return firstName;
    }

    public TextView getLastName() {
        return lastName;
    }
}
