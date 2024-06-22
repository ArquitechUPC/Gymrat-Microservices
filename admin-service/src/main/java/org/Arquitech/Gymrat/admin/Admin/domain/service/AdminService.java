package org.Arquitech.Gymrat.admin.Admin.domain.service;

import org.Arquitech.Gymrat.admin.Admin.domain.model.entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminService {
    List<Admin> fetchAll();

    Optional<Admin> fetchById(Integer id);

    Admin save(Admin admin);

    Integer obtainUserId(String username, String email, String password, String phoneNumber, String address, String city, Integer companyId);
}
