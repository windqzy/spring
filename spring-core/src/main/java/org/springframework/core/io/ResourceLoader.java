/*
 * Copyright 2002-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.core.io;

import org.springframework.lang.Nullable;
import org.springframework.util.ResourceUtils;

/**
 * Strategy interface for loading resources (e.g., class path or file system
 * resources). An {@link org.springframework.context.ApplicationContext}
 * is required to provide this functionality plus extended
 * {@link org.springframework.core.io.support.ResourcePatternResolver} support.
 *
 *
 * <p>{@link DefaultResourceLoader} is a standalone implementation that is
 * usable outside an ApplicationContext and is also used by {@link ResourceEditor}.
 *
 * <p>Bean properties of type {@code Resource} and {@code Resource[]} can be populated
 * from Strings when running in an ApplicationContext, using the particular
 * context's resource loading strategy.
 *
 * @author Juergen Hoeller
 * @since 10.03.2004
 * @see Resource
 * @see org.springframework.core.io.support.ResourcePatternResolver
 * @see org.springframework.context.ApplicationContext
 * @see org.springframework.context.ResourceLoaderAware
 */
public interface ResourceLoader {

	/** Pseudo URL prefix for loading from the class path: "classpath:". */
	String CLASSPATH_URL_PREFIX = ResourceUtils.CLASSPATH_URL_PREFIX;


	/**
	 * Return a {@code Resource} handle for the specified resource location.
	 * 返回一个资源句柄从一个特定的资源位置
	 * <p>The handle should always be a reusable resource descriptor,
	 * allowing for multiple {@link Resource#getInputStream()} calls.
	 * 这个资源句柄应该总是一个可重用的资源描述符，允许多次Resource#getInputStream()} 调用
	 * <p><ul>
	 * <li>Must support fully qualified URLs, e.g. "file:C:/test.dat".
	 * 必须支持正确的URL
	 * <li>Must support classpath pseudo-URLs, e.g. "classpath:test.dat".
	 * 必须支持伪URL类路径
	 * <li>Should support relative file paths, e.g. "WEB-INF/test.dat".
	 * 应该支持相对文件路径
	 * (This will be implementation-specific, typically provided by an
	 * ApplicationContext implementation.)
	 * 这将是一个特定实现，通常由一个应用上下文的实现提供
	 * </ul>
	 * <p>Note that a {@code Resource} handle does not imply an existing resource;
	 * 注意：一个资源句柄存在不暗示确实存在一个资源
	 * you need to invoke {@link Resource#exists} to check for existence.
	 * 你需要调用Resource#exists方法去检查资源的存在性
	 * @param location the resource location 资源的位置
	 * @return a corresponding {@code Resource} handle (never {@code null})
	 * 返回一个相关的文件句柄，绝对不会为null
	 * @see #CLASSPATH_URL_PREFIX
	 * @see Resource#exists()
	 * @see Resource#getInputStream()
	 */
	Resource getResource(String location);

	/**
	 * Expose the {@link ClassLoader} used by this {@code ResourceLoader}.
	 * 暴露这个资源加载器使用的类加载器
	 * <p>Clients which need to access the {@code ClassLoader} directly can do so
	 * in a uniform manner with the {@code ResourceLoader}, rather than relying
	 * on the thread context {@code ClassLoader}.
	 * 需要访问类加载器的客户端可以直接使用这资源加载器的类加载器，而不是依赖线程上下问的类加载器。
	 * @return the {@code ClassLoader}
	 * 返回类加载器。
	 * (only {@code null} if even the system {@code ClassLoader} isn't accessible)
	 * @see org.springframework.util.ClassUtils#getDefaultClassLoader()
	 * @see org.springframework.util.ClassUtils#forName(String, ClassLoader)
	 */
	@Nullable
	ClassLoader getClassLoader();

}
