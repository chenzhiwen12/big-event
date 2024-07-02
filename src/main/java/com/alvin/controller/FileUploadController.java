package com.alvin.controller;

import com.alvin.pojo.Result;
import com.alvin.utils.AliOssUtil;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * packageName com.alvin.controller
 *
 * @author 你的名字
 * @version JDK 8
 * @className FileUploadController (此处以class为例)
 * @date 2024/7/2 星期二
 * @description TODO
 */
@RestController
public class FileUploadController {
	@PostMapping("/upload")
	public Result<String> upload(MultipartFile file) throws IOException {
		String originalFilename = file.getOriginalFilename();
		String fileName = UUID.randomUUID().toString()
				+ originalFilename.substring(originalFilename.lastIndexOf("."));
		/**
		 * 将文件上传到阿里云服务保存
		 */
		/*final String url = AliOssUtil.uploadFile(fileName, file.getInputStream());
		return Result.success(url);*/
		file.transferTo(new File("C:\\Users\\Administrator\\Desktop\\files\\" + fileName));
		return Result.success("URL访问地址是");
	}
}
