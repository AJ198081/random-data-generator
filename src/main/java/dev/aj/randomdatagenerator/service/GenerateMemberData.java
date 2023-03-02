package dev.aj.randomdatagenerator.service;

import com.github.javafaker.Faker;
import dev.aj.randomdatagenerator.entities.TableEntity;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class GenerateMemberData {

    public static final String MEMBER_NUMBER_PREFIX = "M";
    public static final String PAYROLL_NUMBER_PREFIX = "P";
    public static final int MEMBER_NUMBER_DIGITS = 15;
    public static final int PAYROLL_NUMBER_DIGITS = 15;
    public static final int MIN_AGE = 20;
    public static final int MAX_AGE = 60;

    @Value("${date.format.pattern}")
    private String dateFormatPattern;

    private final ATOService atoService;

    private static final Faker faker = new Faker(new Locale("en-AU"));

    private TableEntity generateSingleMemberData() {

        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);

        //Populate your entity here, make sure all fields have the values (simulated or constants) that you want
        // http://dius.github.io/java-faker/apidocs/index.html - for the data you can have, and types, make sure they match
        return TableEntity.builder()
//                .memberNumber(MEMBER_NUMBER_PREFIX.concat(faker.number().digits(MEMBER_NUMBER_DIGITS)))
//                .payrollNumber(PAYROLL_NUMBER_PREFIX.concat(faker.number().digits(PAYROLL_NUMBER_DIGITS)))
//                .title(faker.name().prefix())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName().concat(RandomStringUtils.randomAlphabetic(10)))
//                .dateOfBirth(dateFormat.format(faker.date().birthday(MIN_AGE, MAX_AGE)))
//                .email(faker.internet().emailAddress())
//                .telephone(faker.phoneNumber().cellPhone())
//                .designation(faker.name().title())
//                .abn(atoService.generateValidABN())
                .build();
    }

    public List<TableEntity> generateBulkDataForTableEntity(int howMany) {
        return IntStream.rangeClosed(1, howMany)
                .mapToObj(entry -> generateSingleMemberData())
                .collect(Collectors.toList());
    }
}
