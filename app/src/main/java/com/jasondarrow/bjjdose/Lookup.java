package com.jasondarrow.bjjdose;

import java.util.List;

/**
 * Created by darrowj on 12/30/17.
 */

public class Lookup {

    String id;
    String title;
    List<String> names;

    public Lookup(String id, String title, List<String> names) {
        this.title = title;
        this.names = names;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }
}
