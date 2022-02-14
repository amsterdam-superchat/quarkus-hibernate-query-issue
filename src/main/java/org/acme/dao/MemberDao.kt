package org.acme.dao

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase
import org.acme.record.Member
import java.util.UUID
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class MemberDao : PanacheRepositoryBase<Member, UUID>