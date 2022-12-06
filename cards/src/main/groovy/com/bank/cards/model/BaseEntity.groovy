package com.bank.cards.model

import lombok.Data
import org.hibernate.annotations.GenericGenerator
import org.hibernate.annotations.Type
import org.springframework.lang.Nullable

import javax.persistence.*

@MappedSuperclass
@Data
abstract class BaseEntity {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false, columnDefinition = "VARCHAR(90)")
    @Type(type = "uuid-char")
    UUID id

    /**
     * Auditable data set fields
     */
    @Temporal(TemporalType.TIMESTAMP)
    @Nullable
    private Date createdDate
    @Temporal(TemporalType.TIMESTAMP)
    @Nullable
    private Date lastModifiedDate
}
