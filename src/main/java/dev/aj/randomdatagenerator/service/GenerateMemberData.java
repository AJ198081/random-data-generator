package dev.aj.randomdatagenerator.service;

import com.github.javafaker.Faker;
import dev.aj.randomdatagenerator.entities.TableEntity;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.RequiredArgsConstructor;
import org.apache.commons.text.CharacterPredicates;
import org.apache.commons.text.RandomStringGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenerateMemberData {

    public static final String MEMBER_NUMBER_PREFIX = "M";
    public static final String PAYROLL_NUMBER_PREFIX = "P";
    public static final int MEMBER_NUMBER_DIGITS = 15;
    public static final int PAYROLL_NUMBER_DIGITS = 15;
    public static final int MIN_AGE = 20;
    public static final int MAX_AGE = 60;
    private static final String CUSTODIAN_NAME = "GUILDSUPER";
    private static final String EMAIL_SUBJECT_PREFIX = "Subj: Email for ";
    private static final Faker faker = new Faker(new Locale("en-AU"));
    private final ATOService atoService;
    @Value("${date.format.pattern}")
    private String dateFormatPattern;

    private TableEntity generateSingleMemberData() {

        SimpleDateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);

        //Populate your entity here, make sure all fields have the values (simulated or constants) that you want
        // http://dius.github.io/java-faker/apidocs/index.html - for the data you can have, and types, make sure they match
        /*return TableEntity.builder()
                .memberNumber(MEMBER_NUMBER_PREFIX.concat(faker.number().digits(MEMBER_NUMBER_DIGITS)))
                .payrollNumber(PAYROLL_NUMBER_PREFIX.concat(faker.number().digits(PAYROLL_NUMBER_DIGITS)))
                .title(faker.name().prefix())
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName().concat(RandomStringUtils.randomAlphabetic(10)))
                .dateOfBirth(dateFormat.format(faker.date().birthday(MIN_AGE, MAX_AGE)))
                .email(faker.internet().emailAddress())
                .telephone(faker.phoneNumber().cellPhone())
                .designation(faker.name().title())
                .abn(atoService.generateValidABN())
                .build();*/

        String notificationType = NotificationType.values()[faker.random()
                                                                 .nextInt(NotificationType.values().length)].toString();

        String stringifyNotificationType = Arrays.stream(notificationType.split("_"))
                                                 .map(val -> val.substring(0, 1)
                                                                .concat(val.substring(1)
                                                                           .toLowerCase()))
                                                 .collect(Collectors.joining(" "));

        RandomStringGenerator randomStringGenerator = new RandomStringGenerator.Builder()
                .withinRange('0', 'z')
                .filteredBy(CharacterPredicates.LETTERS, CharacterPredicates.DIGITS)
                .build();

        return TableEntity.builder()
                          /*.id(faker.number()
                                   .digits(10))
                          .custodianName(CUSTODIAN_NAME)
                          .emailDestination(faker.internet()
                                                 .emailAddress())
                          .emailDescription(stringifyNotificationType)
                          .emailCcDestination(faker.internet()
                                                   .emailAddress())
                          .emailBccDestination(faker.internet()
                                                    .emailAddress())
                          .emailDistributionTime(faker.date()
                                                      .past(3650, 1, TimeUnit.DAYS)
                                                      .getTime())
                          .notificationType(notificationType)
                          .employerSceid("8b3d7ae2-19c0-4de2-ad0d-0fbeb73c2bba")*/
                          /*.attachments(new ArrayList<String>())
                          .hasAttachments(false)
                          .attachmentIdentifier(null)
                          .emailStatus("SENT")
                          .emailSubject(EMAIL_SUBJECT_PREFIX.concat(stringifyNotificationType))
                          .employerName("ACCOUNTANCY SERVICES PTY. LTD.")*/
                          .employeeLastName(faker.name()
                                                 .lastName())
                          .employeeFirstName(faker.name()
                                                  .firstName())
                          .employeeMiddleName(faker.name().nameWithMiddle().split("\\s")[1])
                          .employeeDob(LocalDate.ofInstant(faker.date()
                                                                .birthday(18, 65).toInstant(), ZoneId.systemDefault()))
                          .streetAddress(faker.address().streetAddress())
                          .employeeEmailAddress(faker.internet()
                                                     .emailAddress())
                          .memberClientIdentifier(randomStringGenerator.generate(12)
                          )
                          .payrollNumber(randomStringGenerator.generate(10))
                          .build();
    }

    public List<TableEntity> generateBulkDataForTableEntity(int howMany) {
        return IntStream.rangeClosed(1, howMany)
                        .mapToObj(entry -> generateSingleMemberData())
                        .collect(Collectors.toList());
    }

    enum NotificationType {
        OPT_OUT_NOTICE, PAYMENT_NOTIFICATION_EMAIL_TEMPLATE, WELCOME_EMAIL_TEMPLATE
    }

}
