package com.mukund.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.mukund.bean.Entry;
import com.mukund.bean.EntryDTO;
import com.mukund.bean.PublicAPIData;
import com.mukund.dto.PublicAPIResponseDTO;
import com.mukund.exception.EntryException;
import com.mukund.repository.EntryRepo;

@Service
public class PublicAPIServeiceImpl implements PublicAPIService {

	@Autowired
	RestTemplate restTemplet;
	
	@Autowired
	private EntryRepo eRepo;

	@Override
	public List<PublicAPIResponseDTO> getTitleAndDescpByCategory(String category) throws EntryException {

		PublicAPIData data = restTemplet.getForObject("https://api.publicapis.org/entries", PublicAPIData.class);

		List<EntryDTO> entries = data.getEntries();

		String category0 = category.split(" ")[0].toLowerCase();

		List<PublicAPIResponseDTO> res = entries.stream()
				.filter(en -> en.getCategory().split(" ")[0].toLowerCase().equals(category0))
				.map(entry -> new PublicAPIResponseDTO(entry.getApi(), entry.getDescription())).toList();

		if(res.size() != 0)
			return res;
		else
			throw new EntryException("No result found..!");
	}

	@Override
	public Entry saveNewEntry(Entry entry) throws EntryException {
		
		if(entry != null)
		{
			Entry savedEntry = eRepo.save(entry);
			return savedEntry;
		}
		else throw new EntryException("Invalid Credentials..!");
	}

}
