package br.site.service;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PathService {
	
	@Autowired
	private ServletContext context;
	
	private static final String DIR = "/site/content";
			
	private static final String PHOTO_PATH = "/photos/patients/";

	private static final String DEMO_VIDEO_PATH = "/video/demo/";
	
	private static final String DEMO_AUDIO_PATH = "/audio/demo/";
	
	private static final String RECORD_PATH = "/record/";
	
	private static final String REAL_PATH = "/WEB-INF/content/";
	
	public String createAbsolutePhotoPath(String fileName) {
		return getRealPath() + PHOTO_PATH + fileName;
	}
	
	public String createPhotoPath(String fileName) {
		return DIR + PHOTO_PATH + fileName;
	}
	
	public String createAbsoluteVideoDemoPath(String fileName) {
		return getRealPath() + DEMO_VIDEO_PATH + fileName;
	}
	
	public String createAbsoluteAudioDemoPath(String fileName) {
		return getRealPath() + DEMO_AUDIO_PATH + fileName;
	}
	
	public String createAbsoluteAudioPath(String fileName) {
		return getRealPath() + RECORD_PATH + fileName;
	}

	
	public String createAudioPath(String fileName) {
		return DIR + RECORD_PATH + fileName;
	}
	
	public String createAudioDemoPath(String fileName) {
		return DIR + DEMO_AUDIO_PATH + fileName;
	}
	
	private String getRealPath() {
		return context.getRealPath(REAL_PATH);
	}
	
}
