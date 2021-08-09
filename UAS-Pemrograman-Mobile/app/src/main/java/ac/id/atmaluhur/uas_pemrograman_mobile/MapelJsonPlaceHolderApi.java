package ac.id.atmaluhur.uas_pemrograman_mobile;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface MapelJsonPlaceHolderApi {
    @GET("restApiMapel.php")
    Call<List<MapelPost>> getMapel(

    );
    @GET("restApiMapel.php")
    Call<List<MapelPost>> getMapel(@QueryMap Map<String, String> parameters);
}
