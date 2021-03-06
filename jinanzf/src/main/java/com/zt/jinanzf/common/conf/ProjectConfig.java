package com.zt.jinanzf.common.conf;

import java.io.File;
import java.util.ResourceBundle;

import org.joda.time.DateTime;
public class ProjectConfig {

	private ProjectConfig() {
		
	}
	
	public static final String PROJECT_VERSION;
	
    public static final String FILE_SAVE_DISK;
    
    static {
    	PROJECT_VERSION = new DateTime().toString("yyyyMMddHHmmss");
    	ResourceBundle resource = ResourceBundle.getBundle("application");
    	FILE_SAVE_DISK = resource.getString("common.file.saveDisk") + File.separator;
    }
    
}
