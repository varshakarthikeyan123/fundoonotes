package com.fundoo.notes.controller;

import com.fundoo.notes.model.Note;
import com.fundoo.notes.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    // ✅ GET NOTES
    @GetMapping
    public List<Note> getNotes(Authentication auth) {
        String email = (String) auth.getPrincipal();
        return noteService.getNotes(email);
    }

    // 📌 PIN
    @PutMapping("/pin/{id}")
    public String togglePin(@PathVariable Long id, Authentication auth) {
        String email = (String) auth.getPrincipal();
        return noteService.togglePin(id, email);
    }

    // 📦 ARCHIVE
    @PutMapping("/archive/{id}")
    public String toggleArchive(@PathVariable Long id, Authentication auth) {
        String email = (String) auth.getPrincipal();
        return noteService.toggleArchive(id, email);
    }

    // 🗑 DELETE
    @DeleteMapping("/{id}")
    public String deleteNote(@PathVariable Long id, Authentication auth) {
        String email = (String) auth.getPrincipal();
        return noteService.deleteNote(id, email);
    }
}