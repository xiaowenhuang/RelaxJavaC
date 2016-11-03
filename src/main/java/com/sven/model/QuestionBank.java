package com.sven.model;

import java.util.Date;

/**
 * 利用实体工具类(GenEntityTool)生成
 * sven on 2016.11.3
 */
public class QuestionBank {
	private int id;
	private String question;
	private String result;
	private Date createTime;
	private String creator;
	private String difficulty;
	private int correctAnswerTimes;
	private int wrongAnswerTimes;
	private String answerTime;

	public void setId(int id){
		this.id=id;
	}
	public int getId(){
		return id;
	}
	public void setQuestion(String question){
		this.question=question;
	}
	public String getQuestion(){
		return question;
	}
	public void setResult(String result){
		this.result=result;
	}
	public String getResult(){
		return result;
	}
	public void setCreateTime(Date createTime){
		this.createTime=createTime;
	}
	public Date getCreateTime(){
		return createTime;
	}
	public void setCreator(String creator){
		this.creator=creator;
	}
	public String getCreator(){
		return creator;
	}
	public void setDifficulty(String difficulty){
		this.difficulty=difficulty;
	}
	public String getDifficulty(){
		return difficulty;
	}
	public void setCorrectAnswerTimes(int correctAnswerTimes){
		this.correctAnswerTimes=correctAnswerTimes;
	}
	public int getCorrectAnswerTimes(){
		return correctAnswerTimes;
	}
	public void setWrongAnswerTimes(int wrongAnswerTimes){
		this.wrongAnswerTimes=wrongAnswerTimes;
	}
	public int getWrongAnswerTimes(){
		return wrongAnswerTimes;
	}
	public void setAnswerTime(String answerTime){
		this.answerTime=answerTime;
	}
	public String getAnswerTime(){
		return answerTime;
	}
}

