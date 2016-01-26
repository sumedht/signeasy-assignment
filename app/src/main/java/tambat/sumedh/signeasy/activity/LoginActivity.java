package tambat.sumedh.signeasy.activity;

import android.app.Activity;
import android.widget.ProgressBar;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import tambat.sumedh.signeasy.R;
import tambat.sumedh.signeasy.entities.Authentication;
import tambat.sumedh.signeasy.entities.Constants;
import tambat.sumedh.signeasy.listeners.RestInterface;
import tambat.sumedh.signeasy.utils.ServiceGenerator;

public class LoginActivity extends Activity {

  private CoordinatorLayout coordinatorLayout;
  private ProgressBar progressBar;
  private Button signIn;
  private EditText emailId, password;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    coordinatorLayout = (CoordinatorLayout) findViewById(R.id
        .coordinatorLayout);

    progressBar = (ProgressBar) findViewById(R.id.progressBar);
    progressBar.setVisibility(View.GONE);

    emailId  = (EditText) findViewById(R.id.input_email);
    password  = (EditText) findViewById(R.id.input_password);

    signIn  = (Button) findViewById(R.id.signIn);
    signIn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if(emailId.getText().length() == 0 || password.getText().length() ==0){
          showSnakeBar(Constants.VALIDATION_MESSAGE);
          return;
        }
        progressBar.setVisibility(View.VISIBLE);
        getAuthentication(emailId.getText().toString(), password.getText().toString());
      }
    });
  }

    private void getAuthentication(final String emailID, final String password) {
      RestInterface loginService =
          ServiceGenerator.createService(RestInterface.class, emailID, password);
      loginService.getLoginAuthentication("", new Callback<Authentication>() {
        @Override
        public void success(Authentication authentication, Response response) {
          progressBar.setVisibility(View.GONE);
          if (authentication.getError_code() != null &&
              authentication.getError_code().length() > 0) {
            Toast.makeText(LoginActivity.this, "" + authentication.getMessage(), Toast.LENGTH_SHORT)
                .show();
            return;
          }
          showSnakeBar(Constants.LOGIN_SUCCESS);
          Intent i = new Intent(getApplicationContext(), FileListActiviry.class);
          i.putExtra(Constants.EMAIL_ID,emailID);
          i.putExtra(Constants.PASSWORD,password);
          startActivity(i);
          finish();
        }

        @Override
        public void failure(RetrofitError error) {
          progressBar.setVisibility(View.GONE);
          showSnakeBar(Constants.AUTHENTICATION_ERROR);
        }
      });
    }

  private void showSnakeBar(String message) {
    Snackbar snackbar = Snackbar
        .make(coordinatorLayout, message, Snackbar.LENGTH_LONG);
    View sbView = snackbar.getView();
    sbView.setBackgroundColor(Color.parseColor("#1188D6"));
    TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
    textView.setTextColor(Color.WHITE);
    snackbar.show();
  }
}
