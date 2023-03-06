package com.example.firstSpringDemo.RequestObjects;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;

@Setter
@Getter
@Data

public class SchoolReqositForCuruatDuteApdate {

    String Data;
    Integer Id;
}
