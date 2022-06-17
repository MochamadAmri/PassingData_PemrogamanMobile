package com.example.widget

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.widget.databinding.ActivityWidgetBinding
import com.google.android.material.snackbar.Snackbar

// Membuat Variable Binding
private lateinit var binding: ActivityWidgetBinding
class Widget : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Inisialisasi binding
        binding = ActivityWidgetBinding.inflate(layoutInflater)
        // Memanggil layout dengan menggunakan binding.root
        setContentView(binding.root)

        // Button Toast
        binding.btnToast.setOnClickListener {
            Toast.makeText(this, "ini adalah contoh Toast", Toast.LENGTH_SHORT).show()
        }

        //Button Snackbar
        binding.btnSnackbar.setOnClickListener {
            Snackbar.make(it, "ini adalah snack", Snackbar.LENGTH_SHORT).show()
        }

        // button alert
        binding.btnAlert.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Massage")
                setMessage("ini adalah Alert")

                setPositiveButton("Ok"){dialog, _->
                    Toast.makeText(applicationContext, "Anda klik ok", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()

                }

                setNegativeButton("Back") { dialog, _ ->
                    Toast.makeText(applicationContext, "Anda klik Back", Toast.LENGTH_SHORT).show()
                    dialog.dismiss()

                }
            }.show()
        }

        // Button Custom Dialog
        binding.btnCustomDialog.setOnClickListener {
            Dialog(this).apply {
                requestWindowFeature(Window.FEATURE_NO_TITLE)
                setCancelable(false)
                setContentView(R.layout.custom_dialog)

                val btncancel = this.findViewById<Button>(R.id.btnCancel)
                val btnContinue = this.findViewById<Button>(R.id.btnContinue)

                btncancel.setOnClickListener {
                    Toast.makeText(applicationContext, "Anda klik cancel",Toast.LENGTH_SHORT).show()
                    this.dismiss()
                }
            }.show()
        }


    }
}