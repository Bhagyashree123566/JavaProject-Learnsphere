package com.learnSphere.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
//ind c is jp ent and m to dbt
@Entity
public class Comment {
	@Id
	int commentId;
	String comment;
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}
	//used  t s info abt comm mde b user
	public Comment(int commentId, String comment) {
		super();
		this.commentId = commentId;
		this.comment = comment;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Override
	public String toString() {
		return "Comment [commentId=" + commentId + ", comment=" + comment + "]";
	}
	
}
