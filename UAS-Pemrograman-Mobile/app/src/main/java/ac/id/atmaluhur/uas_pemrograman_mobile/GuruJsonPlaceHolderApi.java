package ac.id.atmaluhur.uas_pemrograman_mobile;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface GuruJsonPlaceHolderApi {
    @GET("restApiGuru.php")
    Call<List<GuruPost>> getGuru();

    @GET("restApiGuru.php")
    Call<List<GuruPost>> getPosts(@QueryMap Map<String, String> parameters);
}
