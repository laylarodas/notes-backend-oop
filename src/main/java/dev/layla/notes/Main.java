package dev.layla.notes;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        User user = new User(1L, "Layla", "layla@example.com");

        // Creamos una instancia de la clase InMemoryNoteRepository para guardar las notas en memoria
        NoteRepository noteRepository = new InMemoryNoteRepository();
        NoteService noteService = new NoteService(noteRepository);

        // Creamos una nueva nota
        Note note = noteService.createNote(1L, "Primera nota", "Contenido 1", user);
        Note note2 = noteService.createNote(2L, "Segunda nota", "Contenido 2", user);

        // Mostramos todas las notas
        System.out.println("Todas las notas:");
        List<Note> allNotes = noteService.getAllNotes();
        allNotes.forEach(n ->
                System.out.println(n.getId() + " - " + n.getTitle())
        );

        //Buscar nota por id
        System.out.println("Nota encontrada:");
        Note foundNote = noteService.getNoteById(1L);
        System.out.println(foundNote.getId() + " - " + foundNote.getTitle());

        //Borrar nota por id
        System.out.println("Borrando nota con id 1...");
        noteService.deleteNote(1L);
        System.out.println("Nota borrada exitosamente");

        //Mostrar notas después de borrar
        System.out.println("Notas después de borrar:");
        List<Note> allNotesAfterDelete = noteService.getAllNotes();
        allNotesAfterDelete.forEach(n ->
                System.out.println(n.getId() + " - " + n.getTitle())
        );

        //Probar buscar nota inexistente (capturamos la excepción)
        System.out.println("Buscando nota inexistente (id 3):");
        try {
            Note notFoundNote = noteService.getNoteById(3L);
            System.out.println(notFoundNote);
        } catch (NoteNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
    }
}
