package dev.aj.randomdatagenerator.entities;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@XmlRootElement(name = "member")
@XmlAccessorType(XmlAccessType.FIELD)
public class TableEntity {

    // Data types you can generate http://dius.github.io/java-faker/apidocs/index.html
    // The 'column' name translates to the column headers
    // Ensure the fields from this class are mapped to GenerateMemberData's 'generateSingleMemberData' method

    @CsvBindByName(column = "Title")
    @XmlElement
    private String title;

    @CsvBindByName(column = "Given Name")
    @XmlElement
    private String firstName;

    @CsvBindByName(column = "MEM_FIRST_NAME")
    @XmlElement
    private String lastName;

    @CsvBindByName(column = "Payroll Number Identifier")
    @XmlElement
    private String payrollNumber;

    @CsvBindByName(column = "Member Client Identifier")
    @XmlElement
    private String memberNumber;

    @CsvBindByName(column = "Birth Date")
    @XmlElement
    private String dateOfBirth;

    @CsvBindByName(column = "Email")
    @XmlElement
    private String email;

    @CsvBindByName(column = "Telephone")
    @XmlElement
    private String telephone;

    @CsvBindByName(column = "Designation")
    @XmlElement
    private String designation;
}
