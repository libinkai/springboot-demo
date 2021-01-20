package com.example.demo.service.util;



import java.util.UUID;

public class IDUtil {
    private static String randomCharset = "ABCDEFGHJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static int randomCharsetLen = randomCharset.length();
    /**
     *  使用UUID生成绝对唯一的32位字符串随机序列
     * @return String
     */
    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    /**
     * 获取指定位数的验证码
     * @param bit
     * @return
     */
    public static String getAuthCode(Integer bit){
        StringBuffer authCode = new StringBuffer();
        for (int i=0;i<bit;i++){
            authCode.append((int)(Math.random()*10));
        }
        return authCode.toString();
    }

    /**
     * 生成图像验证码
     * @param bit
     * @return
     */
    public static String getRandomChar(Integer bit){
        StringBuffer authCode = new StringBuffer();
        for (int i=0;i<bit;i++){
            authCode.append(randomCharset.charAt((int)(Math.random()*randomCharsetLen)));
        }
        return authCode.toString();
    }
}
