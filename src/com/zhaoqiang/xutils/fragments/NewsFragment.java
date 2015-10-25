package com.zhaoqiang.xutils.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.zhaoqiang.xutils.R;

/**
 * Created by zhaoQiang on 2015/10/9.
 */
public class NewsFragment extends Fragment {

    @ViewInject(R.id.main_txt_info)
    private TextView textInfo;

    public NewsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.news_fragment,container,false);

        ViewUtils.inject(this,view);

        return view;

    }
}