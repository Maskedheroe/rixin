package jcydshanks.com.rixin.fragment;

import android.content.Context;
import android.graphics.YuvImage;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import net.tsz.afinal.FinalBitmap;
import net.tsz.afinal.annotation.view.ViewInject;

import fragment.RixinDelegate;
import jcydshanks.com.rixin.Global;
import jcydshanks.com.rixin.MainActivity;
import jcydshanks.com.rixin.R;
import jcydshanks.com.rixin.tool.CustomDialog;


public class NewsFragment extends RixinDelegate {

    @ViewInject(id = R.id.head_img,click = "OnClick")ImageView head_img;
    @ViewInject(id = R.id.draw_layout)DrawerLayout drawLayout;
    @ViewInject(id= R.id.test)ImageView test;
    public FinalBitmap finalBitmap;

    @Override
    public Object setLayout() {

        return R.layout.fragment_news;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        finalBitmap=FinalBitmap.create(getContext());
        finalBitmap.display(test, Global.BingURL+"/?w=1080&h=1920");
        return super.onCreateView(inflater, container, savedInstanceState);

    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.head_img:
                drawLayout.openDrawer(GravityCompat.START);
                break;

        }
    }

}
