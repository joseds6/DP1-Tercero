
package acme.features.anonymous.topInvestorRecords;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import acme.entities.investorRecords.InvestorRecords;
import acme.framework.components.Model;
import acme.framework.components.Request;
import acme.framework.entities.Anonymous;
import acme.framework.services.AbstractListService;

@Service
public class AnonymousTopInvestorRecordsListService implements AbstractListService<Anonymous, InvestorRecords> {

	@Autowired
	private AnonymousTopInvestorRecordsRepository repository;


	@Override
	public boolean authorise(final Request<InvestorRecords> request) {
		assert request != null;

		return true;
	}

	@Override
	public void unbind(final Request<InvestorRecords> request, final InvestorRecords entity, final Model model) {
		assert request != null;
		assert entity != null;
		assert model != null;

		request.unbind(entity, model, "name", "investingStatements");

	}

	@Override
	public Collection<InvestorRecords> findMany(final Request<InvestorRecords> request) {
		assert request != null;
		Collection<InvestorRecords> result;
		result = this.repository.findManyAll();
		return result;
	}

}
