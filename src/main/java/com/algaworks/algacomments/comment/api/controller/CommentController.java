package com.algaworks.algacomments.comment.api.controller;

import com.algaworks.algacomments.comment.api.model.CommentInput;
import com.algaworks.algacomments.comment.api.model.CommentOutput;
import com.algaworks.algacomments.comment.domain.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CommentOutput create(@RequestBody CommentInput input){
        return commentService.createComment(input);

    }
}
