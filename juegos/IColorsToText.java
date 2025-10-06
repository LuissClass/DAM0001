package juegos;

public interface IColorsToText {
    String asciiToDec(String textAscii);
    String decToBin(String textDec);
    String binToHex(String textBin);
    String hexToColor(String textHex);

    int ColorToHex(int textRGB);
    int hexToBinary(int textHex);
    int binToDec(int textBin);
    String decToAscii(int textDec);


}
