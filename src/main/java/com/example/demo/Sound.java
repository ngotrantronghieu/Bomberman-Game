package com.example.demo;

import javax.sound.sampled.*;
import java.io.*;

public class Sound {
    private static String path = "E:\\Users\\Admin\\Documents\\intellij\\OOP Big Project 2\\demo" +
            "\\src\\main\\resources\\com\\example\\Sound\\";

    public static void play(String name) {
        try {
            File file = new File(path + name + ".wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void loop(String name) {
        try {
            File file = new File(path + name + ".wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}