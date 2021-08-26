package geektrust.throne.api;

import geektrust.throne.processor.ValidateCipher;

import java.util.Arrays;

public class SingleCommandProcessor {
    public static String validate(String messageLine) {
        if (!messageLine.contains(" "))
        {
            return "";
        }
        int separatorIndex = messageLine.indexOf(" ");
        String kingdom = messageLine.substring(0, separatorIndex);
        String message = messageLine.substring(separatorIndex+1);
        if (Arrays.stream(ValidateCipher.values()).noneMatch(validateCipher -> validateCipher.name().equals(kingdom)))
        {
            return "";
        }
        if (ValidateCipher.valueOf(kingdom).isValidMessage(message))
        {
            return kingdom;
        }
        return "";
    }
}
