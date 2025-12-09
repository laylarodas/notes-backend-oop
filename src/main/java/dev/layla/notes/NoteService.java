package dev.layla.notes;

import java.util.List;

public class NoteService {
    private final NoteRepository noteRepository;

    // Inyección por constructor
    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    // Crear una nueva nota
    public Note createNote(Long id, String title, String content, User owner) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Title cannot be empty");
        }
        Note note = new Note(id, title, content, owner);
        return noteRepository.save(note);
    }

    // Obtener una nota por id (si no existe, se lanza excepción)
    public Note getNoteById(Long id) {
        return noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
    }

    // Listar todas las notas
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    // Listar notas de un usuario
    public List<Note> getNotesByUser(User owner) {
        return noteRepository.findByOwner(owner);
    }

    // Actualizar título y contenido de una nota
    public Note updateNote(Long id, String newTitle, String newContent) {
        Note existing = getNoteById(id); // si no existe, lanza NoteNotFoundException

        if (newTitle != null && !newTitle.isBlank()) {
            existing.setTitle(newTitle);
        }
        if (newContent != null && !newContent.isBlank()) {
            existing.setContent(newContent);
        }

        return noteRepository.save(existing);
    }

    // Borrar una nota
    public void deleteNote(Long id) {
        // Verificamos primero que exista
        Note existing = getNoteById(id); // lanza NoteNotFoundException si no existe
        noteRepository.deleteById(existing.getId());
    }

}
