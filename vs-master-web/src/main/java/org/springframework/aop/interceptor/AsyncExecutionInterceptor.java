package org.springframework.aop.interceptor;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.AopContext;
import org.springframework.aop.support.AopUtils;
import org.springframework.core.BridgeMethodResolver;
import org.springframework.core.Ordered;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;

/**
 * <p>
 * </p>
 * 
 * @author Hu Dawei
 * @version 1.0
 */
public class AsyncExecutionInterceptor extends AsyncExecutionAspectSupport
		implements MethodInterceptor, Ordered {

	public AsyncExecutionInterceptor(Executor executor) {
		super(executor);
	}

	public Object invoke(final MethodInvocation invocation) throws Throwable {
		Class<?> targetClass = (invocation.getThis() != null ? AopUtils
				.getTargetClass(invocation.getThis()) : null);
		Method specificMethod = ClassUtils.getMostSpecificMethod(
				invocation.getMethod(), targetClass);
		specificMethod = BridgeMethodResolver.findBridgedMethod(specificMethod);

		final Method setCurrentProxyMethod = ReflectionUtils.findMethod(
				AopContext.class, "setCurrentProxy", Object.class);

		final Object currentProxy = AopContext.currentProxy();
		ReflectionUtils.makeAccessible(setCurrentProxyMethod);
		Future<?> result = determineAsyncExecutor(specificMethod).submit(
				new Callable<Object>() {
					public Object call() throws Exception {
						try {
							if (currentProxy != null) {
								ReflectionUtils.invokeMethod(
										setCurrentProxyMethod, null,
										currentProxy);
							}
							Object result = invocation.proceed();
							if (result instanceof Future) {
								return ((Future<?>) result).get();
							}
						} catch (Throwable ex) {
							ReflectionUtils.rethrowException(ex);
						} finally {
							if (currentProxy != null) {
								ReflectionUtils.invokeMethod(
										setCurrentProxyMethod, null,
										(Object) null);
							}
						}
						return null;
					}
				});

		if (Future.class.isAssignableFrom(invocation.getMethod()
				.getReturnType())) {
			return result;
		} else {
			return null;
		}
	}

	@Override
	protected String getExecutorQualifier(Method method) {
		return null;
	}

	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE;
	}

}
