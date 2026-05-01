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

    @GetMapping
    public List<Note> getNotes(Authentication authentication) {

        String email = (String) authentication.getPrincipal();

        return noteService.getNotes(email);
    }
}