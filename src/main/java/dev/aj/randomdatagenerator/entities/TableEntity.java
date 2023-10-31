package dev.aj.randomdatagenerator.entities;

import com.opencsv.bean.CsvBindByName;
import java.time.Instant;
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

    @CsvBindByName(column = "id")
    @XmlElement(name = "id")
    private String id;

    @CsvBindByName
    @XmlElement
    private String custodianName;

    @CsvBindByName
    @XmlElement
    private String emailDestination;

    @CsvBindByName
    @XmlElement
    private String emailDescription;

    @CsvBindByName
    @XmlElement
    private String emailCcDestination;

    @CsvBindByName
    @XmlElement
    private String emailBccDestination;

    @CsvBindByName
    @XmlElement
    private Long emailDistributionTime;

    @CsvBindByName
    @XmlElement
    private String notificationType;

    @CsvBindByName
    @XmlElement
    private String employerSceid;

    @CsvBindByName
    @XmlElement
    private String memberGlobalId;

    @CsvBindByName
    @XmlElement
    private String emailContent;

    @CsvBindByName
    @XmlElement
    private ArrayList<String> attachments;

    @CsvBindByName
    @XmlElement
    private boolean hasAttachments;

    @CsvBindByName
    @XmlElement
    private String attachmentIdentifier;

    @CsvBindByName
    @XmlElement
    private String emailStatus;

    @CsvBindByName
    @XmlElement
    private String emailSubject;

    @CsvBindByName
    @XmlElement
    private String employerName;

    @CsvBindByName
    @XmlElement
    private String employeeFirstName;

    @CsvBindByName
    @XmlElement
    private String employeeLastName;

    @CsvBindByName
    @XmlElement
    private String employeePayrollId;

    @CsvBindByName
    @XmlElement
    private String employeeEmailAddress;

    @CsvBindByName
    @XmlElement
    private Long employeeDob;

    @CsvBindByName
    @XmlElement(name = "employerAbn")
    private String employerAbn;
}
