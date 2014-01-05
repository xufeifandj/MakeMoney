package com.jesse.gallery;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.jesse.model.GetImageOnMain;
import com.jesse.util.ContextUtil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;

@SuppressLint("SdCardPath")
public class Util {

	@SuppressWarnings("unused")
	public static List<BitMapGroup> getContent()
			throws FileNotFoundException, IOException {
		
		List<BitMapGroup> objects = new ArrayList<BitMapGroup>();

			/***** 读取文件 ******/
		if (GetImageOnMain.getInstance().getBitMapGroup() == null) { // 文件还未开始下载或者下载正在下载中
			/***** 读取缓存文件 ******/
			// TODO 读取数量应从网络获得
			for (int i = 0; i < 5; i++) {
				String fileName = "/MakeMoney/cache/main" + i + ".jpg";
				if (new File(Environment.getExternalStorageDirectory() + fileName) != null) {
					BitMapGroup accp = new BitMapGroup();
					File temp = new File(
							Environment.getExternalStorageDirectory() + fileName);
					if (temp != null) {
						Bitmap bitmap = MediaStore.Images.Media.getBitmap(
								ContextUtil.getInstance().getContentResolver(), Uri.fromFile(temp));
						accp.setMainGalleryBitmap(bitmap);
						objects.add(accp);
					} else {
						objects = null;
					}
				}
				return objects;
			} 
		} else {
			return GetImageOnMain.getInstance().getBitMapGroup();
		}
		return objects;
	} 
}
