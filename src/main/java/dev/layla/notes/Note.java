package dev.layla.notes;

import java.time.LocalDateTime;

public class Note {

    // Atributos privados (encapsulación)
    private Long id;
    private String title; 
    private String content;
    private LocalDateTime createdAt; // Fecha de creación de la nota

    // Relación básica: una Note pertenece a un User
    private User owner; // Usuario dueño de la nota
    /*
    * Constructor de la clase Note
    * @param id el id de la nota
    * @param title el titulo de la nota
    * @param content el contenido de la nota
    * @param owner el usuario dueño de la nota
    */
    public Note(Long id, String title, String content, User owner) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.owner = owner;
        this.createdAt = LocalDateTime.now();
    }
    /*
    * Getter para el id de la nota
    * @return el id de la nota
    * 
    * Getter para el titulo de la nota
    * @return el titulo de la nota
    * 
    * Getter para el contenido de la nota
    * @return el contenido de la nota
    * 
    * Getter para la fecha de creación de la nota
    * @return la fecha de creación de la nota
    * 
    * Getter para el usuario dueño de la nota
    * @return el usuario dueño de la nota
    * 
    */
    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public User getOwner() {
        return owner;
    }

    /*
    * Setter para el titulo de la nota
    * @param title el titulo de la nota
    * 
    * Setter para el contenido de la nota
    * @param content el contenido de la nota
    * 
    */

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
