package com.kjh.vuebootbackend;

import com.kjh.vuebootbackend.dto.BoardDeleteDto;
import com.kjh.vuebootbackend.dto.BoardModifyDto;
import com.kjh.vuebootbackend.dto.BoardWriteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
    @Transactional // 선언적 트랙잭. 연산의 원자성이 보장되고, 고립된다.
    public Board saveBoard(BoardWriteDto boardWriteDto) {
        return boardRepository.save(boardWriteDto.toEntity());
    }

    @Transactional
    public Board modifyBoard(BoardModifyDto boardModifyDto){
//        Optional<Board> board = boardRepository.findById(bNo);

        return boardRepository.save(boardModifyDto.toEntity());
    }


    @Transactional
    public Board deleteBoard(Long bNo) {
        Optional<Board> board = boardRepository.findById(bNo);
        BoardDeleteDto boardDeleteDto = BoardDeleteDto.builder()
                .bNo(bNo)
                .deleteYn("y")
                .build();
        return boardRepository.save(boardDeleteDto.toEntity());
    }

}
