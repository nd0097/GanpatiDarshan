package com.example.ganpatidarshan.model;

import java.io.Serializable;

public class GanpatiItem implements Serializable {
    private final String title;
    private final String imageUrl;
    private final String description;
    private final String mapsUrl;

    public GanpatiItem(String title, String imageUrl, String description, String mapsUrl) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
        this.mapsUrl = mapsUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public String getMapsUrl() {
        return mapsUrl;
    }
}
