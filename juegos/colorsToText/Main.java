package juegos.colorsToText;

import static juegos.colorsToText.code.TextToColors.textToColor;
import static juegos.colorsToText.code.TextToColors.getColors;

public class Main {
    public static void main(String[] args) {

        textToColor("SUPERPENE");
        System.out.println(getColors());
        ColorSwatches.showWithColors(getColors());
    }
}