package com.ll.jsb.domain.question.question.controller;

import com.ll.jsb.domain.question.answer.form.AnswerForm;
import com.ll.jsb.domain.question.question.dto.QuestionDto;
import com.ll.jsb.domain.question.question.service.QuestionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/question")
public class QuestionController {
    private final QuestionService questionService;

    @GetMapping("/list")
    public String list(
            Model model,
            @RequestParam(defaultValue = "0") int page
    ) {
        Page<QuestionDto> paging = questionService
                .findAll(page)
                .map(QuestionDto::new);

        model.addAttribute("paging", paging);

        return "/domain/question/question/question_list";
    }

    @GetMapping("/detail/{id}")
    public String detail(
            Model model,
            @PathVariable long id,
            AnswerForm answerForm
    ) {
        QuestionDto question = new QuestionDto(questionService.findById(id));

        model.addAttribute("question", question);

        return "/domain/question/question/question_detail";
    }

    record  QuestionForm(
            @NotEmpty(message = "제목은 필수항목입니다.")
            @Size(max = 200)
            String subject,

            @NotEmpty(message = "내용은 필수항목입니다.")
            String content
    ) {}

    @GetMapping("/create")
    public String create(QuestionForm questionForm) {
        return "/domain/question/question/question_form";
    }

    @PostMapping("/create")
    public String create(
            @Valid QuestionForm questionForm,
            BindingResult bindingResult
    ) {
        if(bindingResult.hasErrors()) return "/domain/question/question/question_form";

        questionService.create(questionForm.subject, questionForm.content);

        return "redirect:/question/list";
    }
}
