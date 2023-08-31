package com.project.virtualExhibition.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="collect")
public class Collect implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private Integer user_id;
    private Integer art_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getArt_id() {
        return art_id;
    }

    public void setArt_id(Integer art_id) {
        this.art_id = art_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Collect)) return false;
        Collect collect = (Collect) o;
        return Objects.equals(getId(), collect.getId()) && Objects.equals(getUser_id(), collect.getUser_id()) && Objects.equals(getArt_id(), collect.getArt_id());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser_id(), getArt_id());
    }

    @Override
    public String toString() {
        return "Collect{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", art_id=" + art_id +
                '}';
    }
}
