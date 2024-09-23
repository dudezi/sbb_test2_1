package com.example.sbb_test2_1.article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/article")
@Controller
public class ArticleController {

    @GetMapping("/list")
    @ResponseBody
    public String articleList() {
        return "확인용";
    }
}
