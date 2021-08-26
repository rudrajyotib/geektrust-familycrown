package geektrust.throne.api;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleCommandProcessorTest {

    @Test
    public void shouldValidate()
    {
        assertEquals("AIR", SingleCommandProcessor.validate("AIR ROZO"));
        assertEquals("", SingleCommandProcessor.validate("AIRROZO"));
        assertEquals("", SingleCommandProcessor.validate("AIRWATER ROZO"));
        assertEquals("", SingleCommandProcessor.validate("LAND ROZO"));
    }

}