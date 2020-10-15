package com.mughitszufar.nvvmnewsapp.repository

import com.mughitszufar.nvvmnewsapp.database.ArticleDatabase
import com.mughitszufar.nvvmnewsapp.model.Article
import com.mughitszufar.nvvmnewsapp.network.RetrofitInstance

class NewsRepository (val db: ArticleDatabase) {
//get semua data untuk ditampilkan di fragment breaking news
    suspend fun getBreakingNews(countryCode : String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchNews(searchQuery, pageNumber)


    //mebuat database baru di local database
    suspend fun upSert(article: Article) = db.getArticleDao().upsert(article)

    //untuk get data semua data yg sudah di bookmark
    fun getSavedNews() = db.getArticleDao().getAllArticles()

    //delete database local
    suspend fun deleteArticle (article: Article) = db.getArticleDao().deleteArticle(article)

}