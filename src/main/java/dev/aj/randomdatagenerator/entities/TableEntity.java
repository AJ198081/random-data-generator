package dev.aj.randomdatagenerator.entities;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement(name = "member") // translates to Xml tag name for the root element of this type
@XmlAccessorType(XmlAccessType.FIELD)
public class TableEntity {

    // Data types you can generate http://dius.github.io/java-faker/apidocs/index.html
    // Ensure the fields from this class are appropriately mapped to GenerateMemberData's 'generateSingleMemberData' method

    @CsvBindByName(column = "Title") // translates to csv header for this field
    @XmlElement(name = "title") // translates to Xml tag name for this field
    private String title;

    @CsvBindByName(column = "MEM_FIRST_NAME")
    @XmlElement(name = "first-name")
    private String firstName;

    @CsvBindByName(column = "MEM_LAST_NAME")
    @XmlElement(name = "last-name")
    private String lastName;

    @CsvBindByName(column = "Payroll Number Identifier")
    @XmlElement(name = "payroll-number")
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

    @CsvBindByName(column = "ABN")
    @XmlElement(name = "abn")
    private String abn;
}
