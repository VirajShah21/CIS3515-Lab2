package edu.temple.signupform

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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
                if (fullname.text.isEmpty())
                    fullname.error = "Cannot be blank"

                if (email.text.isEmpty()) email.error = "Cannot be blank";

                if (password.text.isEmpty()) password.error = "Cannot be blank";

                if (passwordConf.text.isEmpty()) passwordConf.error = "Cannot be blank";
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

                password.error = "Passwords do not match"
                passwordConf.error = "Passwords do not match"
            } else {
                Toast.makeText(getApplicationContext(), fullname.text, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
