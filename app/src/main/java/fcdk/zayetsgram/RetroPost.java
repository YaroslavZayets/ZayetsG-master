package fcdk.zayetsgram;

import fcdk.zayetsgram.data.AccessToken;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetroPost {
    @FormUrlEncoded
    @POST("/oauth/access_token")
    Call<AccessToken> updateDate(@Field("client_id") String client_id,
                                 @Field("client_secret") String client_secret,
                                 @Field("grant_type") String grant_type,
                                 @Field("redirect_uri") String redirect_uri,
                                 @Field("code")  String code);
}
