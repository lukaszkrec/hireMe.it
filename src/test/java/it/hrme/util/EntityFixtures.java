package it.hrme.util;

import it.hrme.domain.*;
import it.hrme.infrastructure.database.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.HexFormat;
import java.util.Set;

import static it.hrme.infrastructure.database.entity.EmploymentFormEntity.Form.B2B;
import static it.hrme.infrastructure.database.entity.WorkTypeEntity.Type.HYBRID;

public interface EntityFixtures {

    default Candidate getCandidate() {
        return Candidate.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .phone("+48 523 854 455")
                .email("jan.kowalski.@gmail.com")
                .photo(getPhoto())
                .overview("Some text     example about yourself")
                .workInterest(true)
                .skills(Set.of(getSkill()))
                .status(Candidate.Status.ACTIVE)
                .address(getAddress())
                .contracts(Set.of(getContract()))
                .build();
    }

    default Contract getContract() {
        return Contract.builder()
                .startDate(LocalDate.of(2023, 2, 1))
                .endDate(LocalDate.of(2024, 3, 6))
                .build();
    }

    default Address getAddress() {
        return Address.builder()
                .country("Poland")
                .city("Krakow")
                .postalCode("54-564")
                .street("Zwycięstwa 16")
                .build();
    }

    default Skill getSkill() {
        return Skill.builder()
                .skillName("Java")
                .build();
    }

    default AgentEntity getAgentEntity() {
        return AgentEntity.builder()
                .firstName("Ania z HR")
                .lastName("Anitówna")
                .phoneNumber("+48 754 324 456")
                .email("ania.anitowna@gmail.com")
                .company(getCompanyEntity())
                .jobOffers(new HashSet<>())
                .build();
    }

    default Agent getAgent() {
        return Agent.builder()
                .firstName("John")
                .lastName("Doe")
                .phoneNumber("+48 609 543 456")
                .email("john.doe@gmail.com")
                .company(getCompany())
                .jobOffers(Set.of(getJobOffer()))
                .build();
    }

    default JobOffer getJobOffer() {
        return JobOffer.builder()
                .title("Junior Java Developer ")
                .description("Supper company")
                .salary(new BigDecimal("15000"))
                .datePublished(LocalDate.now())
                .skills(Set.of(getSkill()))
                .contract(getContract())
                .workTypes(Set.of(getWorkType()))
                .requiredWorkAvailabilities(Set.of(getRequiredWorkAvailability()))
                .employmentForms(Set.of(getEmploymentForm()))
                .locations(Set.of(getLocation()))
                .build();
    }

    default Location getLocation() {
        return Location.builder()
                .country("Poland")
                .city("Gdańsk")
                .postalCode("34-512")
                .address("Gdańska 55c")
                .build();
    }

    default EmploymentForm getEmploymentForm() {
        return EmploymentForm.builder()
                .form(EmploymentForm.Form.EMPLOYMENT_CONTRACT)
                .build();

    }

    default RequiredWorkAvailability getRequiredWorkAvailability() {
        return RequiredWorkAvailability.builder()
                .workAvailability(RequiredWorkAvailability.WorkAvailability.PART_TIME)
                .build();
    }

    default WorkType getWorkType() {
        return WorkType.builder()
                .type(WorkType.Type.REMOTE)
                .build();

    }

    default Company getCompany() {
        return Company.builder()
                .companyName("Januszex")
                .industry("Automotive")
                .description("Fast growing company")
                .address(getAddress())
                .build();
    }

    default JobOfferEntity getJobOfferEntity() {
        return JobOfferEntity.builder()
                .title("Junior Java Developer ")
                .description("Supper company")
                .salary(new BigDecimal("15000"))
                .datePublished(LocalDate.now())
                .skills(Set.of(getSkillEntity()))
                .agent(getAgentEntity())
                .build();
    }

    default LocationEntity getLocationEntity() {
        return LocationEntity.builder()
                .country("Poland")
                .city("Gdańsk")
                .postalCode("34-512")
                .address("Gdańska 55c")
                .build();
    }

    default EmploymentFormEntity getEmploymentFormEntity() {
        return EmploymentFormEntity.builder()
                .form(B2B)
                .jobOffers(Set.of(getJobOfferEntity()))
                .build();
    }

    default RequiredWorkAvailabilityEntity getRequiredWorkAvailabilityEntity() {
        return RequiredWorkAvailabilityEntity.builder()
                .workAvailability(RequiredWorkAvailabilityEntity.WorkAvailability.FULL_TIME)
                .jobOffers(Set.of(getJobOfferEntity()))
                .build();
    }

    default WorkTypeEntity getWorkTypeEntity() {
        return WorkTypeEntity.builder()
                .type(HYBRID)
                .jobOffers(Set.of(getJobOfferEntity()))
                .build();
    }

    default ContractEntity getContractEntity() {
        return ContractEntity.builder()
                .startDate(LocalDate.of(2023, 2, 1))
                .endDate(LocalDate.of(2024, 3, 6))
                .jobOffer(getJobOfferEntity())
                .build();
    }

    default CandidateEntity getCandidateEntity() {
        return CandidateEntity.builder()
                .firstName("Jan")
                .lastName("Kowalski")
                .phone("+48 523 854 455")
                .email("jan.kowalski.@gmail.com")
                .photo(getPhoto())
                .overview("Some text example about yourself")
                .workInterest(true)
                .skills(Set.of(getSkillEntity()))
                .status(CandidateEntity.Status.ACTIVE)
                .address(getAddressEntity())
                .build();
    }

    default byte[] getPhoto() {
        return HexFormat.of()
                .parseHex("e04fd020ea3a6910a2d808002b30309d");
    }


    default SkillEntity getSkillEntity() {
        return SkillEntity.builder()
                .skillName("Java")
                .build();
    }

    default CompanyEntity getCompanyEntity() {
        return CompanyEntity.builder()
                .companyName("Januszex")
                .industry("Automotive")
                .description("Fast growing company")
                .address(getAddressEntity())
                .build();
    }

    default AddressEntity getAddressEntity() {
        return AddressEntity.builder()
                .country("Poland")
                .city("Krakow")
                .postalCode("54-564")
                .street("Zwycięstwa 16")
                .build();
    }
}
