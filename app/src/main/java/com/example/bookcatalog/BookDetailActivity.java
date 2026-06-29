package com.example.bookcatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BookDetailActivity extends AppCompatActivity {

    TextView txtTitle, txtAuthor,
            txtGenre, txtDescription, txtPrice;
    ImageView imgBook;
    Button btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        imgBook = findViewById(R.id.imgBook);
        txtTitle = findViewById(R.id.txtTitle);
        txtAuthor = findViewById(R.id.txtAuthor);
        txtGenre = findViewById(R.id.txtGenre);
        txtPrice = findViewById(R.id.txtPrice);
        txtDescription = findViewById(R.id.txtDescription);
        btnBuy = findViewById(R.id.btnBuy);

        txtTitle.setText("Title: " + getIntent().getStringExtra("title"));
        txtAuthor.setText("Author: " + getIntent().getStringExtra("author"));
        txtGenre.setText("Genre: " + getIntent().getStringExtra("genre"));
        
        double price = getIntent().getDoubleExtra("price", 0.0);
        txtPrice.setText("Price: $" + price);
        
        txtDescription.setText("Description: " + getIntent().getStringExtra("description"));
        
        int imageRes = getIntent().getIntExtra("image", R.mipmap.ic_launcher);
        imgBook.setImageResource(imageRes);

        btnBuy.setOnClickListener(v -> {
            Toast.makeText(this, "Proceeding to payment for: " + getIntent().getStringExtra("title"), Toast.LENGTH_SHORT).show();
        });
    }
}