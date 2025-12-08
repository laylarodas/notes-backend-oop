package dev.layla.notes;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        User user = new User(1L, "Layla", "layla@example.com");
        // Creamos una instancia de la clase InMemoryNoteRepository para guardar las notas en memoria
        NoteRepository noteRepository = new InMemoryNoteRepository();

        Note note1 = new Note(1L, "Primera nota", "Contenido 1", user);
        // Creamos una instancia de la clase Note para guardar la primera nota
        Note note2 = new Note(2L, "Segunda nota", "Contenido 2", user);

        noteRepository.save(note1);
        noteRepository.save(note2);

        System.out.println("Todas las notas:");
        List<Note> allNotes = noteRepository.findAll();
        allNotes.forEach(note ->
                System.out.println(note.getId() + " - " + note.getTitle())
        );

        System.out.println("\nBuscar nota con id = 1:");
        Optional<Note> maybeNote = noteRepository.findById(1L);
        maybeNote.ifPresent(note ->
                System.out.println("Encontrada: " + note.getTitle())
        );

        System.out.println("\nBorrar nota con id = 1");
        noteRepository.deleteById(1L);

        System.out.println("\nNotas después de borrar:");
        noteRepository.findAll().forEach(note ->
                System.out.println(note.getId() + " - " + note.getTitle())
        );
    }
}
