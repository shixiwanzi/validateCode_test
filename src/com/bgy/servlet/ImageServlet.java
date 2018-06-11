package com.bgy.servlet;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ImageServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    //图片高度
    private static final int IMG_HEIGHT = 100;
    //图片宽度
    private static final int IMG_WIDTH = 30;
    //验证码长度
    private static final int CODE_LEN = 4;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //用于绘制图片，设置图片的长宽和图片类型（RGB)
        BufferedImage bi = new BufferedImage(ImageServlet.IMG_HEIGHT, ImageServlet.IMG_WIDTH, BufferedImage.TYPE_INT_RGB);
       //获取绘图工具
        Graphics graphics = bi.getGraphics();
        graphics.setColor(new Color(100, 230, 200));
        graphics.fillRect(0, 0, 100, 30);
        
        //验证码中所使用到的字符
        char[] codeChar = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456".toCharArray();
        String captcha = "";        //存放生成的验证码
        Random random = new Random();
        for (int i = 0; i < ImageServlet.CODE_LEN; i++) {
            int index = random.nextInt(codeChar.length);
            graphics.setColor(new Color(random.nextInt(150), random.nextInt(200), random.nextInt(225)));
            graphics.drawString(codeChar[index] + "", (i * 20) + 15, 20);
            graphics.setColor(new Color(random.nextInt(255)+1,random.nextInt(255)+1,random.nextInt(255)+1));
            graphics.drawLine(random.nextInt(100), random.nextInt(30), random.nextInt(100), random.nextInt(30));
            captcha += codeChar[index];
        }
        req.getSession().setAttribute("code", captcha);
        
        ImageIO.write(bi, "JPG", resp.getOutputStream());
    }

}
