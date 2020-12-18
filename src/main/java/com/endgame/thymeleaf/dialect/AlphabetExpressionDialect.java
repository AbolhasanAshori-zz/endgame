package com.endgame.thymeleaf.dialect;

import com.endgame.thymeleaf.expression.AlphabetExpressionObjectFactory;
import org.thymeleaf.dialect.AbstractDialect;
import org.thymeleaf.dialect.IExpressionObjectDialect;
import org.thymeleaf.expression.IExpressionObjectFactory;

public class AlphabetExpressionDialect extends AbstractDialect implements IExpressionObjectDialect {

	private final IExpressionObjectFactory ALPHABET_EXPRESSION_OBJECT_FACTORY =
			new AlphabetExpressionObjectFactory();

	public AlphabetExpressionDialect() {
		super("alphabet");
	}

	@Override
	public IExpressionObjectFactory getExpressionObjectFactory() {
		return ALPHABET_EXPRESSION_OBJECT_FACTORY;
	}
}
