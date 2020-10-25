package com.example.demo.model;
import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

	@Entity
	@Table(name = "files")
	public class DBFile {
	    @Id
	    @GeneratedValue(generator = "uuid")
	    @GenericGenerator(name = "uuid", strategy = "uuid2")
	    private String id;

	    private String fileName;

	    private String fileType;
	    	
	    @Lob
	    private transient byte[] data;
	    
	    @ManyToOne(cascade = CascadeType.PERSIST,fetch = FetchType.LAZY)
		@JoinColumn(name = "question_id")
		@JsonBackReference
		private Questions questions;
	    

	    public DBFile() {

	    }

	    public DBFile(String fileName, String fileType, byte[] data) {
	        this.fileName = fileName;
	        this.fileType = fileType;
	        this.data = data;
	    }

	    public String getId() {
	        return id;
	    }

	    public void setId(String id) {
	        this.id = id;
	    }

	    public String getFileName() {
	        return fileName;
	    }

	    public void setFileName(String fileName) {
	        this.fileName = fileName;
	    }

	    public String getFileType() {
	        return fileType;
	    }

	    public void setFileType(String fileType) {
	        this.fileType = fileType;
	    }

	    public byte[] getData() {
	        return data;
	    }

	    public void setData(byte[] data) {
	        this.data = data;
	    }

		public Questions getQuestions() {
			return questions;
		}

		public void setQuestions(Questions questions) {
			this.questions = questions;
		}
	    
	    
	    
}


