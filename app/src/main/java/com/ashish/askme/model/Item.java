package com.ashish.askme.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by akohlikashish on 20/04/16.
 */
public class Item extends BaseModel implements Serializable {
    public String label;
    public String image;
    @SerializedName("web-url")
    public String webUrl;
}
