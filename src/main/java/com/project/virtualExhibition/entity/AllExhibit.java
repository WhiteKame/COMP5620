package com.project.virtualExhibition.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class AllExhibit extends Exhibit{

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
