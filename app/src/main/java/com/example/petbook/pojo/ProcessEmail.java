package com.example.petbook.pojo;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class ProcessEmail extends AsyncTask {

    private ProgressDialog statusDialog;
    private Activity sendMailActivity;

    public ProcessEmail(Activity activity) {
        sendMailActivity = activity;
    }

    protected void onPreExecute() {
        statusDialog = new ProgressDialog(sendMailActivity);
        statusDialog.setMessage("Getting ready...");
        statusDialog.setIndeterminate(false);
        statusDialog.setCancelable(false);
        statusDialog.show();
    }

    @Override
    protected Object doInBackground(Object... args) {
        try {
            Log.i("SendMailTask", "About to instantiate GMail...");
            publishProgress("Processing input....");
            Email sendMail = new Email(args[0].toString(), args[1].toString());

            publishProgress("Preparing mail message....");
            sendMail.setFrom(args[0].toString());
            sendMail.setTo((List<String>) args[2]);
            sendMail.setSubject(args[3].toString());
            sendMail.setBody(args[4].toString());
            sendMail.addAttachment(args[5].toString());

            publishProgress("Sending email....");
            sendMail.send();

            publishProgress("Email Sent.");
            Log.i("SendMailTask", "Mail Sent.");
        } catch (Exception e) {
            publishProgress(e.getMessage());
            Log.e("SendMailTask", e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void onProgressUpdate(Object... values) {
        statusDialog.setMessage(values[0].toString());

    }

    @Override
    public void onPostExecute(Object result) {
        statusDialog.dismiss();
    }

}