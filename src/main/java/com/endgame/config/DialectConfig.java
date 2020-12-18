package com.endgame.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.dialect.IDialect;

import com.endgame.thymeleaf.dialect.AlphabetExpressionDialect;
import com.endgame.thymeleaf.dialect.BreadcrumbExpressionDialect;

@Configuration
public class DialectConfig {

	@Bean
	public IDialect alphabetExpressionDialect() {
		return new AlphabetExpressionDialect();
	}
	
	@Bean
	public IDialect breadcrumbExpressionDialect() {
		return new BreadcrumbExpressionDialect();
	}
}
