package dev.layla.notes;

public class NoteNotFoundException extends RuntimeException {

    public NoteNotFoundException(Long id) {
        super("Note with id " + id + " was not found");
    }

    public NoteNotFoundException(String message) {
        super(message);
    }
}

