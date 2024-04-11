package com.example.kubernetes.domain.controller;

import com.example.kubernetes.domain.controller.request.BoardRequest;
import com.example.kubernetes.domain.service.BoardService;
import com.example.kubernetes.model.entity.KuBoard;
import com.example.kubernetes.model.entity.KuBoardPost;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Tag(name = "게시판 API", description = "게시판 Controller API")
@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/api/board")
    public Mono<ResponseEntity<KuBoard>> saveBoard(@RequestBody BoardRequest request) {
        return boardService.saveBoard(request)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.ok(null));
    }
    @GetMapping("/api/board/{id}")
    public Mono<ResponseEntity<KuBoard>> getBoard(@PathVariable Long id) {
        return boardService.getBoard(id)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.ok(null));
    }


}
