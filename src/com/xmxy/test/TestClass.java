package com.xmxy.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;


/**
 * @ClassName TestClass
 * @Author Administrator
 * @Date 2019/1/7 0007 16:18
 **/
public class TestClass {

    public static void main(String [] args){
        new TestClass().inputValue("my words");
    }

    public void inputValue(String value){
        try{
//            WebClient webclient = new WebClient();
//            // 下面这2句可以写，也可以不写，设置false就是不加载css和js。访问速度更快
//            webclient.getOptions().setCssEnabled(false);
//            webclient.getOptions().setJavaScriptEnabled(false);
//            // 做的第一件事，去拿到这个网页，只需要调用getPage这个方法即可
//            HtmlPage htmlpage = webclient.getPage("https://baidu.com");
//            // 根据名字得到一个表单，查看上面这个网页的源代码可以发现表单的名字叫“f”
//            final HtmlForm form = htmlpage.getFormByName("f");
//            // 同样道理，获取”百度一下“这个按钮
//            final HtmlSubmitInput button = form.getInputByValue("百度一下");
//            // 得到搜索框
//            final HtmlTextInput textField = form.getInputByName("wd");
//            //设置搜索框的value
//            textField.setValueAttribute(value);
//            // 设置好之后，模拟点击按钮行为。
//            final HtmlPage nextPage = button.click();
//            // 把结果转成String
//            String result = nextPage.asXml();
//            //得到的是点击后的网页
//            System.out.println(result);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void getInfo(){
        try {
            Document document= Jsoup.connect("https://wx2.qq.com/").get();
            System.out.println(document.getElementsByTag("img"));

//            Desktop.getDesktop().browse(
//                    new URL("https://wx2.qq.com/cgi-bin/mmwebwx-bin/webwxgetmsgimg?&MsgID=761342963694557867&skey=%40crypt_8b5a0435_75b229021edb352950a022610ac8803a&type=slave").toURI());
//            Robot robot = new Robot();
//            robot.delay(2000);
//            robot.keyPress(KeyEvent.VK_CONTROL);
//            robot.delay(100);
//            robot.keyPress(KeyEvent.VK_S);
//            robot.keyRelease(KeyEvent.VK_S);
//            robot.delay(100);
//            robot.keyRelease(KeyEvent.VK_CONTROL);
//            robot.mouseMove(1065,622);
//            // 移动鼠标到坐标（x,y)处，并点击左键
//            robot.mousePress(KeyEvent.BUTTON1_DOWN_MASK);// 模拟按下鼠标左键
//            System.out.println();
//            robot.mouseRelease(KeyEvent.BUTTON1_DOWN_MASK);	// 模拟释放鼠标左键
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
