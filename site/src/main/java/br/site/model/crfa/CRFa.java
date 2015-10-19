package br.site.model.crfa;

import static br.site.util.StringUtil.removeBlankSpace;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="crfa")
public class CRFa {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column
	private Integer registry;
	
	@Column
	private Integer region;
	
	public CRFa() {
	}
	
	public Integer getId() {
		return id;
	}
	
	public Integer getRegistry() {
		return registry;
	}
	
	public Integer getRegion() {
		return region;
	}
	
	public String getCompleteRegistry() {
		return region + " - " + registry;
	}
	
	public static Map<String, Integer> registry(String crfaUser) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		String[] str = removeBlankSpace(crfaUser).split("-");
		Integer[] array = new Integer[str.length];
		
		for (int i = 0; i < str.length; i++) {
			array[i] = Integer.parseInt(str[i]);
		}
		
		map.put("region", array[0]);
		map.put("registry", array[1]);
		
		return map;
	}
}
