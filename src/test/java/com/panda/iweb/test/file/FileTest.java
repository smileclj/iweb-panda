package com.panda.iweb.test.file;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.panda.iweb.util.common.HttpUtil;

public class FileTest {
	@Test
	public void file() throws IOException {
		// File file = new File("C:/Users/wana/Desktop/test/1.txt");

		File file = new File("C:\\Users\\wana\\Desktop\\test\\1.txt");
		System.out.println("name:" + file.getName());
		System.out.println("absolutePath:" + file.getAbsolutePath());
		System.out.println("canonicalPath:" + file.getCanonicalPath());
		System.out.println("freeSpace:" + file.getFreeSpace());
		System.out.println("parent:" + file.getParent());
		System.out.println("path:" + file.getPath());
		System.out.println("total:" + file.getTotalSpace());

		System.out.println("=============");

		String folder = file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf(File.separatorChar) + 1);
		System.out.println("folder:" + folder);
		String suffix = file.getName().substring(file.getName().lastIndexOf("."));
		System.out.println("suffix:" + suffix);
		String fileName = file.getName().substring(0, file.getName().lastIndexOf("."));
		System.out.println("fileName:" + fileName);
	}

	@Test
	public void uploadForRename() {
		String url = "http://localhost:8080/maven-file-service/file/service/uploadForRename.json";
		Map<String, File> files = new HashMap<String, File>();
		File file = new File("C:\\Users\\wana\\Desktop\\test\\1.txt");
		files.put("file", file);
		System.out.println(HttpUtil.uploadFiles(url, null, files));
	}

	@Test
	public void download() {
		String url = "http://localhost:8080/maven-file-service/file/service/downloadFile.json";
		Map<String, String> params = new HashMap<String, String>();
		params.put("resourceId", "879518-8baff3f4578343ab9613e31fd1c384d6");
		File target = new File("D:\\2.txt");
		HttpUtil.downloadFile(url, params, target);
	}
}
