
package acme.features.employer.duty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.jobs.Duty;
import acme.entities.jobs.Job;
import acme.entities.roles.Employer;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Principal;
import acme.framework.services.AbstractShowService;

@Service
public class EmployerDutyShowService implements AbstractShowService<Employer, Duty> {

	@Autowired
	EmployerDutyRepository repository;


	@Override
	public boolean authorise(final Request<Duty> request) {
		assert request != null;

		boolean result;
		int dutyId;
		int descriptorId;
		Employer employer;
		Job job;
		Principal principal;

		dutyId = request.getModel().getInteger("id");
		descriptorId = this.repository.findDescriptorIDbyDutyId(dutyId);
		job = this.repository.findOneJobByDescriptorId(descriptorId);
		employer = job.getEmployer();
		principal = request.getPrincipal();

		result = employer.getUserAccount().getId() == principal.getAccountId();

		return result;
	}

	@Override
	public void unbind(final Request<Duty> request, final Duty entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "title", "description", "percentage");
		int id = entity.getId();
		int idDescriptor = this.repository.findDescriptorIDbyDutyId(id);
		boolean status = this.repository.findStatusJobByDescriptorId(idDescriptor);
		model.setAttribute("status", status);

	}

	@Override
	public Duty findOne(final Request<Duty> request) {
		assert request != null;

		Duty result;
		int id;

		id = request.getModel().getInteger("id");
		result = this.repository.findOneById(id);

		return result;
	}

}
