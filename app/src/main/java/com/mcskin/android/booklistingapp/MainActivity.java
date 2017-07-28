package com.mcskin.android.booklistingapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String LOG_TAG = MainActivity.class.getName();

    //final Context mContext = this;
    private String mTitle;
    private String mAuthor;

    // UI Components
    private TextView mSearchInfo;
    private EditText mEditBookTitle;
    private EditText mEditBookAuthor;
    private Button mButtonSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /** Initialize UI components */
        mSearchInfo = (TextView) findViewById(R.id.search_info);
        mEditBookTitle = (EditText) findViewById(R.id.edit_book_title);
        mEditBookAuthor = (EditText) findViewById(R.id.edit_book_author);
        mButtonSearch = (Button) findViewById(R.id.button_search_books);


        /** Set OnClickListener on button view */
        mButtonSearch.setOnClickListener(this);

        /** Add TextChangeListener to EditText fields */
        mEditBookTitle.addTextChangedListener(new QuizTextWatcher(mEditBookTitle));
        mEditBookAuthor.addTextChangedListener(new QuizTextWatcher(mEditBookAuthor));

    }


    /**
     * Invokes methods for individual call to action buttons
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_search_books:
                showSearchResults();
                break;
        }
    }

    /**
     * This method launches BookActivity after validating Book Title and Author inputs
     */
    public void showSearchResults() {
        if (validateInput()) {
            Intent intent = new Intent(this, BookActivity.class);

            // Replace spaces with + sign for URL to be used to fetch data
            intent.putExtra("bookTitle", mTitle.replaceAll(" ", "+"));
            intent.putExtra("bookAuthor", mAuthor.replaceAll(" ", "+"));
            startActivity(intent);
        }
    }

    /**
     * This method checks if an input string contains number or invalid characters.
     */
    public boolean validateInput() {
        mTitle = mEditBookTitle.getText().toString().trim();
        mAuthor = mEditBookAuthor.getText().toString().trim();

        /** Check if Book Title is entered; else set error */
        if (!Utils.checkEmptyString(mTitle)) {
            mEditBookTitle.setError(getString(R.string.empty_string_error));
            return false;
        }

        /** Check if Book Author is valid if entered; it is an optional field */
        if (Utils.checkEmptyString(mAuthor)) {
            // Book Author not empty so check if input is valid
            if (!Utils.checkValidString(mAuthor)) {
                mEditBookAuthor.setError(getString(R.string.invalid_string_error));
                return false;
            }
        }

        return true;
    }

    /**
     * Extends TextWatcher class for EditText fields
     */
    private class QuizTextWatcher implements TextWatcher {
        private View view;

        private QuizTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
        }
    }
}
