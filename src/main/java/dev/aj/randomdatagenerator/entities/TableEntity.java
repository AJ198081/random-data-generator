package dev.aj.randomdatagenerator.entities;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class TableEntity {

    @CsvBindByName(column = "FIRST_NAME")
    private String firstName;

    @CsvBindByName(column = "LAST_NAME")
    private String lastName;

    @CsvBindByName(column = "PAYROLL_NUMBER")
    private String payrollNumber;

    @CsvBindByName(column = "MEMBER_NUMBER")
    private String memberNumber;

    @CsvBindByName(column = "DATE_OF_BIRTH")
    private String dateOfBirth;

}
