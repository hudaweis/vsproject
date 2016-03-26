package com.vshuok.es.common.web.upload.exception;

import org.apache.commons.fileupload.FileUploadException;

/** 
 * <p>文件名超长</p>
 * @author Hu Dawei  
 * @version 1.0
 */
public class FileNameLengthLimitExceededException extends FileUploadException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -82834354926759241L;
	private int length;
	private int maxLength;
	private String filename;
	
	public FileNameLengthLimitExceededException(String filename, int length, int maxLength) {
        super("file name : [" + filename + "], length : [" + length + "], max length : [" + maxLength + "]");
        this.length = length;
        this.maxLength = maxLength;
        this.filename = filename;
    }
	
	public String getFilename(){
		return filename;
	}
	
	public int getLength(){
		return length;
	}
	
	public int getMaxLength(){
		return maxLength;
	}
}
