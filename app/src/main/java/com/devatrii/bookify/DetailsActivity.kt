package com.devatrii.bookify

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devatrii.bookify.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    val activity = this
    lateinit var binding: ActivityDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bookTitle = intent.getStringExtra("book_title").toString()
        val bookDesc = intent.getStringExtra("book_desc").toString()
        val bookPDF = intent.getStringExtra("book_pdf").toString()
        val bookImage = intent.getIntExtra("book_image", 0)

        binding.apply {
            mBookTitle.text = bookTitle
            mBookDesc.text = bookDesc
            mBookImage.setImageResource(bookImage)

            mPlayAudio.setOnClickListener {
                android.widget.Toast.makeText(activity, "Audio file not available", android.widget.Toast.LENGTH_SHORT).show()
            }

            mReadBookBtn.setOnClickListener {
                Intent().apply {
                    putExtra("book_pdf", bookPDF)
                    putExtra("book_id", "${bookTitle}_local")
                    setClass(activity, PdfActivity::class.java)
                    startActivity(this)
                }
            }
        }
    }
}