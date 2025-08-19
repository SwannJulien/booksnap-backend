package net.booksnap.common.dto;

import java.util.Date;

public record AuditDTO (
        Date createdAt,
        Date updatedAt
) {}