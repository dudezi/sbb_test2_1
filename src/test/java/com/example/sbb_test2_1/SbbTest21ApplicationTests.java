package com.example.sbb_test2_1;

import com.example.sbb_test2_1.article.Article;
import com.example.sbb_test2_1.article.ArticleRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class SbbTest21ApplicationTests {
	@Autowired
	private ArticleRepository articleRepository;

	@Test
	void test() {
		Article a1 = new Article();
		a1.setTitle("test07");
		a1.setContent("test07");
		a1.setCreateDate(LocalDateTime.now());
		this.articleRepository.save(a1);
	}

}
