package com.example.ganpatidarshan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.ganpatidarshan.databinding.ActivityDetailBinding;
import com.example.ganpatidarshan.model.GanpatiItem;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_ITEM = "extra_item";

    private ActivityDetailBinding binding;
    private GanpatiItem item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        item = (GanpatiItem) getIntent().getSerializableExtra(EXTRA_ITEM);
        if (item == null) {
            finish();
            return;
        }

        setTitle(item.getTitle());

        binding.title.setText(item.getTitle());
        binding.description.setText(item.getDescription());

        Glide.with(this)
                .load(item.getImageUrl())
                .centerCrop()
                .into(binding.image);

        binding.openMapsButton.setOnClickListener(v -> openInGoogleMaps(item.getMapsUrl()));
    }

    private void openInGoogleMaps(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        intent.setPackage("com.google.android.apps.maps");
        try {
            startActivity(intent);
        } catch (Exception e) {
            // Fallback to any browser if Maps app not available
            Intent fallback = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(fallback);
        }
    }
}
