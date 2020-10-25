package com.gachon.codiz.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "mysql.grammers")
public class Grammer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "description")
    private String description;

    @Column(name = "grammer_name")
    private String grammerName;

    @Column(name = "grammer_type")
    private GrammerType grammerType;

    private Grammer() {
    }

    @JsonCreator
    public Grammer(@JsonProperty("description") String description,
                   @JsonProperty("grammerType") GrammerType grammerType,
                   @JsonProperty("grammerName") String grammerName) {
        this.description = description;
        this.grammerType = grammerType;
        this.grammerName = grammerName;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getGrammerName() {
        return grammerName;
    }

    public GrammerType getGrammerType() {
        return grammerType;
    }

    @Override
    public String toString() {
        return "Grammer{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", grammerName='" + grammerName + '\'' +
                ", grammerType=" + grammerType +
                '}';
    }

    public enum GrammerType {
        CONDITIONAL, ITERATION, FUNCTION
    }
}
