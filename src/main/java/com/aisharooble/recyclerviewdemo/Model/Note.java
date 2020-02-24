package com.aisharooble.recyclerviewdemo.Model;

import java.io.Serializable;

public class Note implements Serializable {

    private static final long SerialVersionUID = 42L; //safer to manually assign a number

    public String headline;
    public String body;
    private boolean liked = false;

    public Note(String headline, String body) {
        this.headline = headline;
        this.body = body;
    }

    public void toggleLike() {
        liked = !liked;
    }

    public boolean getLiked() {
        return liked;
    }

}
