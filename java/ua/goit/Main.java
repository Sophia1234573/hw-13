package ua.goit;

import java.io.IOException;

public class Main {
    private static final String PATH_TO_NEW_USER = "D:\\Sophia\\Java\\GoIT\\module13\\HTTP-hw\\src\\main\\resources\\userToPost.json";
    private static final String PATH_TO_UPDATE_USER = "D:\\Sophia\\Java\\GoIT\\module13\\HTTP-hw\\src\\main\\resources\\userToUpdate.json";

    public static void main(String[] args) throws IOException, InterruptedException {
        InteractionWithJsonPlaceholder interaction = new InteractionWithJsonPlaceholder();
        //Create new user
        System.out.println("Created user:");
        System.out.println(interaction.createNewUser(PATH_TO_NEW_USER));

        //Update user
        System.out.println("-----------------------");
        System.out.println("Updated user:");
        System.out.println(interaction.updateUser(5, PATH_TO_UPDATE_USER));

        //Delete user by id
        System.out.println("-----------------------");
        System.out.println("Status of DELETE request: " + interaction.deleteUserById(7));

        //Information about all users
        System.out.println("-----------------------");
        System.out.println("Information about all users:");
        System.out.println(interaction.getUsers());

        //Information about user by id
        System.out.println("-----------------------");
        System.out.println("Information about user by id:");
        System.out.println(interaction.getUserById(6));

        //Information about user by username
        System.out.println("-----------------------");
        System.out.println("Information about user by username:");
        System.out.println(interaction.getUserByUsername("Karianne"));

        //Get comments of last users post
        System.out.println("-----------------------");
        System.out.println("Get comments");
        System.out.println(interaction.getComments(7));

        //Get todos for user by id
        System.out.println("-----------------------");
        System.out.println("Todos:");
        System.out.println(interaction.getTodosForUser(1));
    }
}
