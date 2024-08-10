package com.SugarRisk.website.SugarRisk.RepositoryLayer;

import com.SugarRisk.website.SugarRisk.ModelLayer.UserDataModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Repo extends JpaRepository<UserDataModel, Long> {
    Optional<UserDataModel> findById(Long Id);
}
