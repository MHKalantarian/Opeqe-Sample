package com.mhksoft.opeqe.store.data.binder;

import com.mhksoft.opeqe.store.data.adapter.FoodAdapter;
import com.mhksoft.opeqe.store.data.model.Food;

import java.util.List;

/**
 * Created by MHK on 19/07/05.
 * www.MHKSoft.com
 */
public interface FragmentActivityBinder {
    void bindFoodList(List<Food> foodList, FoodAdapter.Type type);
}
