package com.mukund.service;

import com.mukund.bean.Entry;
import com.mukund.dto.PublicAPIResponseDTO;
import com.mukund.exception.EntryException;
import java.util.*;

public interface PublicAPIService {
	
	public List<PublicAPIResponseDTO> getTitleAndDescpByCategory(String category) throws EntryException;
	public Entry saveNewEntry(Entry entry) throws EntryException;
}
