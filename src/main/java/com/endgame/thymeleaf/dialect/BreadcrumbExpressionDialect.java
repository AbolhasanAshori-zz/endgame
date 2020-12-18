package com.endgame.thymeleaf.dialect;

import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

import com.endgame.thymeleaf.expression.BreadcrumbExpressionObjectFactory;

public class BreadcrumbExpressionDialect extends AbstractDialect implements IExpressionObjectDialect {

	private final IExpressionObjectFactory BREADCRUMB_EXPRESSION_OBJECT_FACTORY = 
			new BreadcrumbExpressionObjectFactory();

	public BreadcrumbExpressionDialect() {
		super("breadcrumb");
	}

	@Override
	public IExpressionObjectFactory getExpressionObjectFactory() {
		return BREADCRUMB_EXPRESSION_OBJECT_FACTORY;
	}
	
}
