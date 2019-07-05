package com.mhksoft.opeqe.store.data.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.recyclerview.widget.RecyclerView;

import com.mhksoft.opeqe.store.R;
import com.mhksoft.opeqe.store.data.model.Food;
import com.mhksoft.opeqe.store.ui.util.RoundedCornersTransformation;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by MHK on 18/01/08.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {
    private Context mContext;
    private List<Food> mDataset;
    private Type type;

    public FoodAdapter(Context mContext, List<Food> mDataset, Type type) {
        this.mContext = mContext;
        this.mDataset = mDataset;
        this.type = type;
    }

    public void update(List<Food> mDataset) {
        this.mDataset.clear();
        this.mDataset.addAll(mDataset);
        notifyDataSetChanged();
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View convertView;
        switch (type) {
            case ROW:
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_row_item, parent, false);
                break;
            case TILE:
                convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_tile_item, parent, false);
                break;
            default:
                convertView = null;
        }
        return new FoodViewHolder(convertView);
    }

    @Override
    public void onBindViewHolder(final FoodViewHolder holder, final int position) {
        Food food = mDataset.get(position);

        holder.nameTv.setText(food.getTitle());
        holder.cuisineTypeTv.setText(food.getCuisineType().getTitle());
        holder.prepTimeTv.setText(food.getPreparation() + "-" + (food.getPreparation() + 10) + " mins");
        holder.ratingRb.setRating(food.getRate());
        holder.ratingCountTv.setText(food.getRate() + " Ratings");

        switch (type) {
            case ROW:
                Picasso.with(mContext).load(food.getImage())
                        .centerCrop().fit().placeholder(R.drawable.ic_loading).noFade().transform(new RoundedCornersTransformation(4, 0, RoundedCornersTransformation.CornerType.LEFT))
                        .into(holder.imageIv);
                break;
            case TILE:
                Picasso.with(mContext).load(food.getImage())
                        .centerCrop().fit().placeholder(R.drawable.ic_loading).noFade().transform(new RoundedCornersTransformation(4, 0, RoundedCornersTransformation.CornerType.TOP))
                        .into(holder.imageIv);
                holder.priceTv.setText("$" + food.getPrice());
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public enum Type {
        ROW,
        TILE
    }

    static class FoodViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image_iv)
        ImageView imageIv;
        @BindView(R.id.name_tv)
        TextView nameTv;
        @BindView(R.id.cuisineType_tv)
        TextView cuisineTypeTv;
        @BindView(R.id.prepTime_tv)
        TextView prepTimeTv;
        @BindView(R.id.rating_rb)
        AppCompatRatingBar ratingRb;
        @BindView(R.id.ratingCount_tv)
        TextView ratingCountTv;
        @Nullable
        @BindView(R.id.price_tv)
        TextView priceTv;

        FoodViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}

