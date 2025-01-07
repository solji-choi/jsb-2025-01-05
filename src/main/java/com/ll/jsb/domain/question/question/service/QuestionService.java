package com.ll.jsb.domain.question.question.service;

import com.ll.jsb.domain.question.question.entity.Question;
import com.ll.jsb.domain.question.question.repository.QuestionRepository;
import com.ll.jsb.global.exceptions.DataNotFoundException;
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

    public Question findById(long id) {
        return questionRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("question not found")
        );
    }

    public void create(String subject, String content) {
        Question question = Question
                .builder()
                .subject(subject)
                .content(content)
                .build();

        questionRepository.save(question);
    }
}
