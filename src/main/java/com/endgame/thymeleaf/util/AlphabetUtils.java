package com.endgame.thymeleaf.util;

import java.util.ArrayList;
import java.util.List;

public class AlphabetUtils {

	public List<String> getAlphabet(final String start,final String end) {
		Character charStart = start.length() == 1 ? start.charAt(0) : null;
		Character charEnd = end.length() == 1 ? end.charAt(0) : null;
		List<String> chars = new ArrayList<>();

		if (charStart != null && charEnd != null && charStart < charEnd)
			for (Character c = charStart; c <= charEnd; c++)
				if (Character.isLetter(c))
					chars.add(c.toString());

		return chars.isEmpty() ? null : chars;
	}
}
