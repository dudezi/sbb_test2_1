package com.example.sbb_test2_1.article;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.PathVariable;

@Getter
@Setter
public class ArticleForm {
    @NotEmpty(message = "제목은 필수 입력 사항입니다.")
    @Size(max = 200)
    private  String title;

    @NotEmpty(message = "내용은 필수 입력 사항입니다.")
    private String content;
}
