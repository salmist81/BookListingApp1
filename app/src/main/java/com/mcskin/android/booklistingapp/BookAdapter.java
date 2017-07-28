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

import static com.mcskin.android.booklistingapp.R.id.authors;

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

        ViewHolder holder;
        String image;

        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.book_list_item, parent, false);

            holder = new ViewHolder();
            holder.title = (TextView) listItemView.findViewById(R.id.title);
            holder.authors = (TextView) listItemView.findViewById(authors);
            holder.publishedDate = (TextView) listItemView.findViewById(R.id.publishedDate);
            holder.smallThumbnail = (ImageView) listItemView.findViewById(R.id.smallThumbnail);

            listItemView.setTag(holder);

        } else {
            // view already exists, get the holder instance from the view
            holder = (ViewHolder) listItemView.getTag();
        }

        // Find the book at the given position in the list of books
        Book currentBook = getItem(position);


        // Set the title of the current book in that TextView
        holder.title.setText(currentBook.getTitle());

        // Set the authors of the current book in that TextView
        holder.authors.setText(currentBook.getAuthors());

        // Set the date object from the date the book was published
        holder.publishedDate.setText(currentBook.getPublishedDate());


        // Set smallThumbnail of image if  available
        image = currentBook.getSmallThumbnail();
        if (image != null && image.length() > 0) {
            Picasso.with(getContext()).load(currentBook.getSmallThumbnail()).into(holder.smallThumbnail);
        } else {
            //Set image from drawable
            Picasso.with(getContext()).load(R.drawable.no_image).into(holder.smallThumbnail);
        }

        return listItemView;

    }

    public static class ViewHolder {
        private TextView title;
        private TextView authors;
        private TextView publishedDate;
        private ImageView smallThumbnail;

    }

}
