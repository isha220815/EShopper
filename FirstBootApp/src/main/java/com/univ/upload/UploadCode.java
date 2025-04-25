package com.univ.upload;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadCode {

	public final String Path1="D:\\Advance Java\\SpringBoot\\FirstBootApp\\FirstBootApp\\src\\main\\webapp\\assets\\img";
	public boolean uploadFile(MultipartFile f) {
		boolean ff=false;
		try {
			Path destinationPath= Paths.get(Path1 + "\\" + f.getOriginalFilename());
			Files.copy(f.getInputStream(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
		}catch(Exception tt) {
			System.out.println(tt);
		}
		return ff;
	}
}
