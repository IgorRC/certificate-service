package com.gnius.code.certificate_service.infraestructure.adapter.in.web;

import com.gnius.code.certificate_service.domain.model.Employee;
import com.gnius.code.certificate_service.domain.port.in.RegisterEmployeeUseCase;
import com.gnius.code.certificate_service.infraestructure.adapter.in.web.request.CreateEmployeeRequest;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller exposing endpoints for employee management.
 *
 * <p>Primary adapter responsible for request validation and response mapping.
 * Business rules belong to use cases.</p>
 *
 * @author igor ramos cruzado
 * @since 1.0
 * @version 1.0
 */

@RestController
@RequestMapping("api/v1/employees")
public class EmployeeController {

    @Autowired
    private RegisterEmployeeUseCase registerEmployeeUseCase;

    /**
     * Registers a new employee under a company.
     *
     * @param createEmployeeRequest request payload with employee attributes
     * @apiNote Consider returning a minimal read model (DTO) instead of the domain object.
     */
    @Operation(summary = "Register a new Employee")
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void create (@RequestBody CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = registerEmployeeUseCase.register(
                createEmployeeRequest.companyId(),
                createEmployeeRequest.firstName(),
                createEmployeeRequest.lastName(),
                createEmployeeRequest.email(),
                createEmployeeRequest.dateOfBirth()
        );
    }
}
