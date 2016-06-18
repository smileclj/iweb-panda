package com.panda.iweb.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageUtil {

	// proportion true为等比压缩
	public static void size(File source, File target, int width, int height, boolean proportion) {
		try {
			String formatName = source.getName().substring(source.getName().lastIndexOf(".") + 1);
			BufferedImage bi = ImageIO.read(source);
			int newWidth;
			int newHeight;
			// 判断是否是等比缩放
			if (proportion == true) {
				// 为等比缩放计算输出的图片宽度及高度
				double rate1 = ((double) bi.getWidth(null)) / (double) width + 0.1;
				double rate2 = ((double) bi.getHeight(null)) / (double) height + 0.1;
				// 根据缩放比率大的进行缩放控制
				double rate = rate1 < rate2 ? rate1 : rate2;
				newWidth = (int) (((double) bi.getWidth(null)) / rate);
				newHeight = (int) (((double) bi.getHeight(null)) / rate);
			} else {
				newWidth = width; // 输出的图片宽度
				newHeight = height; // 输出的图片高度
			}
			BufferedImage to = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
			Image from = null;
			Graphics2D g2d = null;
			if (formatName.equalsIgnoreCase("png")) {
				g2d = to.createGraphics();
				to = g2d.getDeviceConfiguration().createCompatibleImage(newWidth, newHeight, Transparency.TRANSLUCENT);
				g2d.dispose();
				g2d = to.createGraphics();
				from = bi.getScaledInstance(newWidth, newHeight, BufferedImage.SCALE_AREA_AVERAGING);
				g2d.drawImage(from, 0, 0, null);
				g2d.dispose();
			} else {
				from = bi.getScaledInstance(newWidth, newHeight, Image.SCALE_DEFAULT);
				g2d = to.createGraphics();
				g2d.drawImage(from, 0, 0, null); // 绘制缩小后的图
				g2d.dispose();
			}
			ImageIO.write(to, formatName, target);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
