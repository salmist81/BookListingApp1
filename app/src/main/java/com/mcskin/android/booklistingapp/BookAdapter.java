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

import com.squareup.picasso.Picasso;

import java.util.List;

public class BookAdapter extends ArrayAdapter<Book> {

    /**
     * Constructs a new {@link BookAdapter}.
     *
     * @param context of the app
     * @param books   is the list of books, which is the data source of the adapter
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

        ViewHolder holder;

        // Find the TextView with view ID title
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        // Display the title of the current book in that TextView
        titleView.setText(currentBook.getTitle());

        // Find the TextView with view ID authors
        TextView authorsView = (TextView) listItemView.findViewById(R.id.authors);
        // Display the authors of the current book in that TextView
        authorsView.setText(currentBook.getAuthors());

        // Create a new Date object from the date the book was published
        //Date dateObject = new Date (currentBook.getPublishedDate());
        holder = new ViewHolder();
        // Find the TextView with view ID date
        holder.publishedDateView = (TextView) listItemView.findViewById(R.id.publishedDate);
        holder.publishedDateView.setText(currentBook.getPublishedDate());

        // Find the TextView with view ID image
        holder.smallThumbnailView = (ImageView) listItemView.findViewById(R.id.smallThumbnail);

        // Display the image of the current book in that View
        holder.smallThumbnailView.setTag(currentBook.getSmallThumbnail());

        Picasso.with(getContext()).load(currentBook.getSmallThumbnail()).into(holder.smallThumbnailView);

        return listItemView;

    }

    static class ViewHolder {
        private TextView publishedDateView;
        private ImageView smallThumbnailView;
    }

}
