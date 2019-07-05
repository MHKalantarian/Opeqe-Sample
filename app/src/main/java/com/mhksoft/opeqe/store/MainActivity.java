package com.mhksoft.opeqe.store;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mhksoft.opeqe.store.data.adapter.FoodAdapter;
import com.mhksoft.opeqe.store.data.binder.FragmentActivityBinder;
import com.mhksoft.opeqe.store.data.model.Food;
import com.mhksoft.opeqe.store.ui.main.SectionsPagerAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3};
    public FragmentActivityBinder binder;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.cuisines_btn)
    TextView cuisinesBtn;
    @BindView(R.id.refine_btn)
    TextView refineBtn;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout tabs;
    @BindView(R.id.filters_l)
    LinearLayout filtersL;
    private Context mContext;
    private List<Food> foodList, lunchAndDinnerFoodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;
        setupTabs();
    }

    // Setting up tabs/viewpager
    private void setupTabs() {
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(sectionsPagerAdapter);
        tabs.setupWithViewPager(viewPager);
        tabs.getTabAt(0).setIcon(R.drawable.restaurant_tab);
        tabs.getTabAt(1).setIcon(R.drawable.account_tab);
        tabs.getTabAt(2).setIcon(R.drawable.bag_tab);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                title.setText(mContext.getResources().getString(TAB_TITLES[position]));
                switch (position) {
                    case 0:
                        filtersL.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                    case 2:
                        filtersL.setVisibility(View.GONE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabs.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                tabs.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                initData();
            }
        });
    }

    // Initialization of JSON
    private void initData() {
        foodList = new Gson().fromJson(loadJSONFromAsset(), new TypeToken<List<Food>>() {
        }.getType());
        binder.bindFoodList(foodList, FoodAdapter.Type.ROW);
        binder.bindFoodList(groupByMealType(foodList, "Lunch & Dinner"), FoodAdapter.Type.TILE);
    }

    // Loading json from asset file (Can be replaced with anything)
    private String loadJSONFromAsset() {
        String json = null;
        try {
            InputStream is = getAssets().open("menu.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, StandardCharsets.UTF_8);
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }

    // Group food list by meal type
    private List<Food> groupByMealType(List<Food> foodList, String filter) {
        List<Food> foodListGroupByMealType = new ArrayList<>();
        for (Food food : foodList) {
            if (food.getMealType().getTitle().equals(filter))
                foodListGroupByMealType.add(food);
        }
        return foodListGroupByMealType;
    }
}