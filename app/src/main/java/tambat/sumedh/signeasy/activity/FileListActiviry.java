package tambat.sumedh.signeasy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import tambat.sumedh.signeasy.R;
import tambat.sumedh.signeasy.adapter.FileListAdapter;
import tambat.sumedh.signeasy.entities.BookFeeds;
import tambat.sumedh.signeasy.entities.Constants;
import tambat.sumedh.signeasy.entities.Files;
import tambat.sumedh.signeasy.listeners.RecyclerViewOnItemClickListener;
import tambat.sumedh.signeasy.listeners.RestInterface;
import tambat.sumedh.signeasy.utils.ServiceGenerator;
/**
 * @author sumedh tambat
 */
public class FileListActiviry extends Activity implements RecyclerViewOnItemClickListener{

  private RecyclerView recyclerView;
  private FileListAdapter fileListAdapter;
  private int i = 0;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_book_list);

    Bundle bundle = getIntent().getExtras();
    String emailID = bundle.getString(Constants.EMAIL_ID);
    String password = bundle.getString(Constants.PASSWORD);

    // Initialize recycler view
    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
    recyclerView.setHasFixedSize(true);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));

    fileListAdapter = new FileListAdapter(this);
    recyclerView.setAdapter(fileListAdapter);

    RestInterface loginService =
        ServiceGenerator.createService(RestInterface.class, emailID, password);
    loginService.getBookList(new Callback<BookFeeds>() {
      @Override
      public void success(BookFeeds bookFeeds, Response response) {
        fileListAdapter.setBookFeed(getFileData(bookFeeds));
        fileListAdapter.notifyDataSetChanged();
      }
      @Override
      public void failure(RetrofitError error) {
        Toast.makeText(FileListActiviry.this, "Error ", Toast.LENGTH_SHORT).show();
      }
    });
  }

  @Override
  public void onItemClick(int position) {
  }

  private List<Files> getFileData(BookFeeds bookFeeds) {
    List<Files> files = new ArrayList<>();
    files.addAll(bookFeeds.getDraft().getFiles());
    files.addAll(bookFeeds.getOriginal().getFiles());
    files.addAll(bookFeeds.getPending().getFiles());
    files.addAll(bookFeeds.getSigned().getFiles());
    return files;
  }
}
