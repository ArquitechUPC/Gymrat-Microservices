package org.Arquitech.Gymrat.admin.Admin.api.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.Arquitech.Gymrat.admin.Admin.domain.model.entity.Company;
import org.Arquitech.Gymrat.admin.Admin.domain.service.CompanyService;
import org.Arquitech.Gymrat.admin.Admin.mapping.CompanyMapper;
import org.Arquitech.Gymrat.admin.Admin.resource.CompanyResource;
import org.Arquitech.Gymrat.admin.Admin.resource.CreateCompanyResource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Companies", description = "Create, Read, Update and delete companies entities")
@RestController
@RequestMapping("api/v1/companies")
@AllArgsConstructor
public class CompanyController {
    private final CompanyService companyService;
    private final CompanyMapper mapper;

    @Operation(summary = "Get all registered companies", responses = {
            @ApiResponse(description = "Successfully fetched all companies",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CompanyResource.class)))
    })
    @GetMapping
    public List<Company> fetchAll() {
        return companyService.fetchAll();
    }

    @Operation(summary = "Get a company by id", responses = {
            @ApiResponse(description = "Successfully fetched company by id",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CompanyResource.class)))
    })
    @GetMapping("{id}")
    public CompanyResource fetchById(@PathVariable Integer id) {
        return this.mapper.toResource(companyService.fetchById(id).get());
    }

    @Operation(summary = "Save a company", responses = {
            @ApiResponse(description = "Company successfully created",
                    responseCode = "201",
                    content = @Content(mediaType = "application/json",
                            schema = @Schema(implementation = CompanyResource.class)))
    })
    @PostMapping
    public CompanyResource save(@RequestBody CreateCompanyResource resource){
        return this.mapper.toResource(companyService.save(this.mapper.toModel(resource)));
    }

    

}
