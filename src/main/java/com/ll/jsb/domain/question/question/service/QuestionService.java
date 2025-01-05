package com.ll.jsb.domain.question.question.service;

import com.ll.jsb.domain.question.question.entity.Question;
import com.ll.jsb.domain.question.question.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> findAll() {
        return questionRepository.findAll();
    }
}
