package com.fundoo.notes.service;

import com.fundoo.notes.model.Note;
import java.util.List;

public interface NoteService {

    List<Note> getNotes(String email);

    String togglePin(Long noteId, String email);

    String toggleArchive(Long noteId, String email);

    String deleteNote(Long noteId, String email);
}