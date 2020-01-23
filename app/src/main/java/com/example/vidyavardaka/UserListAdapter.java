package com.example.vidyavardaka;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ListViewHolder> {
Context context;
ArrayList<User> userList;
UserListAdapter(Context context,ArrayList<User> userList)
{
    this.context=context;
    this.userList=userList;

}
    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view= LayoutInflater.from(context).inflate(R.layout.user_list_temp,parent,false);


        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
    User user=userList.get(position);
        Log.d("Name",user.getName());
    holder.textView.setText(user.getName());
    holder.imageView.setImageDrawable(context.getResources().getDrawable(user.getUserImg()));

    }

    @Override
    public int getItemCount() {
    Log.d("Size",userList.size()+"");
    return userList.size();

    }

    class ListViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        ImageView imageView;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textViewListName);
            imageView=itemView.findViewById(R.id.imageViewUsericon);
        }
    }

}



