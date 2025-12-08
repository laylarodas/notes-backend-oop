package dev.layla.notes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors; // Importación de la clase Collectors para usar el método collect
/*
* Clase InMemoryNoteRepository que implementa la interfaz NoteRepository
* @author Layla
* @version 1.0
* @since 2025-12-09
*/

public class InMemoryNoteRepository implements NoteRepository {

    // "Base de datos" en memoria
    private final List<Note> notes = new ArrayList<>();

    @Override
    public Note save(Note note) {
        // Si ya existe una nota con ese id, la reemplazamos
        deleteById(note.getId());
        notes.add(note);
        return note;
    }

    @Override
    public Optional<Note> findById(Long id) {
        return notes.stream()// Devuelve un stream de las notas
                .filter(note -> note.getId().equals(id))// Filtra las notas por id
                .findFirst();// Devuelve la primera nota que coincide con el id
    }

    @Override
    public List<Note> findAll() {
        // Devolvemos una copia para no exponer la lista interna
        return new ArrayList<>(notes);
    }

    @Override
    public List<Note> findByOwner(User owner) {
        return notes.stream()
                .filter(note -> note.getOwner().getId().equals(owner.getId()))
                .collect(Collectors.toList());// Devuelve una lista de las notas que coinciden con el owner
    }

    @Override
    public void deleteById(Long id) {
        notes.removeIf(note -> note.getId().equals(id));
    }
}
