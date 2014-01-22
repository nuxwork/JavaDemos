package com.swordy.demo.thirdlib.thumbnailator;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Random;

import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.Thumbnails.Builder;
import net.coobird.thumbnailator.geometry.Positions;

/**
 * Thumbnailator使用示例，演示了Thumbnailator对图片的
 * 缩放，旋转，水印，格式转换等操作。
 * 
 * @author swordy
 * @email mryangjian@live.com
 * @since Jan 20, 2014
 * @version 1.0
 */
public class Thumbnailator1
{
	private static final String TAG = "JavaDemos.Thumbnailator1";

	private static final String IMG_DIR = "./res/img";

	private static final String OUT_DIR = "./out/thumbnailator";

	public static void main(String[] args)
	{
		File imgDir = new File(IMG_DIR);
		if (!imgDir.exists())
		{
			System.out.println("no images at " + imgDir.getAbsolutePath());
			return;
		}

		/*
		 * thumbnailator没有路径检查
		 */
		File outDir = new File(OUT_DIR);
		if (!outDir.exists())
		{
			outDir.mkdirs();
		}

		FileFilter imgFilter = new FileFilter() {

			@Override
			public boolean accept(File file)
			{
				if (file.exists())
				{
					String name = file.getName();
					if (name.endsWith("jpg") || name.endsWith("png") || name.endsWith("bmp")
							|| name.endsWith("gif") || name.endsWith("jpeg"))
					{
						return true;
					}
				}
				return false;
			}
		};

		File[] imgFiles = imgDir.listFiles(imgFilter);
		try
		{
			Random random = new Random();
			random.setSeed(System.currentTimeMillis());
			for (File f : imgFiles)
			{
				long cur = System.currentTimeMillis();
				int width = getInt(random);
				int height = getInt(random);

				/*
				 * 1. 指定尺寸大小进行缩放
				 */
				Thumbnails
						.of(f)
						.size(width, height)
						.toFile(OUT_DIR + "/" + f.getName() + "_size_" + width + "x" + height
								+ ".jpg");

				/*
				 * 2. 指定尺寸大小进行缩放，不保持原始比例
				 */
				width = getInt(random);
				height = getInt(random);
				Thumbnails
						.of(f)
						.size(width, height)
						.keepAspectRatio(false)
						.toFile(OUT_DIR + "/" + f.getName() + "_size_" + width + "x" + height
								+ ".jpg");

				/*
				 * 3. 指定缩放比例进行缩放
				 */
				float scale = random.nextFloat();
				Thumbnails.of(f).scale(scale)
						.toFile(OUT_DIR + "/" + f.getName() + "_scale_" + scale + ".jpg");

				/*
				 * 4. 旋转
				 */
				int angle = getInt(random);
				Thumbnails.of(f).scale(scale).rotate(angle)
						.toFile(OUT_DIR + "/" + f.getName() + "_angle_" + angle + ".jpg");

				/*
				 * 5. 水印
				 */
				Builder<File> builder1 = Thumbnails.of(f).size(512, 512);
				Builder<File> builder2 = Thumbnails.of(f).rotate(76).size(100, 100);
				builder1.watermark(builder2.asBufferedImage(), 0.8f).toFile(
						OUT_DIR + "/" + f.getName() + "_watermake" + ".jpg");

				/*
				 * 6. 裁剪
				 */
				String outImgPath = OUT_DIR + "/" + f.getName() + "_region_400x400.jpg";
				Thumbnails.of(f).scale(scale).sourceRegion(Positions.CENTER, 400, 400)
						.toFile(outImgPath);

				/*
				 * 转换格式
				 * tips: 通过输出文件大小可以看出格式是否转换
				 */
				File outFile = new File(outImgPath);
				if (outFile.exists())
				{
					Thumbnails.of(f).size(400,400).toFile(
							OUT_DIR + "/" + outFile.getName() + "_format_400x400.bmp");
				}

				System.out.println(System.currentTimeMillis() - cur);
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	private static int getInt(Random random)
	{
		int result = 0;
		while (result <= 0)
		{
			result = random.nextInt(512);
		}
		return result;
	}
}
