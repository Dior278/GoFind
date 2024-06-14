package com.gofing.myapp.service.dto;

import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.gofing.myapp.domain.ApplicationUser} entity.
 */
@SuppressWarnings("common-java:DuplicatedBlocks")
public class ApplicationUserDTO implements Serializable {

    private Long id;

    @Min(value = 42)
    @Max(value = 42)
    private Integer additionalField;

    private UserDTO internalUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAdditionalField() {
        return additionalField;
    }

    public void setAdditionalField(Integer additionalField) {
        this.additionalField = additionalField;
    }

    public UserDTO getInternalUser() {
        return internalUser;
    }

    public void setInternalUser(UserDTO internalUser) {
        this.internalUser = internalUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ApplicationUserDTO)) {
            return false;
        }

        ApplicationUserDTO applicationUserDTO = (ApplicationUserDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, applicationUserDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ApplicationUserDTO{" +
            "id=" + getId() +
            ", additionalField=" + getAdditionalField() +
            ", internalUser=" + getInternalUser() +
            "}";
    }
}
