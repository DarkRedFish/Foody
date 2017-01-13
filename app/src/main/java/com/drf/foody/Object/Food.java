package com.drf.foody.Object;

/**
 * Created by Dark on 10/12/2015.
 */
public class Food {
    private String name;
    private String price;
    private String description;
    private String image;
    private int     imageId;
    private int     littleImageId;
    private String id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public int getLittleImageId() {
        return littleImageId;
    }

    public void setLittleImageId(int littleImageId) {
        this.littleImageId = littleImageId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
