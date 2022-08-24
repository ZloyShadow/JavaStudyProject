package com.restvote.votingsystem.repository.datajpa;

import com.restvote.votingsystem.model.Vote;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudVoteRepository extends JpaRepository<Vote, Integer> {

    @SuppressWarnings("JpaQlInspection")
    @Query("SELECT v FROM Vote v WHERE v.user.id=:userId AND v.taken BETWEEN :startDateTime AND :endDateTime")
    Vote getByUserId(@Param("userId") int userId,
                     @Param("startDateTime") LocalDateTime startDateTime,
                     @Param("endDateTime") LocalDateTime endDateTime);

    @Override
    List<Vote> findAll(Sort sort);

    @Override
    @Transactional
    Vote save(Vote vote);

    @SuppressWarnings("JpaQlInspection")
    @Transactional
    @Modifying
    @Query("DELETE FROM Vote v WHERE v.user.id=:userId AND v.taken BETWEEN :startDateTime AND :endDateTime")
    int delete(@Param("userId") int userId,
               @Param("startDateTime") LocalDateTime startDateTime,
               @Param("endDateTime") LocalDateTime endDateTime);
}
