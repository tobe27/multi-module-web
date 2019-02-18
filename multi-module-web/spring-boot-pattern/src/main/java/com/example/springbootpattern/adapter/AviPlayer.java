package com.example.springbootpattern.adapter;

/**
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public class AviPlayer implements AdvancedMediaPlayer {
    @Override
    public void playAvi(String fileName) {
        System.out.println("Playing avi file.Name: "+ fileName);
    }

    @Override
    public void playMp4(String fileName) {
        // 什么也不做
    }
}
