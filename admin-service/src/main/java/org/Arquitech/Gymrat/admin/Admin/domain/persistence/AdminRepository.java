package org.Arquitech.Gymrat.admin.Admin.domain.persistence;

import org.Arquitech.Gymrat.admin.Admin.domain.model.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

}
