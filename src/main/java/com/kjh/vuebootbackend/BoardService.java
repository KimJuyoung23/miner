package com.kjh.vuebootbackend;

import com.kjh.vuebootbackend.dto.BoardDeleteDto;
import com.kjh.vuebootbackend.dto.BoardModifyDto;
import com.kjh.vuebootbackend.dto.BoardWriteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    public List<Board> searchBoardList() {
        return boardRepository.findAll();
    }

    public List<Board> searchBoardOne(String deleteYn){
        return boardRepository.findByDeleteYn(deleteYn);
    }
    @Transactional
    public Board saveBoard(BoardWriteDto boardWriteDto) {
        return boardRepository.save(boardWriteDto.toEntity());
    }

    @Transactional
    public Board modifyBoard(BoardModifyDto boardModifyDto){
        return boardRepository.save(boardModifyDto.toEntity());
    }


    @Transactional
    public void deleteBoard(Long bNo) {
        Board board = boardRepository.findById(bNo).orElseThrow();
        BoardDeleteDto boardDeleteDto = BoardDeleteDto.builder()
                .bNo(bNo)
                .deleteYn("y")
                .build();
        boardRepository.save(boardDeleteDto.toEntity());
    }

}
