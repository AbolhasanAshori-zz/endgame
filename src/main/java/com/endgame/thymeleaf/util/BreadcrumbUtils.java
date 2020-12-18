package com.endgame.thymeleaf.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BreadcrumbUtils {
	
	public Map<String, String> getBreadcrumb(final String uri) {
		Map<String, String> urls = new LinkedHashMap<>();
		
		List<String> uris = new ArrayList<>(Arrays.asList(uri.substring(1).split("/")));
		
		Iterator<String> uriIter = uris.iterator();
		
		if (uriIter.hasNext())
			for (int i = 1; i < uri.length(); i++)
				if (uri.charAt(i) == '/')
					urls.put(uriIter.next(), uri.substring(0, i));
		
		if (!uri.endsWith("/"))
			urls.put(uriIter.next(), uri);
		
		return urls.isEmpty() ? null : urls;
	}
}
