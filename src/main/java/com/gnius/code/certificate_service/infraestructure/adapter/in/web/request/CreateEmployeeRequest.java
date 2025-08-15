package com.gnius.code.certificate_service.infraestructure.adapter.in.web.request;

public record CreateEmployeeRequest (
        Long companyId,
        String firstName,
        String lastName,
        String email,
        String dateOfBirth
){}
