package org.Arquitech.Gymrat.admin.Admin.service;

import org.Arquitech.Gymrat.admin.Admin.client.UserAdmin;
import org.Arquitech.Gymrat.admin.Admin.domain.model.entity.Admin;
import org.Arquitech.Gymrat.admin.Admin.domain.persistence.AdminRepository;
import org.Arquitech.Gymrat.admin.Admin.domain.persistence.CompanyRepository;
import org.Arquitech.Gymrat.admin.Admin.domain.service.AdminService;
import org.Arquitech.Gymrat.admin.Admin.resource.RequestUserCompany;
import org.Arquitech.Gymrat.admin.Shared.exception.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private UserAdmin userAdmin;

    public AdminServiceImpl(AdminRepository adminRepository, UserAdmin userAdmin, CompanyRepository companyRepository){
        this.companyRepository=companyRepository;
        this.adminRepository=adminRepository;
        this.userAdmin=userAdmin;
    }

    @Override
    public List<Admin> fetchAll() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> fetchById(Integer id) {
        return adminRepository.findById(id);
    }

    @Override
    public Admin save(Admin admin) {
        return adminRepository.save(admin);
    }

    @Override
    public Integer obtainUserId(String username, String email, String password, String phoneNumber, String address, String city, Integer companyId) {
        companyRepository.findById(companyId).orElseThrow(() -> new CustomException("Company not found", HttpStatus.NOT_FOUND));

        RequestUserCompany request = new RequestUserCompany();
        request.setUsername(username);
        request.setEmail(email);
        request.setPassword(password);
        request.setPhoneNumber(phoneNumber);
        request.setAddress(address);
        request.setCity(city);
        request.setCompanyId(companyId);

        return userAdmin.ObtainUserId(request);
    }
}
