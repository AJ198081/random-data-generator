package dev.aj.randomdatagenerator.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

// name translates to the root element in the whole of xml, i.e. title of list
@XmlRootElement(name = "members")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class XmlListWrapper {

    // name translates to each element in the list
    @XmlElement(name = "member")
    private List<TableEntity> tableEntities;

}
