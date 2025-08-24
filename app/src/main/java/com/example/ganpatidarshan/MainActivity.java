package com.example.ganpatidarshan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.ganpatidarshan.databinding.ActivityMainBinding;
import com.example.ganpatidarshan.model.GanpatiItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GanpatiAdapter.OnItemClickListener {

    private ActivityMainBinding binding;
    private GanpatiAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setTitle("Ganpati Darshan");

        List<GanpatiItem> data = buildData();

        adapter = new GanpatiAdapter(data, this);
        binding.recycler.setLayoutManager(new GridLayoutManager(this, 2));
        binding.recycler.setAdapter(adapter);
    }

    private List<GanpatiItem> buildData() {
        List<GanpatiItem> list = new ArrayList<>();

        list.add(new GanpatiItem(
                "Lalbaugcha Raja",
                "https://upload.wikimedia.org/wikipedia/commons/thumb/7/71/Bappa.jpg/250px-Bappa.jpg",
                "The most famous Ganpati in Mumbai, known as the \"King of Lalbaug.\" Millions of devotees visit every year to seek blessings.",
                "https://goo.gl/maps/9WjvhbbtGCF2"
        ));

        list.add(new GanpatiItem(
                "Ganesh Galli (Mumbaicha Raja)",
                "https://pbs.twimg.com/media/GWy8ZshaQAAMS4V.jpg",
                "Established in 1928, this Ganpati is famous for its grand themes and decorations every year.",
                "https://goo.gl/maps/zTQ2mgqp5Nv"
        ));

        list.add(new GanpatiItem(
                "Andhericha Raja",
                "https://imgmediagumlet.lbb.in/media/2024/09/66d80d3371a2387254769e7c_1725435187191.jpg",
                "The \"King of Andheri,\" known for unique visarjan dates and cultural events. Unlike others, it is not visarjit on Anant Chaturdashi.",
                "https://goo.gl/maps/NGQJ4mVcvXs"
        ));

        list.add(new GanpatiItem(
                "Chinchpoklicha Chintamani",
                "https://i.pinimg.com/736x/ac/d1/eb/acd1eb4a295b85329dbaecf2f1fe9671.jpg",
                "One of the oldest Sarvajanik Ganesh Mandals in Mumbai, established in 1920. Known for simplicity and strong devotion.",
                "https://goo.gl/maps/ohztjFzJQfK2"
        ));

        list.add(new GanpatiItem(
                "Khetwadicha Ganraj",
                "https://wonderfulmumbai.com/wp-content/uploads/2014/09/Khetwadicha_Ganraj_Lane_12_2014_4.jpg",
                "Famous for its magnificent and tallest idols (some over 40 feet). Located in Khetwadi lanes, Girgaon.",
                "https://goo.gl/maps/DeDP6mDGD7L2"
        ));

        list.add(new GanpatiItem(
                "GSB Seva Mandal Ganpati (King’s Circle)",
                "https://globalprimenews.com/wp-content/uploads/2024/08/IMG-20240825-WA0011.jpg",
                "Known as the richest Ganpati of Mumbai, adorned with real gold and silver ornaments worth crores.",
                "https://goo.gl/maps/cjRYTLVGukK2"
        ));

        return list;
    }

    @Override
    public void onItemClick(GanpatiItem item) {
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra(DetailActivity.EXTRA_ITEM, item);
        startActivity(i);
    }
}
