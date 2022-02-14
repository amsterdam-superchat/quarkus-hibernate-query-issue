package org.acme.dao

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase
import io.smallrye.mutiny.Uni
import org.acme.record.GroupMember
import java.util.UUID
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GroupMemberDao : PanacheRepositoryBase<GroupMember, UUID> {

    fun findByMember(member: UUID): Uni<List<GroupMember>> {
        return find("member = ?1", member)
            .list()
    }
}