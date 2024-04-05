package at.ac.fhcampuswien.fhmdb;

import at.ac.fhcampuswien.fhmdb.models.Movie;
import okhttp3.*;


import java.io.IOException;
import java.util.List;

public class MovieAPI {
    public static String sendRequest() {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://prog2.fh-campuswien.ac.at/movies")
                .addHeader("User-Agent", "http.agent")
                .build();

        Call call = client.newCall(request);
        try {
            Response response = call.execute();
            return response.body().string();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
