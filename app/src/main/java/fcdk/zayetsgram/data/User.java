package fcdk.zayetsgram.data;



public class User {
    public String username;
    public String bio;
    public String website;
    public String profile_picture;
    public String full_name;
    public String id;

    public User(String username, String id, String full_name, String profile_picture, String website, String bio) {
        this.username = username;
        this.id = id;
        this.full_name = full_name;
        this.profile_picture = profile_picture;
        this.website = website;
        this.bio = bio;
    }

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }

    public String getFull_name() {
        return full_name;
    }

    public String getProfile_picture() {
        return profile_picture;
    }

    public String getWebsite() {
        return website;
    }

    public String getBio() {
        return bio;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public void setProfile_picture(String profile_picture) {
        this.profile_picture = profile_picture;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
