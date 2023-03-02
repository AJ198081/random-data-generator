package dev.aj.randomdatagenerator.writeoperations;

import java.io.IOException;

public interface WriteOperation {
    void generateDataToFile(int howMany) throws IOException;
}
