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

    // Here is the kind of data you can generate http://dius.github.io/java-faker/apidocs/index.html
    // The 'column' name is the name that will appear for the column headers

    @CsvBindByName(column = "Given Name")
    private String firstName;

    @CsvBindByName(column = "Family Name")
    private String lastName;

    @CsvBindByName(column = "Payroll Number Identifier")
    private String payrollNumber;

    @CsvBindByName(column = "Member Client Identifier")
    private String memberNumber;

    @CsvBindByName(column = "Birth Date")
    private String dateOfBirth;

}
