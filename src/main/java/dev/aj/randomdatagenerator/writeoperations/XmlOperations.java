package dev.aj.randomdatagenerator.writeoperations;

import dev.aj.randomdatagenerator.entities.XmlListWrapper;
import dev.aj.randomdatagenerator.service.GenerateMemberData;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

@Slf4j
@RequiredArgsConstructor
@Component
public class XmlOperations implements WriteOperation {

    @Value("${output.file.location}")
    private String outputFileLocation;

    private final GenerateMemberData generateMemberData;

    public void generateDataToFile(int howMany) throws IOException {

        String fileName = String.format("%s_%d_records.xml", outputFileLocation, howMany);
        StopWatch stopWatch = new StopWatch("stream");
        stopWatch.start();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {

            JAXBContext jaxbContext = JAXBContext.newInstance(XmlListWrapper.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            XmlListWrapper listOfEntries = XmlListWrapper.builder()
                    .tableEntities(generateMemberData.generateBulkDataForTableEntity(howMany))
                    .build();

            marshaller.marshal(listOfEntries, writer);

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException(e.getMessage());
        } catch (JAXBException e) {
            throw new RuntimeException(e);
        }

        stopWatch.stop();

        log.info("{} records have been created in {} milliseconds", howMany, stopWatch.getLastTaskTimeMillis());
    }
}
