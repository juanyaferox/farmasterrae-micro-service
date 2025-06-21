package dev.juanyaferox.infrastructure.api.mapper;

import dev.juanyaferox.application.core.usecase.credentials.dto.ChangePasswordCommand;
import dev.juanyaferox.infrastructure.api.dto.credentials.ChangePasswordApiRequest;
import org.mapstruct.Mapper;

@Mapper (componentModel = "spring")
public interface CredentialsMapper {
    ChangePasswordCommand changePasswordCommandFromChangePasswordApiRequest(ChangePasswordApiRequest request);
}
