package com.mcskin.android.booklistingapp;

/**
 * Created by McSkin on 17/07/2017.
 */

public class Book {

    /**
     * Title of the book
     */
    private String mTitle;

    /**
     * Authors of the book
     */
    private String mAuthors;

    /**
     * Published date of the book
     */
    private String mPublishedDate;

    /**
     * Website URL of the book
     */
    private String mUrl;

    /**
     * Image Website URL of the book
     */
    private String mSmallThumbnail;


    /**
     * Constructs a new {@link Book} object.
     *
     * @param title          is the title of the book
     * @param authors        is/are the author(s) the book
     * @param publishedDate  is the date the book was published
     * @param url            is the website URL to find more details about the book
     * @param smallThumbnail is the image of the book
     */
    public Book(String title, String authors, String publishedDate, String url, String smallThumbnail) {
        mTitle = title;
        mAuthors = authors;
        mPublishedDate = publishedDate;
        mUrl = url;
        mSmallThumbnail = smallThumbnail;
    }

    /**
     * Returns the title of the book.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Returns the authors of the book.
     */
    public String getAuthors() {
        return mAuthors;
    }

    /**
     * Returns the date the book was published.
     */
    public String getPublishedDate() {
        return mPublishedDate;
    }

    /**
     * Returns the website URL to find more information about the book.
     */
    public String getUrl() {
        return mUrl;
    }

    /**
     * Returns the image from the book url website.
     */
    public String getSmallThumbnail() {
        return mSmallThumbnail;
    }
}
