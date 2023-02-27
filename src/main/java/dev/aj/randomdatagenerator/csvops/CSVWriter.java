package dev.aj.randomdatagenerator.csvops;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import dev.aj.randomdatagenerator.entities.ProcessedEntity;
import dev.aj.randomdatagenerator.service.GenerateMemberData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

@Slf4j
@Component
public class CSVWriter {

    @Value("${output.file.location}")
    private String outputFileLocation;

    @Autowired
    private GenerateMemberData generateMemberData;

    public void processedEntity(int howMany) throws IOException {
        StopWatch stopWatch = new StopWatch("stream");
        stopWatch.start();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileLocation))) {

            StatefulBeanToCsv<ProcessedEntity> csvWriter = new StatefulBeanToCsvBuilder<ProcessedEntity>(writer)
                    .withSeparator(com.opencsv.CSVWriter.DEFAULT_SEPARATOR)
                    .build();

            generateMemberData.generateDateForMultipleMembers(howMany)
                    .forEach(member -> {
                        try {
                            csvWriter.write(member);
                        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
                            throw new RuntimeException(e);
                        }
                    });

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        }

        stopWatch.stop();

        log.info("{} records have been created in {} milliseconds", howMany, stopWatch.getLastTaskTimeMillis());
    }
}


