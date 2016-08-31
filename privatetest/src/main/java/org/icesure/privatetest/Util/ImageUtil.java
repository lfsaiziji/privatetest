package org.icesure.privatetest.Util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

public class ImageUtil {
	private static String DEFAULT_PREVFIX = "thumb_";
	private static Boolean DEFAULT_FORCE = false;
	
	private static String PATH_FOLDER = "C://Users//thinkpad//git//privatetest//privatetest//src//main//webapp//image//uploadfile//";

	/**
	 * <p>
	 * Title: thumbnailImage
	 * </p>
	 * <p>
	 * Description: 根据图片路径生成缩略图
	 * </p>
	 * 
	 * @param imagePath
	 *            原图片路径
	 * @param w
	 *            缩略图宽
	 * @param h
	 *            缩略图高
	 * @param prevfix
	 *            生成缩略图的前缀
	 * @param force
	 *            是否强制按照宽高生成缩略图(如果为false，则生成最佳比例缩略图)
	 */
	public static String thumbnailImage(File imgFile, int w, int h, String prevfix,
			boolean force) {
		String thumpath = null;
		if (imgFile.exists()) {
			try {
				// ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG,
				// JPEG, WBMP, GIF, gif]
				String types = Arrays.toString(ImageIO.getReaderFormatNames());
				String suffix = null;
				// 获取图片后缀
				if (imgFile.getName().indexOf(".") > -1) {
					suffix = imgFile.getName().substring(
							imgFile.getName().lastIndexOf(".") + 1);
				}// 类型和图片后缀全部小写，然后判断后缀是否合法

				Image img = ImageIO.read(imgFile);
				if (!force) {
					// 根据原图与要求的缩略图比例，找到最合适的缩略图比例
					int width = img.getWidth(null);
					int height = img.getHeight(null);
					if ((width * 1.0) / w < (height * 1.0) / h) {
						if (width > w) {
							h = Integer.parseInt(new java.text.DecimalFormat(
									"0").format(height * w / (width * 1.0)));

						}
					} else {
						if (height > h) {
							w = Integer.parseInt(new java.text.DecimalFormat(
									"0").format(width * h / (height * 1.0)));

						}
					}
				}
				BufferedImage bi = new BufferedImage(w, h,
						BufferedImage.TYPE_INT_RGB);
				Graphics g = bi.getGraphics();
				g.drawImage(img, 0, 0, w, h, Color.LIGHT_GRAY, null);
				g.dispose();
				String p = imgFile.getPath();
				// 将图片保存在原目录并加上前缀
				thumpath = PATH_FOLDER + imgFile.getName();
				ImageIO.write(bi, suffix,
						new File(thumpath));
			} catch (IOException e) {

			}
		} 
		return imgFile.getName();
	}

	public static String thumbnailImage(String imagePath, int w, int h, String prevfix,
			boolean force) {
		File imgFile = new File(imagePath);
		return thumbnailImage(imgFile, w, h, prevfix, force);
	}

	public static String thumbnailImage(String imagePath, int w, int h, boolean force) {
		return thumbnailImage(imagePath, w, h, DEFAULT_PREVFIX, force);
	}

	public static String thumbnailImage(String imagePath, int w, int h) {
		return thumbnailImage(imagePath, w, h, DEFAULT_FORCE);
	}
}