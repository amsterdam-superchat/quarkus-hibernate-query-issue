package org.acme.record

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "`group`")
class Group(
    @Id
    @Column(name = "id")
    val id: UUID,

    @Column(name = "name")
    val name: String,
)