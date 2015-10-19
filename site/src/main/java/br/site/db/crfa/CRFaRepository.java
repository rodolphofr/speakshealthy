package br.site.db.crfa;

import java.util.Map;

import br.site.model.crfa.CRFa;

public interface CRFaRepository {
	CRFa by(Map<String, Integer> registry);
}
