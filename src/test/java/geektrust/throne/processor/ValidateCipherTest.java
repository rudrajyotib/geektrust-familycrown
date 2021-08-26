package geektrust.throne.processor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateCipherTest {

    @Test
    public void shouldValidateCipherMessage()
    {
        assertTrue(ValidateCipher.AIR.isValidMessage("ROZO"));
        assertTrue(ValidateCipher.AIR.isValidMessage("rozo"));
        assertTrue(ValidateCipher.LAND.isValidMessage("FAIJWJSOOFAMAU"));
        assertTrue(ValidateCipher.ICE.isValidMessage("STHSTSTVSASOS"));
        assertFalse(ValidateCipher.AIR.isValidMessage("rizi"));
        assertFalse(ValidateCipher.AIR.isValidMessage("OWLAOWLBOWLC"));
        assertTrue(ValidateCipher.LAND.isValidMessage("OFBBMUFDICCSO"));
        assertTrue(ValidateCipher.ICE.isValidMessage("VTBTBHTBBBOBAB"));
        assertTrue(ValidateCipher.SPACE.isValidMessage("NVZPSSH"));
        assertFalse(ValidateCipher.SPACE.isValidMessage("NVZPSTH"));
        assertTrue(ValidateCipher.WATER.isValidMessage("XUYUYytytVJAVWBZZZZZ"));
        assertFalse(ValidateCipher.WATER.isValidMessage("XUYUYytytVMAVWBZZZZZ"));
        assertTrue(ValidateCipher.FIRE.isValidMessage("AJRXEGEMSSUTTTTT"));
        assertFalse(ValidateCipher.FIRE.isValidMessage("NVZPSTH"));
    }

}