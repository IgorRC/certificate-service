package com.gnius.code.certificate_service.application.usecase;

import com.gnius.code.certificate_service.domain.model.Employee;
import com.gnius.code.certificate_service.domain.port.in.RegisterEmployeeUseCase;
import com.gnius.code.certificate_service.domain.port.out.EmployeeRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

/**
 * Application service implementing {@link RegisterEmployeeUseCase}.
 * <p>
 * This service coordinates the process of registering a new employee,
 * constructing the corresponding {@link Employee} domain model, and
 * delegating persistence operations to the {@link EmployeeRepositoryPort}.
 * </p>
 *
 * <p><b>Context:</b> Application layer in Hexagonal Architecture.</p>
 *
 * <p><b>Implementation notes:</b></p>
 * <ul>
 *   <li>Validates and constructs the employee entity from provided input data.</li>
 *   <li>Delegates persistence to the outbound port implementation.</li>
 *   <li>Considers that referential integrity checks (e.g., verifying company existence)
 *       should be handled at this level or delegated to the domain logic.</li>
 *   <li>Potential improvements: normalize {@code email}, trim names, validate date formats.</li>
 * </ul>
 *
 * @author igor ramos cruzado
 * @see Employee
 * @see EmployeeRepositoryPort
 * @since 1.0
 * @version 1.0
 */
@Service
@RequiredArgsConstructor(onConstructor_ = @Autowired)
public class RegisterEmployeeService implements RegisterEmployeeUseCase {

    private final EmployeeRepositoryPort  employeeRepositoryPort;

    /**
     * Registers a new employee for a specific company.
     *
     * @param companyId    the unique identifier of the company to which the employee will belong
     * @param firstName    the employee's first name
     * @param lastName     the employee's last name
     * @param email        the employee's email address
     * @param dateOfBirth  the employee's date of birth in ISO-8601 format (yyyy-MM-dd)
     * @return the persisted {@link Employee} entity
     * @throws java.time.format.DateTimeParseException if {@code dateOfBirth} is not in the expected format
     */
    @Override
    public Employee register(Long companyId, String firstName, String lastName, String email, String dateOfBirth) {
        Employee employee = new Employee(
                null,
                companyId,
                firstName,
                lastName,
                email,
                LocalDate.parse(dateOfBirth),
                true
        );
        return employeeRepositoryPort.save(employee);
    }
}
