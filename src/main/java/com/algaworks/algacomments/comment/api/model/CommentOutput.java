package com.algaworks.algacomments.comment.api.model;


import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.UUID;

@Builder
@Data
public class CommentOutput
{
    private UUID id;
    private String text;
    private String author;
    private OffsetDateTime createdAt;
}
