package br.site.db.expert;

import br.site.model.crfa.CRFa;
import br.site.model.expert.Expert;

public interface ExpertRepository {
	Expert by(CRFa crfa);
	void save(Expert expert);
	void update(Expert expert); 
}
