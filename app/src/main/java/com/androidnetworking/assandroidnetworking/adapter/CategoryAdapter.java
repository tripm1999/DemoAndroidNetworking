package com.androidnetworking.assandroidnetworking.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidnetworking.assandroidnetworking.R;
import com.androidnetworking.assandroidnetworking.modelPost.Category;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    private static ClickListener clickListener;
    ArrayList<Category> categories;
    Context context;

    public CategoryAdapter(ArrayList<Category> categories, Context context) {
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View item = layoutInflater.inflate(R.layout.item_cate, viewGroup, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.img_Item.setImageResource(categories.get(i).getHinhAnh());
        viewHolder.tvNameCategory.setText(categories.get(i).getNameCategory());
        viewHolder.tvSoPhanTu.setText(categories.get(i).getSoPhanTu());
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView img_Item;
        TextView tvNameCategory;
        TextView tvSoPhanTu;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_Item = itemView.findViewById(R.id.imgCategory);
            tvNameCategory = itemView.findViewById(R.id.tvNameCategory);
            tvSoPhanTu = itemView.findViewById(R.id.tvSoPhanTu);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(getAdapterPosition(), v);
        }
    }

    public void setOnItemClickListener(CategoryAdapter.ClickListener clickListener) {
        CategoryAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
    }
}
