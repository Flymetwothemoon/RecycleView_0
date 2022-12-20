package com.example.recycleview_0;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
     List<idol>mIdols = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        RecyclerView recyclerView = findViewById(R.id.recycle_view_0);
        LinearLayoutManager linearLayout = new LinearLayoutManager(this);
        linearLayout.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayout);
        Adapter_0 adapter_0 = new Adapter_0(mIdols);
        // 增加分割线
        recyclerView.addItemDecoration(new LinearDividerDecoration(RecyclerView.VERTICAL));
        recyclerView.setAdapter(adapter_0);
        adapter_0.setOnItemClickListener(new Adapter_0.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(MainActivity.this,"这是第"+String.valueOf(position)+"条",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClick(View view, int position) {
                new AlertDialog.Builder(MainActivity.this).setTitle("确定删除吗").setNegativeButton("取消",null).setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this,"删除第"+position+"个",Toast.LENGTH_SHORT).show();
                        mIdols.remove(position);
                        adapter_0.notifyDataSetChanged();
                    }
                }).show();
            }
        });

    }
    private void init(){
        for(int i=0;i<200;i++){
            idol idol = new idol();
            idol.name=String.valueOf(i);
            mIdols.add(idol);
        }
    }


}