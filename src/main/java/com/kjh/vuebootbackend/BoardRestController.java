package com.kjh.vuebootbackend;

import com.kjh.vuebootbackend.dto.BoardModifyDto;
import com.kjh.vuebootbackend.dto.BoardWriteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/board")
public class BoardRestController {
    @Autowired
    private final BoardService boardService;

    @GetMapping("/all")
    public List<Board> boardList() {
        return boardService.searchBoardList(); // deleteYn 유무 상관 없이 모두 호출.
    }

    @GetMapping("/")
    public List<Board> searchBoardOne() {
        return boardService.searchBoardOne("n"); // "n" 일 경우 조회
    }

    @PostMapping("/")
    public Board doSaveOne(@RequestBody BoardWriteDto boardWriteDto) { //@RequestBody Post 할 때 Body 를 명시.
//        this.boardService.saveBoard(title, content); //매게 변수로 받을 경우 이렇게. 권장하지 않음. 예시) localhost.local/?title=abc
        return boardService.saveBoard(boardWriteDto);
    }

    @PutMapping("/")
    public Board doModify(@RequestBody BoardModifyDto boardModifyDto) {
        return boardService.modifyBoard(boardModifyDto);
    }


    @PostMapping("/delete/{bNo}")
    public String  deleteBoard(@PathVariable Long bNo){ //@PathVariable 경로(?) 변수. {bNo}를 Long bNo 과 같은 것을 명시.
        boardService.deleteBoard(bNo);
        return "1 board is deleted.";
    }
}
