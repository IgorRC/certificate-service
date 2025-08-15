package com.gnius.code.certificate_service.infraestructure.adapter.in.web.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record  CreateCompanyRequest (
        @Schema(example = "Tech Innovators Inc.")
        @NotBlank String name,

        @Schema(example = "TAX12345678")
        @NotBlank String taxId,

        @Schema(example = "admin@techinnovators.com")
        @Email @NotBlank String contactEmail)
{}
