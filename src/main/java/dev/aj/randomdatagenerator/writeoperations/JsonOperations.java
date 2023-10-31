package dev.aj.randomdatagenerator.writeoperations;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.aj.randomdatagenerator.entities.StaticData;
import dev.aj.randomdatagenerator.service.GenerateMemberData;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@RequiredArgsConstructor
@Slf4j
public class JsonOperations implements WriteOperation {

    @Value("${output.file.location}")
    private String outputFileLocation;

    private final GenerateMemberData generateMemberData;

    private final ObjectMapper objectMapper;

    private final StaticData staticData;

    @Override
    public void generateDataToFile(int howMany) {
        String fileName = String.format("%s_%d_records.json", outputFileLocation, howMany);
        StopWatch stopWatch = new StopWatch("stream");
        stopWatch.start();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            String jsonString = null;
            try {
                jsonString = objectMapper.writeValueAsString(
                        generateMemberData.generateBulkDataForTableEntity(howMany));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            writer.write(staticData.PREFIX);
            writer.write(jsonString);
            writer.write(staticData.SUFFIX);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
