package com.beoatch.spring_boot_rest.dao;

import com.beoatch.spring_boot_rest.entity.Human;

import java.time.LocalDate;
import java.util.List;

public interface HumanDAO {

    public List<Human> showPeople();

    public void saveHuman(Human human);

    public Human getHuman(int id);

    public void deleteHuman(int id);

    public Object getHumanByDocNumber(int number);

    public List<Human> getPeopleBySNP(String s, String n, String p);

    public List<Human> getPeopleByDateOfBirth(LocalDate date);
}