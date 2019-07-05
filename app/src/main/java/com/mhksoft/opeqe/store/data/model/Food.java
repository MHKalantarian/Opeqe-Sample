
package com.mhksoft.opeqe.store.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Food {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("subTitle")
    @Expose
    private String subTitle;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("ingredients")
    @Expose
    private String ingredients;
    @SerializedName("minimumCalorie")
    @Expose
    private Integer minimumCalorie;
    @SerializedName("maximumCalorie")
    @Expose
    private Integer maximumCalorie;
    @SerializedName("preparation")
    @Expose
    private Integer preparation;
    @SerializedName("delivery")
    @Expose
    private Integer delivery;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("gallery")
    @Expose
    private String gallery;
    @SerializedName("price")
    @Expose
    private Double price;
    @SerializedName("fee")
    @Expose
    private Integer fee;
    @SerializedName("rate")
    @Expose
    private Integer rate;
    @SerializedName("isAcceptingDelivery")
    @Expose
    private Boolean isAcceptingDelivery;
    @SerializedName("isAcceptingPickup")
    @Expose
    private Boolean isAcceptingPickup;
    @SerializedName("isFavorite")
    @Expose
    private Boolean isFavorite;
    @SerializedName("isCatering")
    @Expose
    private Boolean isCatering;
    @SerializedName("isAvailable")
    @Expose
    private Boolean isAvailable;
    @SerializedName("cuisineType")
    @Expose
    private CuisineType cuisineType;
    @SerializedName("mealType")
    @Expose
    private MealType mealType;
    @SerializedName("menuType")
    @Expose
    private MenuType menuType;
    @SerializedName("courseType")
    @Expose
    private CourseType courseType;
    @SerializedName("special")
    @Expose
    private Special special;
    @SerializedName("rewards")
    @Expose
    private List<Object> rewards = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Integer getMinimumCalorie() {
        return minimumCalorie;
    }

    public void setMinimumCalorie(Integer minimumCalorie) {
        this.minimumCalorie = minimumCalorie;
    }

    public Integer getMaximumCalorie() {
        return maximumCalorie;
    }

    public void setMaximumCalorie(Integer maximumCalorie) {
        this.maximumCalorie = maximumCalorie;
    }

    public Integer getPreparation() {
        return preparation;
    }

    public void setPreparation(Integer preparation) {
        this.preparation = preparation;
    }

    public Integer getDelivery() {
        return delivery;
    }

    public void setDelivery(Integer delivery) {
        this.delivery = delivery;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGallery() {
        return gallery;
    }

    public void setGallery(String gallery) {
        this.gallery = gallery;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getFee() {
        return fee;
    }

    public void setFee(Integer fee) {
        this.fee = fee;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public Boolean getIsAcceptingDelivery() {
        return isAcceptingDelivery;
    }

    public void setIsAcceptingDelivery(Boolean isAcceptingDelivery) {
        this.isAcceptingDelivery = isAcceptingDelivery;
    }

    public Boolean getIsAcceptingPickup() {
        return isAcceptingPickup;
    }

    public void setIsAcceptingPickup(Boolean isAcceptingPickup) {
        this.isAcceptingPickup = isAcceptingPickup;
    }

    public Boolean getIsFavorite() {
        return isFavorite;
    }

    public void setIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
    }

    public Boolean getIsCatering() {
        return isCatering;
    }

    public void setIsCatering(Boolean isCatering) {
        this.isCatering = isCatering;
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public CuisineType getCuisineType() {
        return cuisineType;
    }

    public void setCuisineType(CuisineType cuisineType) {
        this.cuisineType = cuisineType;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public MenuType getMenuType() {
        return menuType;
    }

    public void setMenuType(MenuType menuType) {
        this.menuType = menuType;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }

    public Special getSpecial() {
        return special;
    }

    public void setSpecial(Special special) {
        this.special = special;
    }

    public List<Object> getRewards() {
        return rewards;
    }

    public void setRewards(List<Object> rewards) {
        this.rewards = rewards;
    }

}
