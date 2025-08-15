package com.gnius.code.certificate_service.domain.port.in;

import com.gnius.code.certificate_service.domain.model.Employee;


/**
 * Caso de uso para el registro de empleados en el sistema de gestión de certificados.
 * <p>
 * Este puerto de entrada define la operación necesaria para registrar un nuevo empleado
 * perteneciente a una empresa específica. La implementación de este caso de uso deberá
 * encargarse de validar los datos, asociar el empleado a la empresa correspondiente
 * y devolver la entidad creada.
 * </p>
 *
 * <p><b>Contexto:</b> Arquitectura Hexagonal (Clean Architecture).</p>
 *
 * @see Employee
 */
public interface  RegisterEmployeeUseCase {

    /**
     * Registra un nuevo empleado para una empresa específica.
     *
     * @param companyId    identificador único de la empresa a la que pertenece el empleado
     * @param firstName    nombre del empleado
     * @param lastName     apellido del empleado
     * @param email        correo electrónico del empleado
     * @param dateOfBirth  fecha de nacimiento del empleado en formato ISO-8601 (yyyy-MM-dd)
     * @return el {@link Employee} registrado
     * @throws IllegalArgumentException si alguno de los parámetros es inválido o nulo
     */
    Employee register(Long companyId, String firstName, String lastName, String email, String dateOfBirth);
}
