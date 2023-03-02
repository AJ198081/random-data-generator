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

    // Data types you can generate http://dius.github.io/java-faker/apidocs/index.html
    // The 'column' name translates to the column headers
    // Ensure the fields from this class are mapped to GenerateMemberData's 'generateSingleMemberData' method

    @CsvBindByName(column = "Title")
    private String title;

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

    @CsvBindByName(column = "Email")
    private String email;

    @CsvBindByName(column = "Telephone")
    private String telephone;

    @CsvBindByName(column = "Designation")
    private String designation;
}
