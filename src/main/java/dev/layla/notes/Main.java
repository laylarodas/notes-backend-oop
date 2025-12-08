package dev.layla.notes;

public class Main {
    public static void main(String[] args) {
        // Crear un usuario
        User user = new User(1L, "Layla", "layla@example.com");

        // Crear una nota
        Note note = new Note(
                1L,
                "Mi primera nota",
                "Esto es contenido de ejemplo",
                user
        );
        // Imprimir la nota creada
        System.out.println("Nota creada:");
        System.out.println("Título: " + note.getTitle());
        System.out.println("Dueña: " + note.getOwner().getName());
        System.out.println("Fecha: " + note.getCreatedAt());
    }
}
