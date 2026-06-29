package com.example.bookcatalog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {

    TextView paymentBookTitle, paymentAmount;
    Button btnConfirmPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        paymentBookTitle = findViewById(R.id.paymentBookTitle);
        paymentAmount = findViewById(R.id.paymentAmount);
        btnConfirmPayment = findViewById(R.id.btnConfirmPayment);

        String title = getIntent().getStringExtra("title");
        double price = getIntent().getDoubleExtra("price", 0.0);

        paymentBookTitle.setText("Book: " + title);
        paymentAmount.setText("Total to Pay: KSh " + price);

        btnConfirmPayment.setOnClickListener(v -> {
            Toast.makeText(this, "Payment Successful! Thank you for buying " + title, Toast.LENGTH_LONG).show();
            finish();
        });
    }
}