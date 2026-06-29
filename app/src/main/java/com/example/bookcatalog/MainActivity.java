package com.example.bookcatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listBooks;
    ArrayList<Book> books;
    ArrayList<String> bookTitles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listBooks = findViewById(R.id.listBooks);

        books = new ArrayList<>();
        bookTitles = new ArrayList<>();

        int placeholderImage = R.drawable.author_1;

        addBook(new Book("The Last Ember", "Daniel Roth", "Historical Thriller", 
                "A former archaeologist is pulled into a deadly conspiracy when ancient secrets buried beneath Rome resurface.", 
                R.drawable.author_1, 15.99));
        
        addBook(new Book("Quantum Mirage", "Lila Chen", "Science Fiction", 
                "In a future where time travel is illegal, a rogue physicist must choose between saving the world or saving her daughter.", 
                R.drawable.author_2, 12.50));
        
        addBook(new Book("Roots & Wings", "Maria Esteban", "Literary Fiction", 
                "A moving generational story of a Cuban-American family searching for identity, belonging, and redemption.", 
                R.drawable.author_3, 10.00));
        
        addBook(new Book("The Mind Sculptor", "Dr. Evan Shaw", "Psychology / Non-Fiction", 
                "A groundbreaking look at neuroplasticity and how you can rewire your brain for success and happiness.", 
                R.drawable.author_4, 20.00));
        
        addBook(new Book("Inkbound: Chronicles of the Lost Library", "J.R. Faulkner", "Fantasy / Adventure", 
                "A young librarian discovers that ancient books can open portals to worlds—but not all stories have happy endings.", 
                R.drawable.author_5, 14.95));
        
        addBook(new Book("Startup Savage", "Nicole Vega", "Business / Entrepreneurship", 
                "A brutally honest guide to launching a tech startup in the real world, full of failures, pivots, and unexpected wins.", 
                R.drawable.author_6, 18.00));
        
        addBook(new Book("Beneath Crimson Skies", "Tomasz Novak", "Historical Fiction / WWII", 
                "The intertwined lives of resistance fighters, spies, and survivors during Nazi occupation of Warsaw.", 
                R.drawable.author_1, 13.25));
        
        addBook(new Book("The Art of Stillness", "Tara Bell", "Self-Help / Mindfulness", 
                "Learn how to find peace in a chaotic world by mastering the ancient wisdom of stillness.", 
                R.drawable.author_2, 9.99));
        
        addBook(new Book("Neon Ghosts", "Khalid Jones", "Urban Fantasy / Mystery", 
                "A private investigator with the ability to see spirits uncovers a supernatural conspiracy beneath the city's neon lights.", 
                R.drawable.author_3, 11.50));
        
        addBook(new Book("Eat Green, Live Clean", "Dr. Sanjay Patel", "Health & Wellness", 
                "A practical guide to plant-based nutrition and detox living, backed by science and easy recipes.", 
                R.drawable.author_4, 16.99));

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        bookTitles);

        listBooks.setAdapter(adapter);

        listBooks.setOnItemClickListener((parent, view, position, id) -> {
            Book selectedBook = books.get(position);
            Intent intent = new Intent(MainActivity.this, BookDetailActivity.class);
            intent.putExtra("title", selectedBook.getTitle());
            intent.putExtra("author", selectedBook.getAuthor());
            intent.putExtra("genre", selectedBook.getGenre());
            intent.putExtra("description", selectedBook.getDescription());
            intent.putExtra("image", selectedBook.getImageResource());
            intent.putExtra("price", selectedBook.getPrice());
            startActivity(intent);
        });
    }

    private void addBook(Book book) {
        books.add(book);
        bookTitles.add(book.getTitle() + " - $" + book.getPrice());
    }
}