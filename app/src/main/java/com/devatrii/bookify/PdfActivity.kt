package com.devatrii.bookify

import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.devatrii.bookify.Utils.loadBannerAd
import com.devatrii.bookify.databinding.ActivityPdfBinding
import com.devatrii.bookify.fragments.PdfToolsFragment
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle

class PdfActivity : AppCompatActivity() {
    val activity = this
    lateinit var binding: ActivityPdfBinding

    lateinit var bookPdf: String
    lateinit var bookId: String
    var isNightMode = false
    var isBookMode = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPdfBinding.inflate(layoutInflater)
        this.window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(binding.root)
        supportActionBar?.hide()
        setupBasicViews()
        val dataUri = intent.data
        binding.apply {
            if (dataUri != null) {
                bookPdf = dataUri.toString()
                bookId = dataUri.lastPathSegment ?: "External_PDF"
            } else {
                bookPdf = intent.getStringExtra("book_pdf").toString()
                bookId = intent.getStringExtra("book_id").toString()
            }
            mBannerAd.loadBannerAd()
            loadPdf()
        }
    }

    fun toggleNightMode() {
        isNightMode = !isNightMode
        val currentPage = binding.pdfView.currentPage
        loadPdf(currentPage)
    }

    fun toggleBookMode() {
        isBookMode = !isBookMode
        val currentPage = binding.pdfView.currentPage
        loadPdf(currentPage)
    }

    fun loadPdf(defaultPage: Int = 0) {
        binding.pdfView.apply {
            if (bookPdf.startsWith("content://") || bookPdf.startsWith("file://") || bookPdf.contains("/")) {
                fromUri(bookPdf.toUri())
                    .swipeHorizontal(isBookMode)
                    .scrollHandle(DefaultScrollHandle(activity))
                    .enableSwipe(true)
                    .pageSnap(isBookMode)
                    .autoSpacing(true)
                    .pageFling(isBookMode)
                    .nightMode(isNightMode)
                    .defaultPage(defaultPage)
                    .load()
            } else {
                fromAsset(bookPdf)
                    .swipeHorizontal(isBookMode)
                    .scrollHandle(DefaultScrollHandle(activity))
                    .enableSwipe(true)
                    .pageSnap(isBookMode)
                    .autoSpacing(true)
                    .pageFling(isBookMode)
                    .nightMode(isNightMode)
                    .defaultPage(defaultPage)
                    .load()
            }
        }
    }

    private fun setupBasicViews() {
        binding.mToolsFab.setOnClickListener {
            val toolsBottomSheet = PdfToolsFragment()
            toolsBottomSheet.show(supportFragmentManager, toolsBottomSheet.tag)
        }
    }
}
