package com.vshuok.es.common.web.bind.method.annotation;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolverComposite;
import org.springframework.web.servlet.HandlerMapping;

/**
 * <p>
 * </p>
 * 
 * @author Hu Dawei
 * @version 1.0
 */
public abstract class BaseMethodArgumentResolver extends
		HandlerMethodArgumentResolverComposite {

	protected Map<String, String[]> getPrefixParameterMap(String namePrefix,
			NativeWebRequest request, boolean subPrefix) {
		Map<String, String[]> result = new HashMap<String, String[]>();

		Map<String, String> variables = getUriTempleVariables(request);

		int namePrefixLength = namePrefix.length();
		for (String name : variables.keySet()) {
			if (name.startsWith(namePrefix)) {

				// page.pn 则截取 pn
				if (subPrefix) {
					char ch = name.charAt(namePrefix.length());
					// 如果下一个字符不是 数字 . _ 则不可能是查询 只是前缀类似
					if (illegalChar(ch)) {
						continue;
					}
					result.put(name.substring(namePrefixLength + 1),
							new String[] { variables.get(name) });
				} else {
					result.put(name, new String[] { variables.get(name) });
				}
			}
		}

		Iterator<String> parameterNames = request.getParameterNames();
		while (parameterNames.hasNext()) {
			String name = parameterNames.next();
			if (name.startsWith(namePrefix)) {
				// page.pn 则截取 pn
				if (subPrefix) {
					char ch = name.charAt(namePrefix.length());
					// 如果下一个字符不是 数字 . _ 则不可能是查询 只是前缀类似
					if (illegalChar(ch)) {
						continue;
					}
					result.put(name.substring(namePrefixLength + 1),
							request.getParameterValues(name));
				} else {
					result.put(name, request.getParameterValues(name));
				}
			}
		}

		return result;
	}

	private boolean illegalChar(char ch) {
		return ch != '.' && ch != '_' && !(ch >= '0' && ch <= '9');
	}

	@SuppressWarnings("unchecked")
	protected final Map<String, String> getUriTempleVariables(
			NativeWebRequest request) {
		Map<String, String> variables = (Map<String, String>) request
				.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE,
						RequestAttributes.SCOPE_REQUEST);
		return (variables != null) ? variables : Collections
				.<String, String> emptyMap();
	}
}
