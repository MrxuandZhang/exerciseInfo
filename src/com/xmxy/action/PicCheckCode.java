package com.xmxy.action;

import com.xmxy.base.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

/**
 * @ClassName PicCheckCode
 * @Author Administrator
 * @Date 2019/1/22 0022 16:40
 * 本类用于绘制验证码
 **/
@Controller
public class PicCheckCode {

    /**
     * 获取验证码
     * @param response 响应
     * @param session 绘画对象
     */
    @RequestMapping("/code")
    public void generate(HttpServletResponse response, HttpSession session){
        //字节输出对象
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        String code = drawImg(output);
        //讲字符设置到绘画中
        session.setAttribute(Const.PickCode, code);
        try {
            ServletOutputStream out = response.getOutputStream();
            output.writeTo(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 用于绘画图片
     * @param output 字节输出数组
     * @return 随机字符
     */
    private String drawImg(ByteArrayOutputStream output){
        String code = "";
        /**
         * 调用方法循环输出随机字符
         */
        for(int i=0; i<4; i++){
            code += randomChar();
        }
        //图片的宽跟高
        int width = 70;
        int height = 25;
        //实例化缓存图片类
        BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
        //实例化数字大小
        Font font = new Font("Times New Roman", Font.PLAIN,20);
        //开始绘图
        Graphics2D g = bi.createGraphics();
        /* 设置代销以及颜色和背景颜色 */
        g.setFont(font);
        Color color = new Color(66,2,82);
        g.setColor(color);
        g.setBackground(new Color(226,226,240));
        g.clearRect(0, 0, width, height);//清除位置
        FontRenderContext context = g.getFontRenderContext();
        Rectangle2D bounds = font.getStringBounds(code, context);
        double x = (width - bounds.getWidth()) / 2;
        double y = (height - bounds.getHeight()) / 2;
        double ascent = bounds.getY();
        double baseY = y - ascent;
        g.drawString(code, (int)x, (int)baseY);
        g.dispose();
        try {
            //输出图片
            ImageIO.write(bi, "jpg", output);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return code;
    }

    /**
     * 用于返回随机的26个字母或数字
     * @return
     */
    private char randomChar(){
        Random r = new Random();
        String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
        return s.charAt(r.nextInt(s.length()));
    }
}
