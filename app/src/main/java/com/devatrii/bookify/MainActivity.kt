package com.devatrii.bookify

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.devatrii.bookify.Adapters.BooksAdapter
import com.devatrii.bookify.Models.BooksModel
import com.devatrii.bookify.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val activity = this
    val list: ArrayList<BooksModel> = ArrayList()
    val adapter = BooksAdapter(list, activity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            mRecyclerViewHome.adapter = adapter
            list.add(BooksModel(R.drawable.book_1, "Rich Dad Poor Dad", "A book about financial independence, personal finance, and wealth creation.", "sample_book.pdf"))
            list.add(BooksModel(R.drawable.book_2, "Think and Grow Rich", "An inspirational book on personal development and self-improvement by Napoleon Hill.", "sample_book.pdf"))
            list.add(BooksModel(R.drawable.book_3, "The Alchemist", "A beautiful story about following your heart, dreams, and finding destiny.", "sample_book.pdf"))
            list.add(BooksModel(R.drawable.book_4, "Atomic Habits", "An easy and proven way to build good habits and break bad ones.", "sample_book.pdf"))
            list.add(BooksModel(R.drawable.book_5, "The Power of Habit", "Why we do what we do in life and business and how habits can be changed.", "sample_book.pdf"))
            list.add(BooksModel(R.drawable.book_6, "How to Win Friends", "A classic guide on how to influence people, make friends, and build relationships.", "sample_book.pdf"))
            list.add(BooksModel(R.drawable.book_7, "Zero to One", "Notes on start-ups, business models, and how to build the future.", "sample_book.pdf"))
            list.add(BooksModel(R.drawable.book_8, "The Intelligent Investor", "The definitive book on value investing and stock market strategies.", "sample_book.pdf"))
            list.add(BooksModel(R.drawable.book_9, "The 5 AM Club", "Own your morning, elevate your life. A revolutionary morning routine guide.", "sample_book.pdf"))
            list.add(BooksModel(R.drawable.book_10, "Deep Work", "Rules for focused success in a distracted world.", "sample_book.pdf"))
        }
    }
}
