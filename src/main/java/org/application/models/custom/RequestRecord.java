package org.application.models.custom;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class RequestRecord {
    private Long id;
    private String type;
    private String out;
    private String to;
    private LocalDate date;
}
