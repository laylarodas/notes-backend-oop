package dev.layla.notes;

public class User {

    // Atributos privados (encapsulación)
    private Long id;
    private String name;
    private String email;

    // Constructor
    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters (solo lectura)
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    // Setters (permiten cambiar solo algunos campos)
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

