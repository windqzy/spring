/*
 * Copyright 2002-2022 the original author or authors.
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

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

import org.springframework.lang.Nullable;

/**
 * Interface for a resource descriptor that abstracts from the actual
 * type of underlying resource, such as a file or class path resource.
 * 这个接口是为了一个资源的描述者，它抽象底层资源的实际类型，例如文件或者类路径资源。
 * <p>An InputStream can be opened for every resource if it exists in
 * physical form, but a URL or File handle can just be returned for
 * certain resources. The actual behavior is implementation-specific.
 * 每个资源，只要它作为一个物理形式存在，就能作为一个输入流被打开，并且为某些特定资源
 * 返回一个url或者一个文件句柄。这实际的行为依赖于特定实现。
 *
 * @author Juergen Hoeller
 * @since 28.12.2003
 * @see #getInputStream()
 * @see #getURL()
 * @see #getURI()
 * @see #getFile()
 * @see WritableResource
 * @see ContextResource
 * @see UrlResource
 * @see FileUrlResource
 * @see FileSystemResource
 * @see ClassPathResource
 * @see ByteArrayResource
 * @see InputStreamResource
 */
public interface Resource extends InputStreamSource {

	/**
	 * Determine whether this resource actually exists in physical form.
	 * <p>This method performs a definitive existence check, whereas the
	 * existence of a {@code Resource} handle only guarantees a valid
	 * descriptor handle.
	 *
	 * 确定一个资源是否以物理形式实际存在。
	 * 这个方法执行一个明确的存在性检查，
	 * 但是一个句柄的存在性只是保证了有一个有效的句柄描述符存在。
	 */
	boolean exists();

	/**
	 * Indicate whether non-empty contents of this resource can be read via
	 * {@link #getInputStream()}.
	 * 指示是否可以通过getInputStream去读取文件的非空内容。
	 * <p>Will be {@code true} for typical resource descriptors that exist
	 * since it strictly implies {@link #exists()} semantics as of 5.1.
	 * Note that actual content reading may still fail when attempted.
	 * However, a value of {@code false} is a definitive indication
	 * that the resource content cannot be read.
	 * 实际是依赖exsit方法的判断结果进行是否可读的判断。
	 * @see #getInputStream()
	 * @see #exists()
	 */
	default boolean isReadable() {
		return exists();
	}

	/**
	 * Indicate whether this resource represents a handle with an open stream.
	 * 指示这个资源表达了他是一个已经打开的流的句柄。
	 * If {@code true}, the InputStream cannot be read multiple times,
	 * and must be read and closed to avoid resource leaks.
	 * 如果资源打开的情况下，不能被多次读，想要读的话需要关闭资源避免资源泄漏。
	 * <p>Will be {@code false} for typical resource descriptors.
	 * 正常情况下将会返回false。
	 */
	default boolean isOpen() {
		return false;
	}

	/**
	 * Determine whether this resource represents a file in a file system.
	 * 判断这个资源是否表示一个文件系统里的一个文件。
	 * <p>A value of {@code true} strongly suggests (but does not guarantee)
	 * that a {@link #getFile()} call will succeed.
	 * 返回true强烈暗示但是不保证getFile文件的调用将会成功。
	 * <p>This is conservatively {@code false} by default.
	 * 保守情况下，默认返回false.
	 * @since 5.0
	 * @see #getFile()
	 */
	default boolean isFile() {
		return false;
	}

	/**
	 * Return a URL handle for this resource.
	 * 返回一个url句柄为这个资源
	 * @throws IOException if the resource cannot be resolved as URL,
	 * i.e. if the resource is not available as a descriptor
	 */
	URL getURL() throws IOException;

	/**
	 * Return a URI handle for this resource.
	 * 返回一个URI为这个资源
	 * @throws IOException if the resource cannot be resolved as URI,
	 * i.e. if the resource is not available as a descriptor
	 * @since 2.5
	 */
	URI getURI() throws IOException;

	/**
	 * Return a File handle for this resource.
	 * 为这个资源返回一个文件句柄。
	 * @throws java.io.FileNotFoundException if the resource cannot be resolved as
	 * absolute file path, i.e. if the resource is not available in a file system
	 * 如果这个资源不能作为绝对文件路径被解析。
	 * 如果这
	 * @throws IOException in case of general resolution/reading failures
	 * @see #getInputStream()
	 */
	File getFile() throws IOException;

	/**
	 * Return a {@link ReadableByteChannel}.
	 * <p>It is expected that each call creates a <i>fresh</i> channel.
	 * <p>The default implementation returns {@link Channels#newChannel(InputStream)}
	 * with the result of {@link #getInputStream()}.
	 * @return the byte channel for the underlying resource (must not be {@code null})
	 * @throws java.io.FileNotFoundException if the underlying resource doesn't exist
	 * @throws IOException if the content channel could not be opened
	 * @since 5.0
	 * @see #getInputStream()
	 */
	default ReadableByteChannel readableChannel() throws IOException {
		return Channels.newChannel(getInputStream());
	}

	/**
	 * Determine the content length for this resource.
	 * 确定这个资源的内容长度。
	 * @throws IOException if the resource cannot be resolved
	 * (in the file system or as some other known physical resource type)
	 */
	long contentLength() throws IOException;

	/**
	 * Determine the last-modified timestamp for this resource.
	 * 确定这个资源的最后一次修改的时间戳。
	 * @throws IOException if the resource cannot be resolved
	 * (in the file system or as some other known physical resource type)
	 */
	long lastModified() throws IOException;

	/**
	 * Create a resource relative to this resource.
	 *
	 * @param relativePath the relative path (relative to this resource)
	 * @return the resource handle for the relative resource
	 * @throws IOException if the relative resource cannot be determined
	 */
	Resource createRelative(String relativePath) throws IOException;

	/**
	 * Determine a filename for this resource, i.e. typically the last
	 * part of the path: for example, "myfile.txt".
	 * <p>Returns {@code null} if this type of resource does not
	 * have a filename.
	 * 确定这个资源的文件名，通常是路径的最后一部分
	 * 如果这个资源没有文件名则返回null
	 */
	@Nullable
	String getFilename();

	/**
	 * Return a description for this resource,
	 * to be used for error output when working with the resource.
	 * 返回这个资源的描述符，通常用于这个资源工作时候的错误输出
	 * <p>Implementations are also encouraged to return this value
	 * from their {@code toString} method.
	 * 在实现中是鼓励从他们的toString方法中返回这个值。
	 * @see Object#toString()
	 */
	String getDescription();

}
