package com.fundoo.notes.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "notes")
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    // 🔗 IMPORTANT → link to user
    private Long userId;

    // 🏷️ Flags
    private boolean isPinned = false;
    private boolean isArchived = false;
    private boolean isDeleted = false;
}