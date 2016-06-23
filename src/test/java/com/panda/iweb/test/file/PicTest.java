package com.panda.iweb.test.file;

import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;

import org.junit.Test;

import com.panda.iweb.util.ImageUtil;

public class PicTest {
	private File sourcePng = new File("D:/test/p1.png");
	private File targetPng = new File("D:/test/p1_1.png");

	private File sourceJpg = new File("D:/test/j1.jpg");
	private File targetJpg = new File("D:/test/j1_1.jpg");

	// 按比例压缩
	@Test
	public void compress_ratio_png() {
		try {
			Thumbnails.of(sourcePng).size(80, 80).toFile(targetPng);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 不按比例压缩
	@Test
	public void compress_not_ratio_png() {
		try {
			Thumbnails.of(sourcePng).size(80, 80).keepAspectRatio(false).toFile(targetPng);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 按比例压缩
	@Test
	public void compress_ratio_jpg() {
		try {
			Thumbnails.of(sourceJpg).size(80, 80).toFile(targetJpg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// 不按比例压缩
	@Test
	public void compress_not_ratio_jpg() {
		try {
			Thumbnails.of(sourceJpg).size(80, 80).keepAspectRatio(false).toFile(targetJpg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void local_compress() {
		ImageUtil.size(sourcePng, targetPng, 200, 200, false);
		ImageUtil.size(sourceJpg, targetJpg, 200, 200, false);
	}

}
