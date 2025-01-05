package com.ll.jsb.domain.question.answer.controller;

import com.ll.jsb.domain.question.answer.service.AnswerService;
import com.ll.jsb.domain.question.question.entity.Question;
import com.ll.jsb.domain.question.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {
    private final AnswerService answerService;
    private final QuestionService questionService;

    @PostMapping("/create/{questionId}")
    public String create(
            Model model,
            @PathVariable long questionId,
            String content

    ) {
        Question question = questionService.findById(questionId);

        answerService.create(question, content);

        return "redirect:/question/detail/%d".formatted(questionId);
    }
}
