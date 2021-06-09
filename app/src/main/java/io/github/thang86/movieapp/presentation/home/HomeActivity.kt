package io.github.thang86.movieapp.presentation.home

import android.app.Activity
import android.content.Intent
import io.github.thang86.movieapp.R
import io.github.thang86.movieapp.base.view.BaseActivity
import io.github.thang86.movieapp.databinding.ActivityHomeBinding

class HomeActivity : BaseActivity<ActivityHomeBinding, HomeViewModel>() {
    override val layoutResourceId: Int = R.layout.activity_home
    override val classTypeOfViewModel: Class<HomeViewModel> = HomeViewModel::class.java


    companion object {
        fun start(activity: Activity) {
            activity.startActivity(Intent(activity, HomeActivity::class.java))
        }
    }
}