package com.gemmano.dr.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Sync {

	@Id
    private Long id;
	
	private String url;
}
