package it.hrme.api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LocationDto {

    private Long id;
    private String uuid;
    private String country;
    private String city;
    private String postalCode;
    private String address;
    private Set<JobOfferDto> jobOffers;
}
