package com.endgame.thymeleaf.expression;

import com.endgame.thymeleaf.util.AlphabetUtils;
import org.thymeleaf.context.IExpressionContext;
import org.thymeleaf.expression.IExpressionObjectFactory;

import java.util.Collections;
import java.util.Set;

public class AlphabetExpressionObjectFactory implements IExpressionObjectFactory {

	private static final String EXPRESSION_OBJECT_NAME = "alphabet";

	@Override
	public Set<String> getAllExpressionObjectNames() {
		return Collections.singleton(EXPRESSION_OBJECT_NAME);
	}

	@Override
	public Object buildObject(IExpressionContext context, String expressionObjectName) {
		return new AlphabetUtils();
	}

	@Override
	public boolean isCacheable(String expressionObjectName) {
		return true;
	}
}
