package org.server.jpa;

import lombok.*;
import org.server.jpa.servingclasses.classes.Coordinates;
import org.server.jpa.servingclasses.classes.DragonCave;
import org.server.jpa.servingclasses.enums.Color;
import org.server.jpa.servingclasses.enums.DragonCharacter;
import org.server.jpa.servingclasses.enums.DragonType;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Dragon {
    private long id;

    private String name;

    private Coordinates coordinates;

    private Date creationDate;

    private long age;

    private Color color;

    private DragonType type;

    private DragonCharacter character;

    private DragonCave cave;
}
