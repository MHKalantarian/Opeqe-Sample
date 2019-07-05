package com.mhksoft.opeqe.store.ui.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.mhksoft.opeqe.store.MainActivity;
import com.mhksoft.opeqe.store.R;
import com.mhksoft.opeqe.store.data.adapter.FoodAdapter;
import com.mhksoft.opeqe.store.data.binder.FragmentActivityBinder;
import com.mhksoft.opeqe.store.data.model.Food;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment implements FragmentActivityBinder {
    private static final String ARG_SECTION_NUMBER = "section_number";
    @BindView(R.id.horizontal_rv)
    RecyclerView horizontalRv;
    @BindView(R.id.vertical_rv)
    RecyclerView verticalRv;
    private Unbinder unbinder;
    private FoodAdapter horizontalAdapter, verticalAdapter;

    public static PlaceholderFragment newInstance() {
        return new PlaceholderFragment();
    }

    // Initializing binder
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ((MainActivity) context).binder = this;
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        unbinder = ButterKnife.bind(this, root);
        setupRecyclerViews();
        return root;
    }

    // Setup recycler view ready for usage
    private void setupRecyclerViews() {
        horizontalAdapter = new FoodAdapter(getContext(), new ArrayList<>(), FoodAdapter.Type.TILE);
        horizontalRv.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        horizontalRv.setAdapter(horizontalAdapter);

        verticalAdapter = new FoodAdapter(getContext(), new ArrayList<>(), FoodAdapter.Type.ROW);
        verticalRv.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        verticalRv.setAdapter(verticalAdapter);

        Log.e("Recyclerview", "done");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void bindFoodList(List<Food> foodList, FoodAdapter.Type type) {
        switch (type) {
            case TILE:
                horizontalAdapter.update(foodList);
                break;
            case ROW:
                verticalAdapter.update(foodList);
                break;
        }
    }
}