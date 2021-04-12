package com.nt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;

@Data
@Entity
@Table(name = "EMPLOYEES_TAB")
public class Employee {
	@Id

	/*  @GenericGenerator(name = "gen1" ,strategy ="increment")
	  @GeneratedValue(generator = "gen1")
	 
	 */
	/*@GenericGenerator(name = "gen1", strategy = "hilo", parameters = { @Parameter(name = "table", value = "HB_HILO"),
			@Parameter(name = "column", value = "HB_HI"), @Parameter(name = "max_Io", value = "5") })
	*/ 
	@GenericGenerator(name="gen1" ,strategy = "sequence" ,
	 parameters = @Parameter(name="sequence_emp", value="EmpId_SQu") )
	
	//@TableGenerator(name="gen1",valueColumnName = "empid", initialValue = 10,allocationSize = 100)
	@GeneratedValue(generator = "gen1" ,strategy = GenerationType.SEQUENCE)
	@Column(length = 10)
	private Integer empid;
	@Column(length = 30)
	private String emane;
	@Column(length = 10)
	private Double sal;
	@Column(length = 10)
	private String deptno;
	@Column(length = 10)
	private String degination;
}
