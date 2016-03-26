package com.vshuok.es.common.web.controller;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.vshuok.es.common.Constants;
import com.vshuok.es.common.utils.ImagesUtils;
import com.vshuok.es.common.utils.LogUtils;
import com.vshuok.es.common.utils.MessageUtils;
import com.vshuok.es.common.web.entity.AjaxUploadResponse;
import com.vshuok.es.common.web.upload.FileUploadUtils;
import com.vshuok.es.common.web.upload.exception.FileNameLengthLimitExceededException;
import com.vshuok.es.common.web.upload.exception.InvalidExtensionException;

/**
 * <p>
 * ajax文件上传/下载
 * </p>
 * 
 * @author Hu Dawei
 * @version 1.0
 */
@Controller
public class AjaxUploadController {

	// 最大上传大小 字节为单位
	private final long maxSize = FileUploadUtils.DEFAULT_MAX_SIZE;
	// 允许的文件内容类型
	private final String[] allowedExtension = FileUploadUtils.DEFAULT_ALLOWED_EXTENSION;
	// 文件上传下载的父目录
	private final String baseDir = FileUploadUtils.getDefaultBaseDir();

	@RequestMapping(value = "ajaxUpload", method = RequestMethod.POST)
	@ResponseBody
	public AjaxUploadResponse ajaxUpload(
			HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "files[]", required = false) MultipartFile[] files) {
		response.setContentType("text/plain");

		AjaxUploadResponse ajaxUploadResponse = new AjaxUploadResponse();

		if (ArrayUtils.isEmpty(files)) {
			return ajaxUploadResponse;
		}

		for (MultipartFile file : files) {
			String filename = file.getOriginalFilename();
			long size = file.getSize();

			try {
				String url = FileUploadUtils.upload(request, baseDir, file,
						allowedExtension, maxSize, true);
				String deleteURL = "/ajaxUpload/delete?filename="
						+ URLEncoder.encode(url, Constants.ENCODING);
				if (ImagesUtils.isImage(filename)) {
					ajaxUploadResponse.add(filename, size, url, url, deleteURL);
				} else {
					ajaxUploadResponse.add(filename, size, url, deleteURL);
				}
			} catch (IOException e) {
				LogUtils.logError("file upload error", e);
				ajaxUploadResponse.add(filename, size,
						MessageUtils.message("upload.server.error"));
			} catch (InvalidExtensionException e) {
				ajaxUploadResponse.add(filename, size,
						MessageUtils.message("upload.not.allow.extension"));
			} catch (FileUploadBase.FileSizeLimitExceededException e) {
				ajaxUploadResponse.add(filename, size,
						MessageUtils.message("upload.exceed.maxSize"));
			} catch (FileNameLengthLimitExceededException e) {
				ajaxUploadResponse.add(filename, size,
						MessageUtils.message("upload.filename.exceed.length"));
			}
		}
		return ajaxUploadResponse;
	}

	@RequestMapping(value = "ajaxUpload/delete", method = RequestMethod.POST)
	@ResponseBody
	public String ajaxUploadDelete(HttpServletRequest request,
			@RequestParam(value = "filename") String filename) throws Exception {
		if (StringUtils.isEmpty(filename) || filename.contains("\\.\\.")) {
			return "";
		}
		filename = URLDecoder.decode(filename, Constants.ENCODING);

		String filePath = FileUploadUtils.extractUploadDir(request) + "/"
				+ filename;
		File file = new File(filePath);
		file.deleteOnExit();
		return "";
	}
}
