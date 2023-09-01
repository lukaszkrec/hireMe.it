package it.hrme.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContractDto {

    private Long id;
    private String uuid;
    private LocalDate startDate;
    private LocalDate endDate;
    private CandidateDto candidate;
    private JobOfferDto jobOffer;
}
