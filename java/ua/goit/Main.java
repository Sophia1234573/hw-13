package ua.goit;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, InterruptedException {
        InteractionWithJsonPlaceholder interaction = new InteractionWithJsonPlaceholder();
        //Create new user
        System.out.println("Created user:");
        System.out.println(interaction.createNewUser(createDefaultUser()));

        //Update user
        System.out.println("-----------------------");
        System.out.println("Updated user:");
        System.out.println(interaction.updateUser(5, createDefaultUser()));

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
        System.out.println(interaction.getUserByUsername("Leopoldo_Corkery"));

        //Get comments of last users post
        System.out.println("-----------------------");
        System.out.println("Get comments");
        System.out.println(interaction.getComments(7));

        //Get todos for user by id
        System.out.println("-----------------------");
        System.out.println("Todos:");
        System.out.println(interaction.getTodosForUser(1));
    }

    private static User createDefaultUser() {
        User newUser = new User.Builder()
                .id(1)
                .name("Sophia")
                .username("sophia1234573")
                .email("sophiadenisovichgovtva@gmail.com")
                .website("goit.ua")
                .phone("0669008172")
                .company(new Company.Builder()
                        .name("Romaguera-Crona")
                        .bs("harness real-time e-markets")
                        .catchPhrase("Multi-layered client-server neural-net").build())
                .address(new Address.Builder()
                        .zipcode("92998-3874")
                        .city("Kharkiv")
                        .street("Sumska")
                        .suite("40")
                        .geo(new Geo.Builder()
                                .lat(37.3159)
                                .lng(81.1496)
                                .build())
                        .build())
                .build();
        return newUser;
    }
}
