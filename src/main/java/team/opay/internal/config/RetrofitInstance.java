package team.opay.internal.config;

import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.Map;

public class RetrofitInstance {
    private static Retrofit instance = null;

    private static Logger logger = LoggerFactory.getLogger(RetrofitInstance.class);
    private RetrofitInstance() {
    }

    public static synchronized Retrofit getInstance(String baseUrl, Map<String, String> headers) {

        if (instance == null) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor(s -> {
                logger.info(s);
            });
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .addInterceptor(logging)
                    .addInterceptor(chain -> {
                        Request original = chain.request();
                        Request request = original.newBuilder()
                                .headers(Headers.of(headers))
                                .method(original.method(), original.body())
                                .build();

                        return chain.proceed(request);
                    })
                    .build();

            instance = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(baseUrl)
                    .client(httpClient)
                    .build();
        }
        return instance;
    }
}
