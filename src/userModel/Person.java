package userModel;

import java.util.UUID;

public class Person {
    private final UUID id;
    private String username;
    private String email;
    private String password;

    public Person(UUID id,String username ,String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
