package br.site.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import br.site.service.FileService;
import br.site.service.PathService;

@Controller
@RequestMapping("upload")
public class UploadController {
	
	@Autowired
	private PathService pathService;
	
	@Autowired
	private FileService fileService;
	
	private static final String UPLOAD_VIDEO_PAGE = "video";
	
	@RequestMapping(value="/video", method=RequestMethod.POST)
	public String upload(MultipartFile file, String fileName) throws IllegalStateException, IOException {
		String path = pathService.createAbsoluteVideoDemoPath(fileService.createVideoFileName(fileName));
		File video = new File(path);
		file.transferTo(video);
		return UPLOAD_VIDEO_PAGE;
	}
	
	@RequestMapping("video")
	public String video() {
		return UPLOAD_VIDEO_PAGE;
	}
	
}
