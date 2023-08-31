package com.project.virtualExhibition.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "arts")
public class Arts implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String image;
    private Integer status;
    private String content;

    private String artist;

    private String year;

    public Arts() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Arts(Integer id, String title, String image, Integer status, String content, String artist, String year) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.status = status;
        this.content = content;
        this.artist = artist;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Arts{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image='" + image + '\'' +
                ", status=" + status +
                ", content='" + content + '\'' +
                ", artist='" + artist + '\'' +
                ", year='" + year + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Arts)) return false;
        Arts arts = (Arts) o;
        return Objects.equals(getId(), arts.getId()) && Objects.equals(getTitle(), arts.getTitle()) && Objects.equals(getImage(), arts.getImage()) && Objects.equals(getStatus(), arts.getStatus()) && Objects.equals(getContent(), arts.getContent()) && Objects.equals(getArtist(), arts.getArtist()) && Objects.equals(getYear(), arts.getYear());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getImage(), getStatus(), getContent(), getArtist(), getYear());
    }

    //    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Arts)) return false;
//
//        Arts arts = (Arts) o;
//
//        if (getId() != null ? !getId().equals(arts.getId()) : arts.getId() != null) return false;
//        if (getTitle() != null ? !getTitle().equals(arts.getTitle()) : arts.getTitle() != null) return false;
//        if (getImage() != null ? !getImage().equals(arts.getImage()) : arts.getImage() != null) return false;
//        if (getStatus() != null ? !getStatus().equals(arts.getStatus()) : arts.getStatus() != null) return false;
//        return getContent() != null ? getContent().equals(arts.getContent()) : arts.getContent() == null;
//    }
//
//    @Override
//    public int hashCode() {
//        int result = getId() != null ? getId().hashCode() : 0;
//        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
//        result = 31 * result + (getImage() != null ? getImage().hashCode() : 0);
//        result = 31 * result + (getStatus() != null ? getStatus().hashCode() : 0);
//        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
//        return result;
//    }
}
