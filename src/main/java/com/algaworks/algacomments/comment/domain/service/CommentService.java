package com.algaworks.algacomments.comment.domain.service;

import com.algaworks.algacomments.comment.api.client.ModerationClient;
import com.algaworks.algacomments.comment.api.model.CommentInput;
import com.algaworks.algacomments.comment.api.model.CommentOutput;
import com.algaworks.algacomments.comment.api.model.ModerationRequest;
import com.algaworks.algacomments.comment.api.model.ModerationResponse;
import com.algaworks.algacomments.comment.domain.exception.ModerationRejectedException;
import com.algaworks.algacomments.comment.domain.model.Comment;
import com.algaworks.algacomments.comment.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ModerationClient moderationClient;

    public CommentOutput createComment(CommentInput input) {
        Comment comment = Comment.builder()
                .text(input.getText())
                .author(input.getAuthor())
                .build();

        ModerationRequest request = new ModerationRequest(comment.getText(), comment.getId());
        ModerationResponse response = moderationClient.moderateComment(request);

        if (!response.getApproved()) {
            throw new ModerationRejectedException(response.getReason());
        }

        Comment savedComment = commentRepository.saveAndFlush(comment);
        return mapToOutput(savedComment);
    }

    private CommentOutput mapToOutput(Comment comment) {
        return CommentOutput.builder()
                .id(comment.getId())
                .text(comment.getText())
                .author(comment.getAuthor())
                .createdAt(comment.getCreatedAt())
                .build();
    }

}
