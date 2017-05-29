package com.example.android.soundtrack;


class SongsOrder {

    private int ImageId;

    private String Name;


    SongsOrder(int imageId, String name) {
        this.ImageId = imageId;
        this.Name = name;
    }


    int putTheImage() {
        return ImageId;
    }

    String putTheTitle() {
        return Name;
    }

}
