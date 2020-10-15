package com.mughitszufar.nvvmnewsapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.mughitszufar.nvvmnewsapp.R
import com.mughitszufar.nvvmnewsapp.ui.MainActivity
import com.mughitszufar.nvvmnewsapp.ui.NewsViewModel
import kotlinx.android.synthetic.main.fragment_artickle.*


class ArtickleFragment() : Fragment(R.layout.fragment_artickle) {

    lateinit var viewModel: NewsViewModel
    val args: ArtickleFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        val article = args.article
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }

        fab.setOnClickListener {
            viewModel.saveArticle(article)
            Snackbar.make(view, "Artikel Berhasil Disave", Snackbar.LENGTH_SHORT).show()
        }
    }
}