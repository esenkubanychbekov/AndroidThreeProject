package com.kubatov.androidthree.data.model;

import java.io.Serializable;

public class OnBoardModel implements Serializable {

    private int image;
    private String text;
    private String textOfButton;
    private String textOfskip;

    public OnBoardModel(int image, String text, String textOfButton, String textOfskip) {
        this.image = image;
        this.text = text;
        this.textOfButton = textOfButton;
        this.textOfskip = textOfskip;
    }

    public int getImage() {
        return image;
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
