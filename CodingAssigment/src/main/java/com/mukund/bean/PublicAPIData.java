package com.mukund.bean;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PublicAPIData {
	
	private Integer count;
	private List<EntryDTO> entries;

}
