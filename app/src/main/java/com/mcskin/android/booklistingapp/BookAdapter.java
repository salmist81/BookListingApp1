package com.mcskin.android.booklistingapp;

/**
 * Created by McSkin on 17/07/2017.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

/**
 * Constructs a new {@link BookAdapter}.
 *
 * @param context of the app
 * @param books is the list of books, which is the data source of the adapter
 */
public BookAdapter(Context context, List<Book> books) {
    super(context, 0, books);
}
/**
 * Returns a list item view that displays information about the book at the given position
 * in the list of books.
 */
@Override
public View getView(int position, View convertView, ViewGroup parent) {
    // Check if there is an existing list item view (called convertView) that we can reuse,
    // otherwise, if convertView is null, then inflate a new list item layout.
    View listItemView = convertView;
    if (listItemView == null) {
        listItemView = LayoutInflater.from(getContext()).inflate(
                R.layout.book_list_item, parent, false);
    }

    // Find the book at the given position in the list of books
    Book currentBook = getItem(position);

    // Find the TextView with view ID title
    TextView titleView = (TextView) listItemView.findViewById(R.id.title);
    // Display the location of the current earthquake in that TextView
    titleView.setText(currentBook.getTitle());

    // Find the TextView with view ID authors
    TextView authorsView = (TextView) listItemView.findViewById(R.id.authors);
    // Display the authors of the current book in that TextView
    authorsView.setText(currentBook.getAuthors());

    // Create a new Date object from the date the book was published
    Date dateObject = new Date(currentBook.getPublishedDate());

    // Find the TextView with view ID date
    TextView publishedDateView = (TextView) listItemView.findViewById(R.id.publishedDate);
    // Format the date string (i.e. "2017-05-09")
    String formattedDate = formatDate(dateObject);
    // Display the date of the current earthquake in that TextView
    publishedDateView.setText(formattedDate);

    // Find the TextView with view ID image
    ImageView smallThumbnailView = (ImageView) listItemView.findViewById(R.id.smallThumbnail);
    // Display the image of the current book in that View
    smallThumbnailView.setTag(currentBook.getSmallThumbnail());

    return listItemView;

}
    /**
     * Return the formatted date string (i.e. "09 Mar, 2017") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd LLL, yyyy");
        return dateFormat.format(dateObject);
    }
}
