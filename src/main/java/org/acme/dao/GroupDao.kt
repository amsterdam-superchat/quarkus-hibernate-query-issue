package org.acme.dao

import io.quarkus.hibernate.reactive.panache.PanacheRepositoryBase
import org.acme.record.Group
import java.util.UUID
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class GroupDao : PanacheRepositoryBase<Group, UUID>