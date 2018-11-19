package com.xdp;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.Buffer;
import java.util.HashMap;

/**
 * 读取二维码
 */
public class ReadQRCode {
    public static void main(String[] args) {
        try {
            MultiFormatReader multiFormatReader = new MultiFormatReader();
            //读取路径
            File file = new File("/Users/xdp/Desktop/xdp.png");
            //读取图片
            BufferedImage image = ImageIO.read(file);
            BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(new BufferedImageLuminanceSource(image)));
            //定义二维码参数
            HashMap hints = new HashMap();
            hints.put(EncodeHintType.CHARACTER_SET, "utf-*");

            Result result = multiFormatReader.decode(binaryBitmap, hints);
            System.out.println(result.toString());
            //二维码格式
            System.out.println(result.getBarcodeFormat());
            //文本内容
            System.out.println(result.getText());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
