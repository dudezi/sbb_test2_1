package com.example.sbb_test2_1.article;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequestMapping("/article")
@Controller
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @GetMapping("/")
    public String main() {
        return "redirect:/article/list";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Article> articleList = this.articleService.getList();
        model.addAttribute("articleList", articleList);
        return "article_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String articleDetail(Model model, @PathVariable("id") Integer id) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article_detail";
    }

    @GetMapping("/create")
    public String create(ArticleForm articleForm) {
        return "article_form";
    }

    @PostMapping("/create")
    public String articleCreate(@Valid ArticleForm articleForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "article_form";
        }
        this.articleService.create(articleForm.getTitle(), articleForm.getContent());
        return "redirect:/article/list";
    }

    @GetMapping("/modify/{id}")
    public String articleModify(ArticleForm articleForm, @PathVariable("id") Integer id) {
        Article article = this.articleService.getArticle(id);
        articleForm.setTitle(article.getTitle());
        articleForm.setContent(article.getContent());
        return "article_form";
    }

    @PostMapping("/modify/{id}")
    public String articleModify(@Valid ArticleForm articleForm, @PathVariable("id") Integer id, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "article_form";
        }
        Article article = this.articleService.getArticle(id);
        this.articleService.modify(article, articleForm.getTitle(), articleForm.getContent());
        return "redirect:/article/detail/{id}";
    }

    @GetMapping("/delete/{id}")
    public String articleDelete(@PathVariable("id") Integer id) {
        Article article = this.articleService.getArticle(id);
        this.articleService.delete(article);
        return "redirect:/article/list";
    }
}
