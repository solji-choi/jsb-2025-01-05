package com.ll.jsb.domain.question.question.controller;

import com.ll.jsb.domain.question.question.dto.QuestionDto;
import com.ll.jsb.domain.question.question.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(Model model) {
        List<QuestionDto> questionList = questionService
                .findAll()
                .stream()
                .map(QuestionDto::new)
                .toList();

        model.addAttribute("questionList", questionList);

        return "/domain/question/question/question_list";
    }
}
