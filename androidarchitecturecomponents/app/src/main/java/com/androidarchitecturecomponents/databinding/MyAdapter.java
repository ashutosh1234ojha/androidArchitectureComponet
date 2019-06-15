package com.androidarchitecturecomponents.databinding;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class MyAdapter extends  RecyclerView.Adapter<MyAdapter.BindingViewHolder>  {


    @NonNull
    @Override
    public BindingViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull BindingViewHolder bindingViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class BindingViewHolder extends RecyclerView.ViewHolder {
//        private final com.androidarchitecturecomponents.databinding.ItemBinding mBinding;

        public BindingViewHolder(View v) {
            super(v);
//            super(mBinding.getRoot());
//            mBinding = binding;
        }
    }
}
