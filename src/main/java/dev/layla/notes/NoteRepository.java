package dev.layla.notes;

import java.util.List;
import java.util.Optional;

public interface NoteRepository {

    // Guardar o actualizar una nota
    Note save(Note note);

    // Buscar una nota por id
    Optional<Note> findById(Long id);

    // Listar todas las notas
    List<Note> findAll();

    // Listar notas de un usuario
    List<Note> findByOwner(User owner);

    // Eliminar una nota por id
    void deleteById(Long id);
}
