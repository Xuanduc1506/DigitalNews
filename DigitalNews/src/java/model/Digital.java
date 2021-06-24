/*
 * Copyright(C)2021, FPT University
 * Lab Java Web
 *
 * Record of change
 * DATE             VERSION             AUTHOR              DESCRIPTION
 * 2021-05-16         1.0               Ducnxhe141626       First Implement
 */
package model;

/**
 * This class used to contain attribute and method getter, setter of Digital
 *
 * @author Xuan Duc
 */
public class Digital {

    //Create attribute
    private int id;
    private String title;
    private String content;
    private String author;
    private String date;
    private String shortContent;
    private String image;

    /**
     * This method used to get id
     *
     * @return id <code>int</code>
     */
    public int getId() {
        return id;
    }

    /**
     * This method used to set id
     *
     * @param id <code>int</code>
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * This method used to get title
     *
     * @return title <code>String</code>
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method used to set title
     *
     * @param title <code>String</code>
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method used to get content
     *
     * @return content <code>String</code>
     */
    public String getContent() {
        return content;
    }

    /**
     * This method used to set content
     *
     * @param content <code>String</code>
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * This method used to get author
     *
     * @return author <code>String</code>
     */
    public String getAuthor() {
        return author;
    }

    /**
     * This method used to set author
     *
     * @param author <code>String</code>
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * This method used to get date
     *
     * @return date <code>String</code>
     */
    public String getDate() {
        return date;
    }

    /**
     * This method used to set date
     *
     * @param date <code>String</code>
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * This method used to get shortContent
     *
     * @return shortContent <code>String</code>
     */
    public String getShortContent() {
        return shortContent;
    }

    /**
     * This method used to set shortContent
     *
     * @param shortContent <code>String</code>
     */
    public void setShortContent(String shortContent) {
        this.shortContent = shortContent;
    }

    /**
     * This method used to get image
     *
     * @return image <code>String</code>
     */
    public String getImage() {
        return image;
    }

    /**
     * This method used to set image
     *
     * @param image <code>String</code>
     */
    public void setImage(String image) {
        this.image = image;
    }

}
