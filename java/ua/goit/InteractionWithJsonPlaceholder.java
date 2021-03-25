package ua.goit;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.util.List;

public class InteractionWithJsonPlaceholder {
    private static final HttpClient HTTP_CLIENT = HttpClient.newHttpClient();
    private static final Gson GSON = new Gson();
    private static final String USERS_URL = "https://jsonplaceholder.typicode.com/users";
    private static final String USERS_URL_BY_ID = "https://jsonplaceholder.typicode.com/users/";
    private static final String USERS_URL_BY_USERNAME = "https://jsonplaceholder.typicode.com/users?username=";
    private static final String USERS_URL_POSTS = "https://jsonplaceholder.typicode.com/posts/";

    public User createNewUser(User user) throws IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL))
                .header("Content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(GSON.toJson(user)))
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), User.class);
    }

    public User updateUser(int id, User user) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%d", USERS_URL_BY_ID, id)))
                .header("Content-type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(GSON.toJson(user)))
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), User.class);
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

    public List<User> getUsers() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(USERS_URL))
                .header("Content-type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        List<User> users = GSON.fromJson(response.body(), new TypeToken<List<User>>(){}.getType());
        return users;
    }

    public User getUserById(int id) throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%d", USERS_URL_BY_ID, id)))
                .header("Content-type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(response.body(), User.class);
    }

    public List<User> getUserByUsername(String username) throws IOException, InterruptedException{
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%s", USERS_URL_BY_USERNAME, username)))
                .header("Content-type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        List<User> users = GSON.fromJson(response.body(), new TypeToken<List<User>>(){}.getType());
        return users;
    }

    public List<Comment> getComments(int x) throws IOException, InterruptedException {
        int y = x * 10;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%d%s", USERS_URL_POSTS, y, "/comments")))
                .header("Content-type", "application/json")
                .GET()
                .build();

        HttpResponse<Path> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers
                .ofFile(Path.of("D:\\Sophia\\Java\\GoIT\\module13\\HTTP-hw\\src\\main\\resources\\user-" + x + "-post-" + y + "-comments.json")));
        HttpResponse<String> responseToPrint = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        List<Comment> comments = GSON.fromJson(responseToPrint.body(), new TypeToken<List<Comment>>(){}.getType());
        return comments;
    }

    public List<Todo> getTodosForUser(int id) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(String.format("%s%d%s", USERS_URL_BY_ID, id, "/todos?completed=false")))
                .header("Content-type", "application/json")
                .GET()
                .build();
        HttpResponse<String> response = HTTP_CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
        List<Todo> todos = GSON.fromJson(response.body(), new TypeToken<List<Todo>>(){}.getType());
        return todos;
    }
}
