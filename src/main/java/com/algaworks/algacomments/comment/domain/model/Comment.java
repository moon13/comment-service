package com.algaworks.algacomments.comment.domain.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Comment {

    @Id
    @Builder.Default
    private UUID id = UUID.randomUUID();
    private String text;
    private String author;
    @Builder.Default
    private OffsetDateTime createdAt = OffsetDateTime.now();

}
