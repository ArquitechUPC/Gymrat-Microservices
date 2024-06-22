package org.Arquitech.Gymrat.admin.Admin.api.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.Arquitech.Gymrat.admin.Admin.domain.model.entity.Admin;
import org.Arquitech.Gymrat.admin.Admin.domain.model.entity.Company;
import org.Arquitech.Gymrat.admin.Admin.domain.service.AdminService;
import org.Arquitech.Gymrat.admin.Admin.domain.service.CompanyService;
import org.Arquitech.Gymrat.admin.Admin.mapping.AdminMapper;
import org.Arquitech.Gymrat.admin.Admin.mapping.CompanyMapper;
import org.Arquitech.Gymrat.admin.Admin.resource.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Admin", description = "Create, Read, Update and delete admins entities")
@AllArgsConstructor
@RestController
@RequestMapping("api/v1/admins")
public class AdminController {

    private final AdminService adminService;
    private final AdminMapper mapper;

    @Operation(summary = "Get all registered admins", responses = {
            @ApiResponse(description = "Successfully fetched all admins",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AdminResource.class)))
    })
    @GetMapping
    public List<Admin> fetchAll() {
        return adminService.fetchAll();
    }

    @Operation(summary = "Get a admin by id", responses = {
            @ApiResponse(description = "Successfully fetched admin by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CompanyResource.class)))
    })
    @GetMapping("{id}")
    public AdminResource fetchById(@PathVariable Integer id) {
        return this.mapper.toResource(adminService.fetchById(id).get());
    }

    @Operation(summary = "Save a admin", responses = {
            @ApiResponse(description = "Admin successfully created",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = AdminResource.class)))
    })
    @PostMapping
    public AdminResource save(@RequestBody CreateAdminUserResource resource){
        CreateAdminResource adminResource = new CreateAdminResource();
        adminResource.setGivenUser(adminService.obtainUserId(
                resource.getUsername(), resource.getEmail(), resource.getPassword(),
                resource.getPhoneNumber(), resource.getAddress(), resource.getCity(), resource.getCompanyId()));

        return this.mapper.toResource(adminService.save(this.mapper.toModel(adminResource)));
    }

}
