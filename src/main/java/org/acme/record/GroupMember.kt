package org.acme.record

import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "group_member")
class GroupMember(

    @Id
    @Column(name = "id")
    private val id: UUID,

    @Column(name = "group_id")
    val group: UUID,

    @Column(name = "member_id")
    val member: UUID,
)