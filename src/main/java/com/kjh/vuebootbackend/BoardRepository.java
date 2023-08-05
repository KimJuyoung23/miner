package com.kjh.vuebootbackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kjh.vuebootbackend.Board.*;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    // Query return type test
    // Optional<>, List<>, Set<> 등 사용 가능

//    Board findByTitle(String title); //User 복수라면 오류 발생. List로 복수 오류 해소
//    List<Board> findByTitle(String title);

    public List<Board> findByDeleteYn(String deleteYn);
}
