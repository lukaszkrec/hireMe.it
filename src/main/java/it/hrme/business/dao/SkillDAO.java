package it.hrme.business.dao;

import it.hrme.domain.Skill;

import java.util.List;

public interface SkillDAO {

    List<Skill> findAll();
}
