package com.ll.jsb.domain.question.question.dto;

import com.ll.jsb.domain.question.question.entity.Question;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class QuestionDto {
    private long id;
    private LocalDateTime createDate;
    private String subject;
    private String content;

    public QuestionDto(Question question) {
        this.id = question.getId();
        this.createDate = question.getCreateDate();
        this.subject = question.getSubject();
        this.content = question.getContent();
    }
}
