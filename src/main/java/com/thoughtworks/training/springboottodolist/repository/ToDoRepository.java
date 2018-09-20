package com.thoughtworks.training.springboottodolist.repository;

import com.thoughtworks.training.springboottodolist.model.ToDo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface ToDoRepository extends JpaRepository<ToDo, Long> {

    Page<ToDo> findByUserId(Long userId, Pageable pageable);

    Page<ToDo> findAllByUserIdAndTags_NameInAndDueDateIsBetween(Long id, String s, Date date, Date date1, Pageable pageable);

    Page<ToDo> findAllByUserIdAndDueDateIsBetween(Long id, Date date, Date date1, Pageable pageable);

    Page<ToDo> findAllByUserIdAndTags_name(Long id, String tag, Pageable pageable);
}
