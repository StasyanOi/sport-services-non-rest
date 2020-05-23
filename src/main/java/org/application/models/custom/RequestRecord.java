package org.application.models.custom;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestRecord {
    private Long id;
    private String type;
    private String out;
    private String to;
    private LocalDate date;
}
