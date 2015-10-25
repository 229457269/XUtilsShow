package com.zhaoqiang.xutils;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.ResType;
import com.lidroid.xutils.view.annotation.ContentView;
import com.lidroid.xutils.view.annotation.ResInject;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.lidroid.xutils.view.annotation.event.OnClick;
import com.lidroid.xutils.view.annotation.event.OnCompoundButtonCheckedChange;
import com.zhaoqiang.xutils.annotation.CodeAuthor;

import java.lang.reflect.Field;

//注解的使用：
@ContentView(R.layout.main)
public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */

    @ViewInject(R.id.main_txt_info)//使用注解查找  数据
    private TextView textView;

    @ViewInject(R.id.btn_click)
    private Button btn;

    //相当于string 包含了  CodeAuthor的内容
    @CodeAuthor(R.string.app_name)
    private String string;

    @ResInject(id = R.string.app_name,type = ResType.String)//可以加载各种资源：
    private String appName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //使用 ViewUtils的功能，需要调用几个方法    viewUtils.inject(Activity)：
        ViewUtils.inject(this);

        //显示内容：
        textView.setText("你好世界。。。by ViewUtils");

        btn.setText("点你一下");


        //利用反射获取自定义注解  变量的值   进行反射的处理  获取String成员变量
        Class c = this.getClass();//
        try {
            //1，区变量
            Field f = c.getDeclaredField("string");
            f.setAccessible(true);

            //2，从成员变量中  获取注解：
            CodeAuthor annotation = f.getAnnotation(CodeAuthor.class);
            int v = annotation.value();

//            //2.1:从资源取字符串：
//            String str = getString(v);

            //3，赋值
            f.set(this,"Author:"+v);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        Log.d("CodeAuthor","string="+string);
        Log.d("CodeAuthor","appName="+appName);

    }


    @OnClick(R.id.btn_click)//使用注解设置单击方法
    public void clickShowToast(View view){
        Toast.makeText(this,"您好",Toast.LENGTH_LONG).show();
    }

    @OnCompoundButtonCheckedChange(R.id.chk_text)
    public void clickChanged(CompoundButton compoundButton,boolean checked){
        Toast.makeText(this,"选择了",Toast.LENGTH_LONG).show();
    }


}
