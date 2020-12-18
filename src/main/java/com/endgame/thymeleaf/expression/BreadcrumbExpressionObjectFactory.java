package com.endgame.thymeleaf.expression;

import java.util.Collections;
import java.util.Set;

import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.expression.IExpressionObjectFactory;

import com.endgame.thymeleaf.util.BreadcrumbUtils;

public class BreadcrumbExpressionObjectFactory implements IExpressionObjectFactory {
	
	private static final String EXPRESSION_OBJECT_NAME = "breadcrumb";

	@Override
	public Set<String> getAllExpressionObjectNames() {
		return Collections.singleton(EXPRESSION_OBJECT_NAME);
	}

	@Override
	public Object buildObject(IExpressionContext context, String expressionObjectName) {
		return new BreadcrumbUtils();
	}

	@Override
	public boolean isCacheable(String expressionObjectName) {
		return true;
	}

}
