package com.java96.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.imgscalr.Scalr;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/upload/*")
public class UploadController {

	@GetMapping("/input")
	public void input() {
		
	}
	
	@GetMapping("/thumb/{thumbName:.+}")
	public @ResponseBody byte[] display(@PathVariable("thumbName")String  thumbName )throws Exception {
		
		File file = new File("C:\\zzz\\"+ thumbName );
		
		return FileUtils.readFileToByteArray(file);
		
	}
	
	
	
	
	@PostMapping(value= "/")
	public @ResponseBody Map<String, String> upload(@RequestParam("file") MultipartFile file) throws Exception{
	
		System.out.println("========================UPLOAD============================");
		
		
		UUID uuid = UUID.randomUUID();
		
		String uploadName = uuid.toString()+"_"+file.getOriginalFilename();
		

		
		OutputStream out = new FileOutputStream("C:\\zzz\\"+ uploadName);
		
		
		
		FileCopyUtils.copy(file.getInputStream(), out);
		
		BufferedImage origin = ImageIO.read(file.getInputStream());
		
		BufferedImage destImg = Scalr.resize(origin, 
			            Scalr.Method.AUTOMATIC, 
			            Scalr.Mode.FIT_TO_HEIGHT,100);
		
		String thumbnailName = "s_"+ uploadName;
		
		ImageIO.write(destImg, "jpg", new FileOutputStream("C:\\zzz\\" + thumbnailName));

		Map<String, String> map = new HashMap<>();
		map.put("original", file.getOriginalFilename());
		map.put("uploadName", uploadName);
		map.put("thumbName", thumbnailName);
		
		return map;

	}
	
}
