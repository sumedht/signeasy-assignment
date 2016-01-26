package tambat.sumedh.signeasy.listeners;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;
import tambat.sumedh.signeasy.entities.Authentication;
import tambat.sumedh.signeasy.entities.BookFeeds;

/**
 * Retrofit interface.
 * @author sumedh tambat
 */
public interface RestInterface {

  @GET("/files")
  void getBookList(Callback<BookFeeds> callBack);

  @POST("/token")
  void getLoginAuthentication(@Body String str, Callback<Authentication> callBack);
}
