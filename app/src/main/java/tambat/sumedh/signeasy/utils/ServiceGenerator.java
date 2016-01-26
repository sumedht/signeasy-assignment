package tambat.sumedh.signeasy.utils;

import android.util.Base64;
import android.util.Log;

import com.squareup.okhttp.OkHttpClient;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import tambat.sumedh.signeasy.entities.Constants;

/**
 *
 * @author sumedh tambat
 */
public class ServiceGenerator {

  private static RestAdapter.Builder builder = new RestAdapter.Builder()
      .setEndpoint(Constants.API_BASE_ENDPOINT)
      .setClient(new OkClient(new OkHttpClient()));

  public static <S> S createService(Class<S> serviceClass, String username, String password) {
    if (username != null && password != null) {

      password = Base64.encodeToString(password.getBytes(), Base64.NO_WRAP);
      password = getSHA256(password);

      String credentials = username + ":" + password;

      final String basic =
          Constants.AUTH_BASIC+Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);

      builder.setRequestInterceptor(new RequestInterceptor() {
        @Override
        public void intercept(RequestFacade request) {
          request.addHeader(Constants.AUTHENTICATION_KEY, basic);
        }
      });
    }

    RestAdapter adapter = builder.build();
    return adapter.create(serviceClass);
  }

  public static String getSHA256(String password) {
    MessageDigest md = null;
    StringBuffer sb = null;
    try {
      md = MessageDigest.getInstance("SHA-256");
    } catch (NoSuchAlgorithmException exception) {
      Log.e("Exception ",exception.getMessage());
    }

    md.update(password.getBytes());

    byte byteData[] = md.digest();
    sb = new StringBuffer();
    for (int i = 0; i < byteData.length; i++) {
      sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
    }
    return sb.toString();
  }
}