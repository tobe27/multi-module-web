package com.example.springbootpattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 将汉堡和冷饮组合成套餐
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public class Meal {
    private List<Item> items = new ArrayList<>();

    // 套餐添加品类
    public void addItem(Item item) {
        items.add(item);
    }

    // 套餐价格
    public float getCost() {
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    // 套餐展示
    public void showItems() {
        for (Item item : items) {
            System.out.print("Item : " + item.name());
            System.out.print(", Packing : " + item.packing().pack());
            System.out.println(", Price : " + item.price());
        }
    }
}
