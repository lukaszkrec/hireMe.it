package it.hrme.util;

import it.hrme.domain.*;
import it.hrme.infrastructure.database.constants.*;
import it.hrme.infrastructure.database.entity.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.HexFormat;
import java.util.List;
import java.util.Set;

import static it.hrme.infrastructure.database.constants.Form.*;
import static it.hrme.infrastructure.database.constants.Status.*;
import static it.hrme.infrastructure.database.constants.Type.*;
import static it.hrme.infrastructure.database.constants.WorkAvailability.*;

public interface EntityFixtures {

    default List<SkillEntity> getSkillsEntityList() {
        return List.of(
                SkillEntity.builder()
                        .skillName(SkillName.JAVA)
                        .build(),
                SkillEntity.builder()
                        .skillName(SkillName.C_SHARP)
                        .build(),
                SkillEntity.builder()
                        .skillName(SkillName.C_PLUS_PLUS)
                        .build(),
                SkillEntity.builder()
                        .skillName(SkillName.SQL)
                        .build(),
                SkillEntity.builder()
                        .skillName(SkillName.PYTHON)
                        .build()
        );
    }

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
                .status(ACTIVE)
                .contracts(Set.of(getContract()))
                .build();
    }

    default Contract getContract() {
        return Contract.builder()
                .startDate(LocalDate.of(2023, 2, 1))
                .endDate(LocalDate.of(2024, 3, 6))
                .build();
    }

    default Skill getSkill() {
        return Skill.builder()
                .skillName(SkillName.JAVA)
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
                .form(EMPLOYMENT_CONTRACT)
                .build();

    }

    default RequiredWorkAvailability getRequiredWorkAvailability() {
        return RequiredWorkAvailability.builder()
                .workAvailability(PART_TIME)
                .build();
    }

    default WorkType getWorkType() {
        return WorkType.builder()
                .type(REMOTE)
                .build();

    }

    default Company getCompany() {
        return Company.builder()
                .companyName("Januszex")
                .industry("Automotive")
                .description("Fast growing company")
                .build();
    }

    default JobOfferEntity getJobOfferEntity1() {
        return JobOfferEntity.builder()
                .title("Junior Java Developer ")
                .description("Supper company")
                .salary(new BigDecimal("15000"))
                .datePublished(LocalDate.now())
                .agent(getAgentEntity())
                .build();
    }

    default JobOfferEntity getJobOfferEntity2() {
        return JobOfferEntity.builder()
                .title("Junior QA")
                .description("Nice")
                .salary(new BigDecimal("4562.43"))
                .datePublished(LocalDate.now())
                .agent(getAgentEntity())
                .build();
    }

    default LocationEntity getLocationEntity1() {
        return LocationEntity.builder()
                .country("Poland")
                .city("Gdańsk")
                .postalCode("34-512")
                .address("Gdańska 55c")
                .build();
    }

    default LocationEntity getLocationEntity2() {
        return LocationEntity.builder()
                .country("Poland")
                .city("Koszalin")
                .postalCode("75-512")
                .address("Koszalinska 125a")
                .build();
    }

    default ContractEntity getContractEntity() {
        return ContractEntity.builder()
                .startDate(LocalDate.of(2023, 2, 1))
                .endDate(LocalDate.of(2024, 3, 6))
                .jobOffer(getJobOfferEntity1())
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
                .status(ACTIVE)
                .build();
    }

    default byte[] getPhoto() {
        return HexFormat.of()
                .parseHex("e04fd020ea3a6910a2d808002b30309d");
    }


    default SkillEntity getSkillEntity1() {
        return SkillEntity.builder()
                .skillName(SkillName.JAVA)
                .build();
    }

    default SkillEntity getSkillEntity2() {
        return SkillEntity.builder()
                .skillName(SkillName.SQL)
                .build();
    }

    default CompanyEntity getCompanyEntity() {
        return CompanyEntity.builder()
                .companyName("Januszex")
                .industry("Automotive")
                .description("Fast growing company")
                .build();
    }
}
