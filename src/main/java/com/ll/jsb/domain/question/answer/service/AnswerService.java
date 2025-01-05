package com.ll.jsb.domain.question.answer.service;

import com.ll.jsb.domain.question.answer.entity.Answer;
import com.ll.jsb.domain.question.answer.repository.AnswerRepository;
import com.ll.jsb.domain.question.question.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnswerService {
    private final AnswerRepository answerRepository;

    public Answer create(Question question, String content) {
        Answer answer = Answer
                .builder()
                .content(content)
                .question(question)
                .build();

        return answerRepository.save(answer);
    }
}
