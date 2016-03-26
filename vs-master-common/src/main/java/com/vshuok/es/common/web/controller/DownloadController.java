package com.vshuok.es.common.web.controller;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import com.vshuok.es.common.Constants;
import com.vshuok.es.common.web.upload.FileUploadUtils;
import com.vshuok.es.common.web.utils.DownloadUtils;

/** 
 * <p>文件上传/下载</p>
 * @author Hu Dawei  
 * @version 1.0
 */
@Controller
public class DownloadController {
	
	public String download(HttpServletRequest request, HttpServletResponse response,
            @RequestParam(value = "filename") String filename) throws Exception {
		
		filename=filename.replace("/", "\\");
		
		if(StringUtils.isEmpty(filename)||filename.contains("\\.\\.")){
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write("您下载的文件不存在!");
			return null;
		}
		filename = URLDecoder.decode(filename, Constants.ENCODING);
		

        String filePath = FileUploadUtils.extractUploadDir(request) + "/" + filename;

        DownloadUtils.download(request, response, filePath, filename);

        return null;
	}
}
