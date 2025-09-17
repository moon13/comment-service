package com.algaworks.algacomments.comment.service.domain.model.service;

import com.algaworks.algacomments.comment.service.api.model.CommentInput;
import com.algaworks.algacomments.comment.service.api.model.CommentOutput;
import com.algaworks.algacomments.comment.service.domain.model.Comment;
import com.algaworks.algacomments.comment.service.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;

    public CommentOutput createComment(CommentInput input) {
        Comment comment = Comment.builder()
                .text(input.getText())
                .author(input.getAuthor())
                .build();

        //ModerationRequest request = new ModerationRequest(comment.getId(), input.getText());
        //ModerationResponse response = moderationClient.moderateComment(request);

        //if (!response.isApproved()) {
          //  throw new ModerationRejectedException(response.getReason());
       // }

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
