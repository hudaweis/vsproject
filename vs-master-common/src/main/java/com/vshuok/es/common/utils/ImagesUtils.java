package com.vshuok.es.common.utils;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.ArrayUtils;

/** 
 * <p></p>
 * @author Hu Dawei  
 * @version 1.0
 */
public class ImagesUtils {

	private static final String[] IMAGES_SUFFIXES={
		"bmp", "jpg", "jpeg", "gif", "png", "tiff"
	};
	
	public static boolean isImage(String filename){
		if(filename==null||filename.trim().length()==0) return false;
		return ArrayUtils.contains(IMAGES_SUFFIXES, FilenameUtils.getExtension(filename).toLowerCase());
	}
}
