package com.ims.restModel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UserRecord(
        Long id,
        String name,
        String birthDate,
        Gender gender,
        UserRoles role,
        String username,
        String email,
        String password,
        String phone,
        String bankName,
        long accountNumber,
        String companyName,
        boolean loggedIn) {
}