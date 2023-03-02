package dev.aj.randomdatagenerator.writeoperations;

import com.opencsv.ICSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import dev.aj.randomdatagenerator.entities.TableEntity;
import dev.aj.randomdatagenerator.service.GenerateMemberData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@Slf4j
@Component
@RequiredArgsConstructor
public class CSVOperations implements WriteOperation{

    @Value("${output.file.location}")
    private String outputFileLocation;

    private final GenerateMemberData generateMemberData;

    public void generateDataToFile(int howMany) {

        String fileName = String.format("%s_%d_records.csv", outputFileLocation, howMany);

        StopWatch stopWatch = new StopWatch("stream");
        stopWatch.start();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            StatefulBeanToCsv<TableEntity> csvWriter = new StatefulBeanToCsvBuilder<TableEntity>(writer)
                    .withSeparator(ICSVWriter.DEFAULT_SEPARATOR)
                    .withOrderedResults(true)
                    .build();

            generateMemberData.generateBulkDataForTableEntity(howMany)
                    .forEach(member -> {
                        try {
                            csvWriter.write(member);
                        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException e) {
                            throw new RuntimeException(e);
                        }
                    });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        stopWatch.stop();

        log.info("{} records have been created in {} milliseconds", howMany, stopWatch.getLastTaskTimeMillis());
    }
}


