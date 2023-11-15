package ru.netology.coursework.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ConfirmOperationDto {
    private final String code;
    private final String operationId;

    @Override
    public String toString() {
        return "ConfirmOperationDto{" +
                "code='" + code + '\'' +
                ", operationId='" + operationId + '\'' +
                '}';
    }
}




