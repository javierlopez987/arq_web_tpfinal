package edu.tudai.agenda.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@PrimaryKeyJoinColumn(name = "Plan_id_plan")
@Data
@EqualsAndHashCode(callSuper = false)
public class Compuesto extends Plan {
	@Column
	private Plan plan1;
	@Column
	private Plan plan2;

}
