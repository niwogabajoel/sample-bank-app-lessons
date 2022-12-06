package com.bank.accounts.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
abstract class BaseEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(90)")
    @Type(type = "uuid-char")
    UUID id;

    /**
     * Auditable data set fields
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Nullable
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    @Nullable
    private Date lastModifiedDate;
}
