package it.hrme.business;

import it.hrme.business.dao.SkillDAO;
import it.hrme.domain.Skill;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SkillService {

    private final SkillDAO skillDAO;

    @Transactional
    public List<Skill> findAll() {
        return skillDAO.findAll();
    }
}
