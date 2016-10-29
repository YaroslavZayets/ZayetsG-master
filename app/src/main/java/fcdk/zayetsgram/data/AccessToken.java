package fcdk.zayetsgram.data;


import static android.R.attr.data;

public class AccessToken {
    public String access_token;
    public User user;

    public AccessToken(String access_token, User user) {
        this.access_token = access_token;
        this.user = user;
    }

    public String getAccess_token() {
        return access_token;
    }

    public User getUser() {
        return user;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
