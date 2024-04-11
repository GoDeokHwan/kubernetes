package com.example.kubernetes.domain.service;

import com.example.kubernetes.domain.controller.request.BoardRequest;
import com.example.kubernetes.model.entity.KuBoard;
import com.example.kubernetes.model.repository.KuBoardPostRepository;
import com.example.kubernetes.model.repository.KuBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final KuBoardRepository kuBoardRepository;
    private final KuBoardPostRepository kuBoardPostRepository;
    public Mono<KuBoard> saveBoard(BoardRequest request) {
        KuBoard kuBoard = KuBoard.of(request.getTitle(), request.getContent());
        return kuBoardRepository.save(kuBoard);
    }

    public Mono<KuBoard> getBoard(Long id) {
        return kuBoardRepository.findById(id)
                .switchIfEmpty(Mono.error(new ClassNotFoundException("게시판을 찾을 수 없습니다.")));
    }
}
