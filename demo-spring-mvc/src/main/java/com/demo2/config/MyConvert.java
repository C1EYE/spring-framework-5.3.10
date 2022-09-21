package com.demo2.config;

import com.alibaba.fastjson2.JSON;
import com.demo2.model.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;

/**
 * @author Yuan
 * @description MyConvert
 * @date 2022/9/21
 */
public class MyConvert implements HttpMessageConverter<User> {
	@Override
	public boolean canRead(Class<?> clazz, MediaType mediaType) {
		if (mediaType == null) {
			return false;
		}
		if (mediaType.includes(MediaType.APPLICATION_JSON) && clazz == User.class) {
			return true;
		}
		return false;
	}

	@Override
	public boolean canWrite(Class<?> clazz, MediaType mediaType) {
		return canRead(clazz, mediaType);
	}

	@Override
	public List<MediaType> getSupportedMediaTypes() {
		return Collections.singletonList(MediaType.APPLICATION_JSON);
	}

	@Override
	public User read(Class<? extends User> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
		System.out.println("读");
		InputStream body = inputMessage.getBody();
		User result = JSON.parseObject(body, User.class);
		return result;
	}

	@Override
	public void write(User user, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
		System.out.println("写");
		OutputStream body = outputMessage.getBody();
		String s = JSON.toJSONString(user);
		body.write(s.getBytes(StandardCharsets.UTF_8));
	}
}
