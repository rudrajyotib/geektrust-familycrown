package geektrust.family.crown.processor;

public enum ValidateCipher {

    SPACE(new int[]{1, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 7),
    LAND(new int[]{2, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 5),
    WATER(new int[]{0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0}, 7),
    ICE(new int[]{1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 3, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0}, 7),
    AIR(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0}, 3),
    FIRE(new int[]{1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, 6);

    private final int[] validationRule;
    private final int decipherKey;

    ValidateCipher(int[] validationRule, int decipherKey) {
        this.validationRule = validationRule;
        this.decipherKey = decipherKey;
    }

    public boolean isValidMessage(String message) {
        int[] decipherMap = new int[26];
        message = message.toUpperCase();
        for (int i = 0; i < message.length(); i++) {
            int charVal = message.charAt(i) - 65;
            if ((charVal >= 0) && (charVal <= 25)) {
                int decipheredChar = charVal - decipherKey;
                if (decipheredChar < 0) {
                    decipheredChar = decipheredChar + 26;
                }
                ++decipherMap[decipheredChar];
            }
        }
        for (int i = 0; i < 26; i++) {
            if (this.validationRule[i] > decipherMap[i]) {
                return false;
            }
        }
        return true;
    }
}
