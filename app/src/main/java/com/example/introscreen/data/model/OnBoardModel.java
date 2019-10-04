package com.example.introscreen.data.model;

import java.io.Serializable;

public class OnBoardModel implements Serializable {

    private String image;
    private String text;
    private String textOfButton;
    private String textOfskip;

//    public OnBoardModel(String image, String text, String textOfButton, String textOfskip) {
//        this.image = image;
//        this.text = text;
//        this.textOfButton = textOfButton;
//        this.textOfskip = textOfskip;
//    }

    public String getImage(String image) {
        return String.format("https://openweathermap.org/img/w/%s.png",image);
    }

    public String getText() {
        return text;
    }

    public String getTextOfButton() {
        return textOfButton;
    }

    public String getTextOfskip() {
        return textOfskip;
    }
}
