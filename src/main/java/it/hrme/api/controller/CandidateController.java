package it.hrme.api.controller;

import it.hrme.api.dto.CandidateDto;
import it.hrme.api.dto.SkillDto;
import it.hrme.api.dto.mapper.CandidateMapper;
import it.hrme.api.dto.mapper.SkillMapper;
import it.hrme.business.CandidateService;
import it.hrme.business.SkillService;
import it.hrme.domain.Candidate;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

@Slf4j
@Controller
@RequestMapping(CandidateController.API_CANDIDATE)
@RequiredArgsConstructor
class CandidateController {

    public static final String API_CANDIDATE = "/api/candidate";
    public static final String CANDIDATE_SAVE = "/save";
    public static final String CANDIDATE_DETAILS = "/{email}";

    private final CandidateService candidateService;
    private final SkillService skillService;

    private final CandidateMapper candidateMapper;
    private final SkillMapper skillMapper;

    @GetMapping
    public String candidates(Model model) {
        List<CandidateDto> candidateDtos = candidateService.findAll().stream()
                .map(candidateMapper::mapToDto)
                .toList();
        model.addAttribute("candidateDtos", candidateDtos);
        return "candidates";
    }

    @GetMapping(CANDIDATE_SAVE)
    public String candidateForm(Model model) {
        List<SkillDto> skillDtos = skillService.findAll().stream()
                .map(skillMapper::mapToDto)
                .toList();

        model.addAttribute("skillDtos", skillDtos);
        model.addAttribute("candidateDto", new CandidateDto());
        return "candidate_form";
    }

    @PostMapping(CANDIDATE_SAVE)
    public String processCandidateForm(@ModelAttribute CandidateDto candidateDto,
                                       BindingResult bindingResult,
                                       @RequestParam MultipartFile file) throws IOException {

        if (bindingResult.hasErrors()) {
            log.info(bindingResult.getObjectName());
            return "error";
        }

        candidateDto.setPhoto(file.getBytes());
        Candidate candidate = candidateMapper.mapFromDto(candidateDto);
        candidateService.save(candidate);
        return "redirect:/";
    }

    @GetMapping(CANDIDATE_DETAILS)
    public String candidateDetails(@PathVariable String email, Model model) {
        Candidate candidate = candidateService.findByEmail(email);
        CandidateDto candidateDto = candidateMapper.mapToDto(candidate);
        String candidateImage = candidateService.encodeCandidatePhoto(candidateDto);

        model.addAttribute("candidateImage", candidateImage);
        model.addAttribute("candidateDto", candidateDto);
        return "candidateDetails";
    }
}




















