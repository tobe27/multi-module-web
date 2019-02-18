package com.example.springbootpattern.adapter;

/**
 * @author CREATED BY L.C.Y on 2019-2-18
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playAvi(String fileName) {
        // 什么也不做
    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("Playing mp4 file.Name: "+ fileName);
    }
}
