package org.acme.resource

import io.quarkus.hibernate.reactive.panache.common.runtime.ReactiveTransactional
import io.smallrye.mutiny.Uni
import org.acme.dao.GroupDao
import org.acme.dao.GroupMemberDao
import org.acme.dao.MemberDao
import org.acme.dto.AddMemberToGroupRequestDTO
import org.acme.dto.CreateGroupRequestDTO
import org.acme.dto.CreateMemberRequestDTO
import org.acme.dto.GetMemberGroupsResponseDTO
import org.acme.record.Group
import org.acme.record.GroupMember
import org.acme.record.Member
import org.jboss.resteasy.reactive.RestPath
import java.util.UUID
import javax.ws.rs.GET
import javax.ws.rs.POST
import javax.ws.rs.Path

@Path("/reproducer")
class ReproducerResource(
    private val groupDao: GroupDao,
    private val groupMemberDao: GroupMemberDao,
    private val memberDao: MemberDao,
) {

    @POST
    @Path("groups")
    @ReactiveTransactional
    fun createGroup(requestDTO: CreateGroupRequestDTO): Uni<UUID> {
        return groupDao.persist(Group(UUID.randomUUID(), requestDTO.name)).map { it.id }
    }

    @POST
    @Path("members")
    @ReactiveTransactional
    fun createMember(requestDTO: CreateMemberRequestDTO): Uni<UUID> {
        return memberDao.persist(Member(UUID.randomUUID(), requestDTO.name)).map { it.id }
    }

    @POST
    @ReactiveTransactional
    @Path("groups/{group}/members")
    fun addMemberToGroup(@RestPath group: UUID, requestDTO: AddMemberToGroupRequestDTO): Uni<UUID> {
        val randomUUID = UUID.randomUUID()
        return groupMemberDao.persist(
            GroupMember(
                randomUUID,
                group,
                requestDTO.member
            )
        )
            .map { randomUUID }
    }

    @GET
    @Path("members/{member}/groups")
    fun get(@RestPath member: UUID): Uni<GetMemberGroupsResponseDTO> {
        return groupMemberDao.findByMember(member)
            .map { GetMemberGroupsResponseDTO(it.map { record -> record.member }) }
    }
}