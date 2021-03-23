package ua.goit;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;

public class InteractionWithJsonPlaceholder {
    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();
    private static final String USERS_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String USERS_URL_BY_ID = "https://jsonplaceholder.typicode.com/users/";
    private static final String USERS_URL_BY_USERNAME = "https://jsonplaceholder.typicode.com/users?username=";
    private static final String USERS_URL_POSTS = "https://jsonplaceholder.typicode.com/posts/";

    public String createNewUser(String path) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL))
                .header("Content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofFile(Path.of(path)))
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String updateUser(int id, String path) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%d", USERS_URL_BY_ID, id)))
                .header("Content-type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofFile(Path.of(path)))
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public int deleteUserById (int id) throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%d", USERS_URL_BY_ID, id)))
                .header("Content-type", "application/json")
                .DELETE()
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode();
    }

    public String getUsers() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL))
                .header("Content-type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.toJson(response.body());
    }

    public String getUserById(int id) throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%d", USERS_URL_BY_ID, id)))
                .header("Content-type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.toJson(response.body());
    }

    public String getUserByUsername(String username) throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s", USERS_URL_BY_USERNAME, username)))
                .header("Content-type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.toJson(response.body());
    }

    public String getComments(int x) throws IOException, InterruptedException {
        int y = x * 10;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%d%s", USERS_URL_POSTS, y, "/comments")))
                .header("Content-type", "application/json")
                .GET()
                .build();

        HttpResponse<Path> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers
                .ofFile(Path.of("D:\\Sophia\\Java\\GoIT\\module13\\HTTP-hw\\src\\main\\resources\\user-" + x + "-post-" + y + "-comments.json")));
        HttpResponse<String> responseToPrint = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.toJson(responseToPrint.body());
    }

    public String getTodosForUser(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%d%s", USERS_URL_BY_ID, id, "/todos?completed=false")))
                .header("Content-type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
