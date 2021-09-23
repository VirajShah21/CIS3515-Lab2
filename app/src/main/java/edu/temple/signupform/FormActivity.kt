package edu.temple.signupform

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)
        val saveBtn = findViewById<Button>(R.id.saveBtn);
        saveBtn.setOnClickListener {
            val fullname = findViewById<EditText>(R.id.fullname);
            val email = findViewById<EditText>(R.id.email);
            val password = findViewById<EditText>(R.id.password);
            val passwordConf = findViewById<EditText>(R.id.passwordConf);

            if (fullname.text.isEmpty() || email.text.isEmpty() || password.text.isEmpty() || passwordConf.text.isEmpty()) {
                // build alert dialog
                val dialogBuilder = AlertDialog.Builder(this)

                // set message of alert dialog
                dialogBuilder.setMessage("All fields must be filled!")
                    // if the dialog is cancelable
                    .setCancelable(true)
                    // negative button text and action
                    .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                        dialog.cancel()
                    })

                // create dialog box
                val alert = dialogBuilder.create()
                // set title for alert dialog box
                alert.setTitle("AlertDialogExample")
                // show alert dialog
                alert.show()
            } else if (password.text.equals(passwordConf.text)) {
                // build alert dialog
                val dialogBuilder = AlertDialog.Builder(this)

                // set message of alert dialog
                dialogBuilder.setMessage("Passwords do not match!")
                    // if the dialog is cancelable
                    .setCancelable(true)
                    // negative button text and action
                    .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                        dialog.cancel()
                    })

                // create dialog box
                val alert = dialogBuilder.create()
                // set title for alert dialog box
                alert.setTitle("AlertDialogExample")
                // show alert dialog
                alert.show()
            } else {
                // build alert dialog
                val dialogBuilder = AlertDialog.Builder(this)

                // set message of alert dialog
                dialogBuilder.setMessage("Hello " + fullname.text)
                    // if the dialog is cancelable
                    .setCancelable(true)
                    // negative button text and action
                    .setNegativeButton("Cancel", DialogInterface.OnClickListener { dialog, id ->
                        dialog.cancel()
                    })

                // create dialog box
                val alert = dialogBuilder.create()
                // set title for alert dialog box
                alert.setTitle("AlertDialogExample")
                // show alert dialog
                alert.show()
            }
        }
    }
}
