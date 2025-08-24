package com.example.ganpatidarshan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ganpatidarshan.databinding.ItemTileBinding;
import com.example.ganpatidarshan.model.GanpatiItem;

import java.util.List;

public class GanpatiAdapter extends RecyclerView.Adapter<GanpatiAdapter.VH> {

    public interface OnItemClickListener {
        void onItemClick(GanpatiItem item);
    }

    private final List<GanpatiItem> items;
    private final OnItemClickListener listener;

    public GanpatiAdapter(List<GanpatiItem> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTileBinding binding = ItemTileBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new VH(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        GanpatiItem item = items.get(position);
        holder.bind(item, listener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class VH extends RecyclerView.ViewHolder {
        private final ImageView image;
        private final TextView title;
        private final View root;

        public VH(ItemTileBinding binding) {
            super(binding.getRoot());
            root = binding.getRoot();
            image = binding.image;
            title = binding.title;
        }

        public void bind(GanpatiItem item, OnItemClickListener listener) {
            title.setText(item.getTitle());

            Glide.with(image.getContext())
                    .load(item.getImageUrl())
                    .placeholder(android.R.color.darker_gray)
                    .error(android.R.color.darker_gray)   // shows gray if load fails
                    .centerCrop()
                    .into(image);

            root.setOnClickListener(v -> {
                if (listener != null) listener.onItemClick(item);
            });
        }
    }
}
