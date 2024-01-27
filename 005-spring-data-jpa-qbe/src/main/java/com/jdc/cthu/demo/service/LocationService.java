package com.jdc.cthu.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.geo.Distance;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.jdc.cthu.demo.dto.DistrictDto;
import com.jdc.cthu.demo.entity.District;
import com.jdc.cthu.demo.entity.State;
import com.jdc.cthu.demo.repo.DistrictRepo;
import com.jdc.cthu.demo.repo.StateRepo;

import aj.org.objectweb.asm.Type;

@Service
@Transactional(readOnly = true)
public class LocationService {

	@Autowired
	private StateRepo stateRepo;
	
	@Autowired
	private DistrictRepo districtRepo;
	
	@Transactional
	public Stream<State> findRegionAsStream(String region){
		return stateRepo.findBy(
				Example.of(new State(region),ExampleMatcher.matching().withIgnoreCase("id","porpulation")), 
				query -> query.stream()
				); 
	}
	
	
	public List<DistrictDto> dynamicSearch(Integer stateId,String stateRegion,String districtName){
		
		var district = new District();
		var state = new State();
		district.setState(state);
		
		var matcher = ExampleMatcher.matching();
		var exclude = new ArrayList<String>(List.of("id","state.id","state.porpulation"));
		
		if(null != stateId && stateId > 0) {
			exclude.remove("state.id");
			state.setId(stateId);
		}
		
		if(StringUtils.hasLength(stateRegion)) {
			state.setRegion(stateRegion);
		}
		
		if(StringUtils.hasLength(districtName)) {
			matcher = matcher.withMatcher("name", match -> match.ignoreCase().startsWith());
			district.setName(districtName);
		}	
		
		matcher = matcher.withIgnorePaths(exclude.toArray(size -> new String[size]));
		
		return districtRepo.findBy(Example.of(district,matcher), 
								query -> query.as(DistrictDto.class).all());
		
	}
}





