package com.example.vidyavardaka;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    UserListAdapter listAdapter;
    ArrayList<User> usersList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_list);
        recyclerView=findViewById(R.id.list_user);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        loadData();
        listAdapter=new UserListAdapter(this,usersList);
        recyclerView.setAdapter(listAdapter);

    }

    private void loadData() {
        usersList=new ArrayList<>();
    User users=new User();
    users.setUserImg(R.drawable.ic_launcher_background);
    users.setName("Android");
        User users1=new User();
        users1.setUserImg(R.drawable.ic_stat_name);
        users1.setName("Java");
        User users2=new User();
        users2.setUserImg(R.drawable.ic_launcher_background);
        users2.setName("Python");
        User users4=new User();
        users4.setUserImg(R.drawable.ic_stat_name);
        users4.setName("Kotlin");
        usersList.add(users);
        usersList.add(users1);
        usersList.add(users2);
        usersList.add(users4);

    }
}
