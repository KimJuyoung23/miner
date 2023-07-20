package com.kjh.vuebootbackend;

import com.kjh.vuebootbackend.dto.BoardListDto;
import com.kjh.vuebootbackend.dto.BoardModifyDto;
import com.kjh.vuebootbackend.dto.BoardWriteDto;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardRestController {
    private final BoardService boardService;

    @GetMapping("/all")
    public List<Board> boardList() {
        return boardService.searchBoardList();
    }

    @GetMapping("/")
    public List<Board> searchBoardOne() {
        return boardService.searchBoardOne("y"); // n 으로 변경해서 사용
    }

    @PostMapping("/")
    public Board doSaveOne(@RequestBody BoardWriteDto boardWriteDto) {
//        this.boardService.saveBoard(title, content);
        return boardService.saveBoard(boardWriteDto);
    }

    @PutMapping("/")
    public Board doModify(@RequestBody BoardModifyDto boardModifyDto) {
        return boardService.modifyBoard(boardModifyDto);
    }


    @PostMapping("/delete/{no}")
    public void deleteBoard(@PathVariable Long no){
        boardService.deleteBoard(no);
    }
}
