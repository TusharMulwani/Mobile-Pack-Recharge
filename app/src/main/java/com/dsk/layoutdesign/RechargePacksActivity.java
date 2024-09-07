package com.dsk.layoutdesign;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

import com.dsk.layoutdesign.databinding.ActivityRechargePacksBinding;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class RechargePacksActivity extends AppCompatActivity {

    private TabLayout tabs;
    private ViewPager2 vp;

    private ActivityRechargePacksBinding layoutBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();

        new TabLayoutMediator(tabs, vp, (tab, position) -> {
            //if (position == 0) {
            tab.setText("Packs");
            /*} else {
                tab.setText("HiUser");
            }*/
        }).attach();
    }

    void init() {
        layoutBinding = ActivityRechargePacksBinding.inflate(getLayoutInflater());
        setContentView(layoutBinding.getRoot());

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setBackgroundDrawable(AppCompatResources.getDrawable(this, R.drawable.black));

        tabs = layoutBinding.tabs;
        vp = layoutBinding.vp;

        vp.setAdapter(new FragmentStateAdapter(this) {
            @NonNull
            @Override
            public Fragment createFragment(int position) {
                /*if (position == 0){
                    Log.e("adapter", "at position 0");*/
                return new Packs();
                /*}
                return new HiUser();*/
            }

            @Override
            public int getItemCount() {
                return 1;
            }
        });
    }
}