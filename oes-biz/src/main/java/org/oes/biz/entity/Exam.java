package org.oes.biz.entity;

import java.io.Serializable;

/**
 * 习题实体类
 */
public class Exam implements Serializable {

    private static final long serialVersionUID = -7995395089616187595L;

    /**
     * 问题ID
     */
    private Long questionId;
    /**
     * 所属课程ID
     */
    private Long courseId;
    /**
     * 所属章节ID
     */
    private Long courseChapterId;
    /**
     * 问题
     */
    private String question;
    /**
     * 答案
     */
    private String answer;
    /**
     * 选项
     */
    private String aOption;
    private String bOption;
    private String cOption;
    private String dOption;
    private String eOption;
    private String fOption;
    private String gOption;
    private String hOption;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public Long getCourseChapterId() {
        return courseChapterId;
    }

    public void setCourseChapterId(Long courseChapterId) {
        this.courseChapterId = courseChapterId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAOption() {
        return aOption;
    }

    public void setAOption(String aOption) {
        this.aOption = aOption;
    }

    public String getBOption() {
        return bOption;
    }

    public void setBOption(String bOption) {
        this.bOption = bOption;
    }

    public String getCOption() {
        return cOption;
    }

    public void setCOption(String cOption) {
        this.cOption = cOption;
    }

    public String getDOption() {
        return dOption;
    }

    public void setDOption(String dOption) {
        this.dOption = dOption;
    }

    public String getEOption() {
        return eOption;
    }

    public void setEOption(String eOption) {
        this.eOption = eOption;
    }

    public String getFOption() {
        return fOption;
    }

    public void setFOption(String fOption) {
        this.fOption = fOption;
    }

    public String getGOption() {
        return gOption;
    }

    public void setGOption(String gOption) {
        this.gOption = gOption;
    }

    public String getHOption() {
        return hOption;
    }

    public void setHOption(String hOption) {
        this.hOption = hOption;
    }
}
