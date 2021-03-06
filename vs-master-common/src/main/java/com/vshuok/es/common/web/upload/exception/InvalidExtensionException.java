package com.vshuok.es.common.web.upload.exception;

import java.util.Arrays;

import org.apache.commons.fileupload.FileUploadException;

/**
 * <p>
 * </p>
 * 
 * @author Hu Dawei
 * @version 1.0
 */
public class InvalidExtensionException extends FileUploadException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8207706928007737611L;
	private String[] allowedExtension;
	private String extension;
	private String filename;

	public InvalidExtensionException(String[] allowedExtension,
			String extension, String filename) {
		super("filename : [" + filename + "], extension : [" + extension
				+ "], allowed extension : ["
				+ Arrays.toString(allowedExtension) + "]");
		this.allowedExtension = allowedExtension;
		this.extension = extension;
		this.filename = filename;
	}

	public String[] getAllowedExtension() {
		return allowedExtension;
	}

	public String getExtension() {
		return extension;
	}

	public String getFilename() {
		return filename;
	}

	public static class InvalidImageExtensionException extends
			InvalidExtensionException {
		public InvalidImageExtensionException(String[] allowedExtension,
				String extension, String filename) {
			super(allowedExtension, extension, filename);
		}
	}

	public static class InvalidFlashExtensionException extends
			InvalidExtensionException {
		public InvalidFlashExtensionException(String[] allowedExtension,
				String extension, String filename) {
			super(allowedExtension, extension, filename);
		}
	}

	public static class InvalidMediaExtensionException extends
			InvalidExtensionException {
		public InvalidMediaExtensionException(String[] allowedExtension,
				String extension, String filename) {
			super(allowedExtension, extension, filename);
		}
	}

}
