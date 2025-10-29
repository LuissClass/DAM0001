package juegos.colorsToText;

import static juegos.colorsToText.code.TextToColors.textToColor;
import static juegos.colorsToText.code.TextToColors.getColors;
import static juegos.colorsToText.code.ColorsToText.colorToText;
import static juegos.colorsToText.code.ColorsToText.getText;


public class Main {
    public static void main(String[] args) {
        // EJEMPLOS
        String text1 = "HOLA MUNDO";
        String color1= "#000028#BEC86D#D6E92F";

        System.out.println("TEXT '" + text1 + "' TO COLOR:");
        textToColor(text1);
        System.out.println(getColors() + "\n");
        ColorSwatches.showWithColors(getColors());

        System.out.println("COLOR '" + color1 + "' TO TEXT:");
        colorToText(color1);
        System.out.println(getText() + "\n");


    }
}