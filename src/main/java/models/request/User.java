package models.request;

import models.BaseModel;

import java.util.Map;

public class User extends BaseModel {
    private String name;
    private String gender;
    private String status;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public User(String name, String gender, String status, String email) {
        this.name = name;
        this.gender = gender;
        this.status = status;
        this.email = email;
    }

    public User(models.response.User user) {
        this(user.getName(), user.getGender(), user.getStatus(), user.getEmail());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", status='" + status + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;

        if (!name.equals(user.name)) return false;
        if (!gender.equals(user.gender)) return false;
        if (!status.equals(user.status)) return false;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + email.hashCode();
        return result;
    }

    public int a () {

        return 0;
    }


    @Override
    public Map<String, Object> getMap() {
        return Map.of(
                "name", name,
                "gender", gender,
                "status", status,
                "email", email
        );
    }
}

