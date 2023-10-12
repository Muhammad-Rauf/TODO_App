package com.example.todoapp.Utils

import android.app.ProgressDialog
import android.content.Context

object ProgressDialogUtil {
    private var progressDialog: ProgressDialog? = null

    fun showProgressDialog(context: Context) {
        progressDialog = ProgressDialog(context)
        progressDialog?.setMessage("Loading...")
        progressDialog?.setCancelable(false)
        progressDialog?.show()
    }

    fun dismissProgressDialog() {
        progressDialog?.dismiss()
        progressDialog = null
    }
}
