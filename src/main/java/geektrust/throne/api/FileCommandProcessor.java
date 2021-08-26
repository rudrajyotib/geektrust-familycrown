package geektrust.throne.api;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileCommandProcessor {

    private final String filePath;

    public FileCommandProcessor(String filePath) {
        this.filePath = filePath;
    }

    public String processFile() throws IOException {
        File commandFile = new File(filePath);
        if (!commandFile.exists()) {
            throw new IllegalArgumentException("Command file does not exist.");
        }
        if (!commandFile.isFile()) {
            throw new IllegalArgumentException("Command file not found.");
        }
        try(Stream<String> commandStream = Files.lines(Paths.get(this.filePath)))
        {
            List<String> validMessages = commandStream
                    .map(SingleCommandProcessor::validate)
                    .filter(s -> !s.isEmpty())
                    .distinct()
                    .collect(Collectors.toList());
            if (validMessages.size() < 3)
            {
                return "NONE";
            }
            return "SPACE "+ String.join(" ", validMessages);
        }
    }
}
