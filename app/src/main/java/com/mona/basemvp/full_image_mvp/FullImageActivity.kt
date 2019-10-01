package com.mona.basemvp.full_image_mvp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.mona.basemvp.R
import com.mona.basemvp.base.BaseActivity

class FullImageActivity: BaseActivity<FullImagePresenter>(), FullImageContract.FullImageIView {

    private lateinit var fullImg: ImageView
    private lateinit var saveImg: Button

    private var detailsIntent: Intent? = null
    private var fullImageBundle: Bundle? = null

    private var picturePath: String? = ""

    override val presenter: FullImagePresenter = FullImagePresenter(this, FullImageRepository())

    override fun getLayoutResourceId(): Int = R.layout.activity_full_image

    override fun onViewReady(bundle: Bundle?) {
        fullImg = findViewById(R.id.full_img)
        saveImg = findViewById(R.id.btn_save)

        detailsIntent = intent
        fullImageBundle = intent!!.getBundleExtra("data")

        if (!fullImageBundle!!.isEmpty) {
            picturePath = fullImageBundle!!.getString("picture_path")
        }

        Glide.with(this)
            .load(picturePath)
            .into(fullImg)

        saveImg.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this@FullImageActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
            } else {
                ActivityCompat.requestPermissions(this@FullImageActivity, arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE), 0)
            }
            saveImageToGallery()
        }
    }

    override fun saveImageToGallery() {
        fullImg.isDrawingCacheEnabled = true
        val b = fullImg.drawingCache
        MediaStore.Images.Media.insertImage(contentResolver, b, picturePath, "")
        Toast.makeText(this@FullImageActivity, "Saved to gallery", Toast.LENGTH_LONG).show()
    }
}