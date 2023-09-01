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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
class CandidateController {

    public static final String CANDIDATE_SAVE = "/candidate/save";

    private final CandidateService candidateService;
    private final SkillService skillService;

    private final CandidateMapper candidateMapper;
    private final SkillMapper skillMapper;

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
}




















