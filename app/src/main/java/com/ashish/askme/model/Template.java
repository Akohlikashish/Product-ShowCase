package com.ashish.askme.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by akohlikashish on 20/04/16.
 */
public class Template extends BaseModel implements Serializable {

    public static final int TEMPLATE_1 = 0;
    public static final int TEMPLATE_2 = 1;
    public static final int TEMPLATE_3 = 2;
    public String label;
    public String image;
    public String template;
    public List<Item> items;

    public int getTemplateType() {
        switch (template) {
            case "product-template-1":
                return TEMPLATE_1;

            case "product-template-2":
                return TEMPLATE_2;

            case "product-template-3":
                return TEMPLATE_3;
        }

        return -1;
    }
}
