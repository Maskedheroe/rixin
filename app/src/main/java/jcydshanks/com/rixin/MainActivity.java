package jcydshanks.com.rixin;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import net.tsz.afinal.annotation.view.ViewInject;

import java.util.ArrayList;
import java.util.List;

import jcydshanks.com.rixin.fragment.NewsFragment;
import jcydshanks.com.rixin.fragment.ShouyeFragment;
import jcydshanks.com.rixin.fragment.UserFragment;

public class MainActivity extends AppCompatActivity {

    private List<Fragment> TAB_FRAGMENTS=new ArrayList();
    private final int COUNT=Global.TAB_IMGS.length;
    private NewsFragment newsFragment;
    private ShouyeFragment shouyeFragment;
    private UserFragment userFragment;
    private TabViewPagerAdapter mAdapter;
    private ViewPager mViewPager;
    private TabLayout tabLayout;
    @ViewInject(id = R.id.back,click = "Onclick")ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newsFragment=new NewsFragment();
        shouyeFragment=new ShouyeFragment();
        userFragment=new UserFragment();
        TAB_FRAGMENTS.add(newsFragment);
        TAB_FRAGMENTS.add(shouyeFragment);
        TAB_FRAGMENTS.add(userFragment);
        initView();

    }

    private void initView(){

        tabLayout=(TabLayout)findViewById(R.id.tablayout);
        setTabs(tabLayout,this,getLayoutInflater(),Global.TAB_IMGS);
        mAdapter=new TabViewPagerAdapter(getSupportFragmentManager());
        mViewPager=(ViewPager)findViewById(R.id.viewpager);
        mViewPager.setAdapter(mAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

    }

    private void setTabs(TabLayout tabLayout, MainActivity mainActivity, LayoutInflater inflater, int[] tabImags){
        for (int i=0;i<tabImags.length;i++){
            TabLayout.Tab tab=tabLayout.newTab();
            View view=inflater.inflate(R.layout.item_tab,null);
            tab.setCustomView(view);
            ImageView imgTab=(ImageView)view.findViewById(R.id.img_tab);
            imgTab.setImageResource(Global.TAB_IMGS[i]);
            tabLayout.addTab(tab);
        }
    }

    public void OnClick(View view){
        switch (view.getId()){
            case R.id.back:
                onBackPressed();
                break;
        }
    }

    private  class TabViewPagerAdapter extends FragmentPagerAdapter{

        public TabViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return TAB_FRAGMENTS.get(position);
        }

        @Override
        public int getCount() {
            return COUNT;
        }
    }
}
