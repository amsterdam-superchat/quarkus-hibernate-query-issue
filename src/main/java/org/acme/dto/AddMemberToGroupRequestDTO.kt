package org.acme.dto

import java.util.UUID

data class AddMemberToGroupRequestDTO(
    val member: UUID,
)