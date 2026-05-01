package com.fundoo.notes.service;

import com.fundoo.notes.model.Note;

import java.util.List;

public interface NoteService {

    List<Note> getNotes(String email);
}