import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import org.testng.annotations.Test;
import org.w3c.dom.ls.LSOutput;


import java.io.IOException;
import java.io.StringReader;
import java.net.URLEncoder;
import java.util.LinkedHashMap;
import java.util.Map;

public class APIExample {

    OkHttpClient client = new OkHttpClient();
    String BASE_URL = "https://jsonplaceholder.typicode.com";

    @Test
    public void getRequestToAllPosts() throws IOException {

        Request request = new Request.Builder()
                .url(BASE_URL + "/posts")
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        assert response.code() == 200;
        System.out.println(response.body().string());
    }

    @Test
    public void getRequestToOnePost() throws IOException {

        Request request = new Request.Builder()
                .url(BASE_URL + "/posts/99") //??????
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();

        assert response.code() == 200;
//        System.out.println(response.body().string());

        String jsonString = response.body().string();
        StringReader reader = new StringReader(jsonString);
        ObjectMapper mapper = new ObjectMapper();
        Post post = mapper.readValue(reader, Post.class);
        assert post.body != null;
        assert post.title != null;
    }

    @Test
    public void getRequestToNonexistentPost() throws IOException {

        Request request = new Request.Builder()
                .url(BASE_URL + "/posts/150")
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        assert response.code() == 404;

        String jsonString = response.body().string();
        StringReader reader = new StringReader(jsonString);
        ObjectMapper mapper = new ObjectMapper();
        Post post = mapper.readValue(reader, Post.class);
        assert post.body == null;
    }

    @Test
    public void postMethod() throws IOException {
        RequestBody formBody = new FormBody.Builder()
                .add("body", RandomString.generateRandomString(97, 122, 5))
                .add("title", RandomString.generateRandomString(97,122,5))
                .add("userId", String.valueOf(1))
                .build();

        Request request = new Request.Builder()
                .url(BASE_URL + "/posts")
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
        assert response.code() == 201;

        String jsonString = response.body().string();
        StringReader reader = new StringReader(jsonString);
        ObjectMapper mapper = new ObjectMapper();
        Post post = mapper.readValue(reader, Post.class);

        String body = post.body.toString();
        String title = post.title.toString();
        assert post.body.equals(body);
        assert post.title.equals(title);
        assert post.userId == 1;
    }

    @Test
    public void secondGetRequestToEverybody() throws IOException {

        int idNum = 5;
        String id = Integer.toString(idNum);

        RequestBody formBody = new FormBody.Builder()
                .add("id", id)
                .add("name", "Chelsey Dietrich")
                .add("username", "Kamren")
                .add("email", "Lucio_Hettinger@annie.ca")
                .add("address", "street: Skiles Walks\n" +
                        "suite: Suite 351\n" +
                        "city: Roscoeview\n" +
                        "zipcode: 33263\n" +
                        "geo:\n" +
                        "lat: -31.8129\n" +
                        "lng\": \"62.5342\"")
                .add("phone", ": (254)954-1289")
                .add("website", "demarco.info")
                .add("company", "name: Keebler LLC,\n" +
                        "catchPhrase: User-centric fault-tolerant solution\n" +
                        "bs: revolutionize end-to-end systems\n")
                .build();

        Request request = new Request.Builder()
                .url(BASE_URL + "/users/5")
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
//        assert response.code() == 200;

        //
        request = new Request.Builder()
                .url(BASE_URL + "/users")
                .build();

        call = client.newCall(request);
        response = call.execute();

        assert response.code() == 200;
        System.out.println(response.body().string());
    }

    @Test
    public void getRequestToId5() throws IOException {

        int idNum = 5;
        String id = Integer.toString(idNum);

        RequestBody formBody = new FormBody.Builder()
                .add("id", id)
                .add("name", "Chelsey Dietrich")
                .add("username", "Kamren")
                .add("email", "Lucio_Hettinger@annie.ca")
                .add("address", "street: Skiles Walks\n" +
                        "suite: Suite 351\n" +
                        "city: Roscoeview\n" +
                        "zipcode: 33263\n" +
                        "geo:\n" +
                        "lat: -31.8129\n" +
                        "lng\": \"62.5342\"")
                .add("phone", ": (254)954-1289")
                .add("website", "demarco.info")
                .add("company", "name: Keebler LLC,\n" +
                        "catchPhrase: User-centric fault-tolerant solution\n" +
                        "bs: revolutionize end-to-end systems\n")
                .build();

        Request request = new Request.Builder()
                .url(BASE_URL + "/users/5")
                .post(formBody)
                .build();

        Call call = client.newCall(request);
        Response response = call.execute();
//        assert response.code() == 200;

        //
        request = new Request.Builder()
                .url(BASE_URL + "/users/5")
                .build();

        call = client.newCall(request);
        response = call.execute();

        assert response.code() == 200;
        System.out.println(response.body().string());
    }


}


