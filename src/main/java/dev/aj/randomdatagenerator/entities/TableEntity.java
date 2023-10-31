package dev.aj.randomdatagenerator.entities;

import com.opencsv.bean.CsvBindByName;
import java.util.ArrayList;
import lombok.*;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TableEntity {

    // Data types you can generate http://dius.github.io/java-faker/apidocs/index.html
    // Ensure the fields from this class are appropriately mapped to GenerateMemberData's 'generateSingleMemberData' method

    @CsvBindByName(column = "id") // translates to csv header for this field
    @XmlElement(name = "id")
    private String id;

    @CsvBindByName(column = "MEM_FIRST_NAME")
    @XmlElement
    private String custodianName;

    @CsvBindByName(column = "MEM_LAST_NAME")
    @XmlElement
    private String emailDestination;

    @CsvBindByName(column = "Payroll Number Identifier")
    @XmlElement
    private String emailDescription;

    @CsvBindByName(column = "Member Client Identifier")
    @XmlElement
    private String emailCcDestination;

    @CsvBindByName(column = "Birth Date")
    @XmlElement
    private String emailBccDestination;

    @CsvBindByName(column = "Email")
    @XmlElement
    private Long emailDistributionTime;

    @CsvBindByName(column = "Telephone")
    @XmlElement
    private String notificationType;

    @CsvBindByName(column = "Designation")
    @XmlElement
    private String employerSceid;

    @CsvBindByName(column = "ABN")
    @XmlElement
    private String memberGlobalId;

    @CsvBindByName(column = "Member Client Identifier")
    @XmlElement
    private String emailContent;

    @CsvBindByName(column = "Birth Date")
    @XmlElement
    private ArrayList<String> attachments;

    @CsvBindByName(column = "Email")
    @XmlElement
    private boolean hasAttachments;

    @CsvBindByName(column = "Telephone")
    @XmlElement
    private String attachmentIdentifier;

    @CsvBindByName(column = "Designation")
    @XmlElement
    private String emailStatus;

    @CsvBindByName(column = "ABN")
    @XmlElement
    private String emailSubject;

    @CsvBindByName(column = "Member Client Identifier")
    @XmlElement
    private String employerName;

    @CsvBindByName(column = "Birth Date")
    @XmlElement
    private String employeeFirstName;

    @CsvBindByName(column = "Email")
    @XmlElement
    private String employeeLastName;

    @CsvBindByName(column = "Telephone")
    @XmlElement
    private String employeePayrollId;

    @CsvBindByName(column = "Designation")
    @XmlElement
    private String employeeEmailAddress;

    @CsvBindByName(column = "ABN")
    @XmlElement
    private String employeeDob;

    @CsvBindByName(column = "employerAbn")
    @XmlElement(name = "employerAbn")
    private String employerAbn;
}
