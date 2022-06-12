package com.beoatch.spring_boot_rest.services;

import com.beoatch.spring_boot_rest.dao.HumanDAO;
import com.beoatch.spring_boot_rest.entity.Human;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class HumanServiceImpl implements HumanService {
    private HumanDAO humanDAO;

    @Autowired

    public HumanServiceImpl(HumanDAO humanDAO) {
        this.humanDAO = humanDAO;
    }

    @Override
    @Transactional
    public List<Human> showPeople() {
        return humanDAO.showPeople();
    }

    @Override
    @Transactional
    public void saveHuman(Human human) {
        humanDAO.saveHuman(human);
    }

    @Override
    @Transactional
    public Human getHuman(int id) {
        return humanDAO.getHuman(id);
    }

    @Override
    @Transactional
    public void deleteHuman(int id) {
        humanDAO.deleteHuman(id);
    }

    @Override
    public Object getHumanByDocNumber(int number) {
        return humanDAO.getHumanByDocNumber(number);
    }

    @Override
    public List<Human> getPeopleBySNP(String s, String n, String p) {
        return humanDAO.getPeopleBySNP(s, n, p);
    }

    @Override
    public List<Human> getPeopleByDateOfBirth(LocalDate date) {
        return humanDAO.getPeopleByDateOfBirth(date);
    }
}