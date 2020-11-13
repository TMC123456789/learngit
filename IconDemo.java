package com.company;

import javax.swing.*;
import java.awt.*;

//这个写法非常的重要的，继承了JFrame又实现了图标的接口Icon。
public class IconDemo extends JFrame implements Icon {
        private int width;
        private int height;

        public IconDemo(){}//没有参数的构造函数
        public IconDemo(int width,int height){
        this.width=width;
        this.height=height;
        }
        public void init()
        {
        IconDemo icondemo=new IconDemo(15,15);

        //这个就很神奇了，创建标签的时候，就直接的把实现了Icon的类作为参数，且设置显示的位置。
        JLabel jlabel=new JLabel("icondemo",icondemo,SwingConstants.CENTER);

        Container container=getContentPane();
        container.add(jlabel);

        setVisible(true);
        setBounds(200,200,100,100);
        //设置窗口的关闭事件，当我们关闭窗口的时候，程序结束运行，窗口关闭
        //这一点和Frame不同，Frame需要自己建立事件的监听。
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        }

        public static void main(String[] args)
        {
        new IconDemo().init();
        }
        //以下的三个方法是Icon接口的三个抽象的方法，其中的第一个方法很是重要的表示画一个图标，
        //并且这个方法似乎是自己调用的当我们显示窗口后，就自己画图了，我们需要给的是实现这个方法也就是这个方法
        //该做什么画的是什么图标。开始画的位置x和y默认的是中间的位置。
        @Override
         public void paintIcon(Component c, Graphics g, int x, int y) {
            g.fillOval(x, y, width, height);
        }
        @Override
        public int getIconWidth() {
            return this.width;
        }

        @Override
        public int getIconHeight() {
            return this.height;
        }
}
