package com.algaworks.algacomments.comment.service.api.client;

import com.algaworks.algacomments.comment.service.api.model.ModerationRequest;
import com.algaworks.algacomments.comment.service.api.model.ModerationResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

public interface ModerationClient {
    @PostExchange("/api/moderate")
    ModerationResponse moderateComment(@RequestBody ModerationRequest request);
}
