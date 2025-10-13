package juegos.colorsToText;

import static juegos.colorsToText.code.TextToColors.textToColor;
import static juegos.colorsToText.code.TextToColors.getColors;
import static juegos.colorsToText.code.ColorsToText.colorToText;
import static juegos.colorsToText.code.ColorsToText.getText;


public class Main {
    public static void main(String[] args) {
        System.out.println();
        textToColor("SUPERPENE");
        System.out.println(getColors());
        //ColorSwatches.showWithColors(getColors());
        colorToText("#000033#D70972#C25BA5");
        System.out.println(getText());

        System.out.println();
        textToColor("MEPICANLOSHUEVOS");
        System.out.println(getColors());
        colorToText("#B65C29#8E1BAC#BF3A35#976BF3");
        System.out.println(getText());

        System.out.println();
        textToColor("COMANDANTEBOMBARDEENPERU");
        System.out.println(getColors());
        colorToText("#8EFB61#BA486E#D258AF#B62872#92596E#C25CB5");
        System.out.println(getText());


    }
}