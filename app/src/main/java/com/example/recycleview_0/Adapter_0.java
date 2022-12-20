package com.example.recycleview_0;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter_0 extends RecyclerView.Adapter<Adapter_0.Adapter_0Holder> implements View.OnClickListener, View.OnLongClickListener {
    int i = 0;
    int n = 0;
    private OnItemClickListener onItemClickListener;
    public Adapter_0(List<idol> idols) {
        mIdols = idols;
    }
    private List<idol>mIdols;
    @NonNull
    @Override
    public Adapter_0.Adapter_0Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        ++n;
        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
        Log.d("HIHI","onCreateViewHolder"+n);
        return new Adapter_0Holder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Adapter_0.Adapter_0Holder holder, int position) {
    idol idol = mIdols.get(position);
    holder.itemView.setTag(position);
    holder.bind(idol.getName());
    ++i;
        Log.d("TAG","onBindViewHolder"+i);
    }

    @Override
    public int getItemCount() {
        return mIdols.size();
    }

    @Override
    public void onClick(View v) {
        if(onItemClickListener!=null){
            onItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if(onItemClickListener!=null){
            onItemClickListener.onItemLongClick(v,(int)v.getTag());
        }
        return false;
    }

    public interface OnItemClickListener
    {
        void onItemClick(View view, int position);
        void onItemLongClick(View view,int position);

    }
    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener)
    {
        this.onItemClickListener = mOnItemClickListener;
    }


    public class Adapter_0Holder extends RecyclerView.ViewHolder{
        TextView mTextView ;
        public Adapter_0Holder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.text_view);
        }
        public void bind(String text){
            mTextView.setText(text);
        }
    }
}