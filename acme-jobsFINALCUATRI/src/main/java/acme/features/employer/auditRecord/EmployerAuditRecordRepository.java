
package acme.features.employer.auditRecord;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.auditRecords.AuditRecord;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface EmployerAuditRecordRepository extends AbstractRepository {

	@Query("select r from AuditRecord r where r.id = ?1")
	AuditRecord findOneAuditRecordById(int id);

	@Query("select r from AuditRecord r where r.job.id = ?1 and r.status = 'PUBLISHED'")
	Collection<AuditRecord> findManyByJobId(int idJob);
}
