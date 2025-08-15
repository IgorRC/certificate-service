package com.gnius.code.certificate_service.infraestructure.adapter.in.web;

import com.gnius.code.certificate_service.domain.model.Company;
import com.gnius.code.certificate_service.domain.port.in.RegisterCompanyUseCase;
import com.gnius.code.certificate_service.infraestructure.adapter.in.web.request.CreateCompanyRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller exposing endpoints for company management.
 *
 * <p>This is a primary adapter (inbound) in the hexagonal architecture, translating
 * HTTP requests into use case invocations.</p>
 *
 * @author igor ramos cruzado
 * @since 1.0
 * @version 1.0
 */
@RestController
@RequestMapping("api/v1/companies")
public class CompanyController {

    @Autowired
    private RegisterCompanyUseCase registerCompanyUseCase;

    /**
     * Registers a new company in the system.
     *
     * @param createCompanyRequest the company registration request
     * @return the registered {@link CreateCompanyRequest} entity
     *
     * @since 1.0
     */
    @Operation(
            summary = "Register a new company",
            description = "Creates a new company with a unique tax ID and contact information.")
    @ApiResponses( value = {
            @ApiResponse(responseCode = "201", description = "Company successfully registered"),
            @ApiResponse(responseCode = "400", description = "Invalid input data")
    })
    @PostMapping
    public ResponseEntity<Company> createCompany(@Valid @RequestBody CreateCompanyRequest createCompanyRequest){
         Company company = registerCompanyUseCase.registerCompany(
                createCompanyRequest.name(),
                createCompanyRequest.taxId(),
                createCompanyRequest.contactEmail());
         return ResponseEntity.status(HttpStatus.CREATED).body(company);
    }
}
