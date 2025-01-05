package com.ll.jsb.domain.question.answer.repository;

import com.ll.jsb.domain.question.answer.entity.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
}
