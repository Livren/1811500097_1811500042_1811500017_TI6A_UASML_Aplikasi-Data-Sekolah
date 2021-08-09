package ac.id.atmaluhur.uas_pemrograman_mobile;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface SiswaJsonPlaceHolderApi {
    @GET("restApiSiswa.php")
    Call<List<SiswaPost>> getSiswa(

    );
    @GET("restApiSiswa.php")
    Call<List<SiswaPost>> getSiswa(@QueryMap Map<String, String> parameters);
}
