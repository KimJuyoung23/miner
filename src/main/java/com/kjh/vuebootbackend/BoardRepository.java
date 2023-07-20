package com.kjh.vuebootbackend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.kjh.vuebootbackend.Board.*;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    public List<Board> findByDeleteYn(String deleteYn);
}
