package com.ll.jsb.domain.question.answer.dto;

import com.ll.jsb.domain.question.answer.entity.Answer;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class AnswerDto {
    private long id;
    private LocalDateTime createDate;
    private String content;

    public AnswerDto(Answer answer) {
        this.id = answer.getId();
        this.createDate = answer.getCreateDate();
        this.content = answer.getContent();
    }
}
