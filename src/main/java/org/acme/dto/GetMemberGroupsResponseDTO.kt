package org.acme.dto

import java.util.UUID

data class GetMemberGroupsResponseDTO(
    val groups: List<UUID>
)