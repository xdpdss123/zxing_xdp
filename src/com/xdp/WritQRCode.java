package com.xdp;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;

/**
 * 生成二维码
 */
public class WritQRCode {

    public static void main(String[] args) {
        /**
         * 图片宽度，高度和格式
         */
        int with = 300;
        int height = 300;
        String format = "png";
        /**
         * 二维码的内容
         */
        String content = "测试成功，大吉大利🐔";
        /**
         * 定义二维码参数
         */
        HashMap hints = new HashMap();
        //设置编码
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
        //设置等级
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
        try {
            //设置边距
            hints.put(EncodeHintType.MARGIN, 2);
            //生成二维码
            BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, with, height, hints);
            //生成的路径
            Path path = new File("/Users/xdp/Desktop/xdp.png").toPath();
            MatrixToImageWriter.writeToPath(bitMatrix, format, path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
