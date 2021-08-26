package geektrust.family.crown.api;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FileCommandProcessorTest {

    @Test
    public void shouldProcessSingleFileWhenKingWins() throws IOException {
        Path commandFile = Paths.get("src", "test", "resources", "command-success");
        FileCommandProcessor fileCommandProcessor
                = new FileCommandProcessor(commandFile.toFile().getAbsolutePath());
        assertEquals("SPACE AIR LAND ICE", fileCommandProcessor.processFile());
    }

    @Test
    public void shouldProcessSingleFileWhenKingLoses() throws IOException {
        Path commandFile = Paths.get("src", "test", "resources", "command-failure");
        FileCommandProcessor fileCommandProcessor
                = new FileCommandProcessor(commandFile.toFile().getAbsolutePath());
        assertEquals("NONE", fileCommandProcessor.processFile());
    }

    @Test
    public void shouldProcessRepeatedCommandWhenKingLoses() throws IOException {
        Path commandFile = Paths.get("src", "test", "resources", "command-repeated");
        FileCommandProcessor fileCommandProcessor
                = new FileCommandProcessor(commandFile.toFile().getAbsolutePath());
        assertEquals("NONE", fileCommandProcessor.processFile());
    }

    @Test
    public void shouldReportFileNotFound() {
        FileCommandProcessor fileCommandProcessor
                = new FileCommandProcessor("GibberishPath");
        assertThrows(IllegalArgumentException.class, fileCommandProcessor::processFile);
    }

    @Test
    public void shouldReportNotFile() {
        Path commandFile = Paths.get("src", "test", "resources");
        FileCommandProcessor fileCommandProcessor
                = new FileCommandProcessor(commandFile.toFile().getAbsolutePath());
        assertThrows(IllegalArgumentException.class, fileCommandProcessor::processFile);
    }


}