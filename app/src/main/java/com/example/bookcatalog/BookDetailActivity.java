package com.example.bookcatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class BookDetailActivity extends AppCompatActivity {

    TextView txtTitle, txtAuthor,
            txtGenre, txtDescription;
    ImageView imgBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        imgBook = findViewById(R.id.imgBook);
        txtTitle = findViewById(R.id.txtTitle);
        txtAuthor = findViewById(R.id.txtAuthor);
        txtGenre = findViewById(R.id.txtGenre);
        txtDescription = findViewById(R.id.txtDescription);

        txtTitle.setText("Title: " + getIntent().getStringExtra("title"));
        txtAuthor.setText("Author: " + getIntent().getStringExtra("author"));
        txtGenre.setText("Genre: " + getIntent().getStringExtra("genre"));
        txtDescription.setText("Description: " + getIntent().getStringExtra("description"));
        
        int imageRes = getIntent().getIntExtra("image", R.mipmap.ic_launcher);
        imgBook.setImageResource(imageRes);
    }
}