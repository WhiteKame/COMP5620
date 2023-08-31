package com.project.virtualExhibition.entity;

//Implement interfaces to make classes serialized for storage and data transfer
import javax.persistence.*;

@Entity
@Table(name="userinfo")
public class User {

    // Set properties
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String username;
    private String password;
    private String salt;
    private String phone;
    private String email;

    // get, set methods
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //overwrite equals and hashcode() methods
    //To make sure that the object is unique
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (!getId().equals(user.getId())) return false;
        if (!getUsername().equals(user.getUsername())) return false;
        if (!getPassword().equals(user.getPassword())) return false;
        if (!getSalt().equals(user.getSalt())) return false;
        if (!getPhone().equals(user.getPhone())) return false;
        return getEmail().equals(user.getEmail());
    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getUsername().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getSalt().hashCode();
        result = 31 * result + getPhone().hashCode();
        result = 31 * result + getEmail().hashCode();
        return result;
    }

    //toString method
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
