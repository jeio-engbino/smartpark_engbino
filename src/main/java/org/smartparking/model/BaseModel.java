package org.smartparking.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BaseModel {
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
