package com.hibernate.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "youtube_channel")
	private String ytChannel;
	
	@Column(name = "hobby")
	private String hobby;
	
	public InstructorDetail() {	}
	
	public InstructorDetail(String ytChannel, String hobby) {
		super();
		this.ytChannel = ytChannel;
		this.hobby = hobby;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getYtChannel() {
		return ytChannel;
	}

	public void setYtChannel(String ytChannel) {
		this.ytChannel = ytChannel;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", ytChannel=" + ytChannel + ", hobby=" + hobby + "]";
	}
	
	/***********************************************
	 * changes for Bi-directional relation
	 */
	// mapped by - name of the field in the instructor class that is to be mapped
	// cascading everything except delete operation
	@OneToOne(mappedBy = "instructorDetail", 
			cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Instructor instructor;

	public Instructor getInstructor() {
		return instructor;
	}

	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
}
