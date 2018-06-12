package jcydshanks.com.rixin.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fragment.RixinDelegate;
import jcydshanks.com.rixin.R;

public class StartFragment extends RixinDelegate {


    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {
      //在此对每个控件进行操作

    }



    @Override
    public Object setLayout() {
        return R.layout.activity_start;
    }


}
