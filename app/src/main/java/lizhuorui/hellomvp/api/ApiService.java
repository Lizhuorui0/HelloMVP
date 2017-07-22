package lizhuorui.hellomvp.api;

import lizhuorui.hellomvp.bean.Gank;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 *  Retrofit引擎封装
 *      用了单例模式，在构造方法中只初始化一次Retrofit和Okhttp。
 *      双重锁的方式获取单例，然后再根据需要获取ApiService，
 *      如果你有很多个不同源的API，那就可以创建多个getXXXXApiService。
 */
public interface ApiService {

    String BASE_URL="http://gank.io/";

    @GET("api/data/Android/10/{page}")
    Observable<Gank> getGank(@Path("page") String page);

}
