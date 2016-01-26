package tambat.sumedh.signeasy.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;
import tambat.sumedh.signeasy.R;
import tambat.sumedh.signeasy.adapter.FileListAdapter;
import tambat.sumedh.signeasy.entities.BookFeeds;
import tambat.sumedh.signeasy.entities.Files;
import tambat.sumedh.signeasy.listeners.RecyclerViewOnItemClickListener;
import tambat.sumedh.signeasy.listeners.RestInterface;
import tambat.sumedh.signeasy.utils.ServiceGenerator;


/**
 * @author sumedh tambat
 */
public class AllFragment extends Fragment  implements RecyclerViewOnItemClickListener {

  private RecyclerView recyclerView;
  private FileListAdapter fileListAdapter;
  private String emailID, password;

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.all_tab_fragment, container, false);

    // Initialize recycler view
    recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
    recyclerView.setHasFixedSize(true);
    LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);

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
        Toast.makeText(getActivity().getApplicationContext(), "Error ", Toast.LENGTH_SHORT).show();
      }
    });

    return view;
  }

  private List<Files> getFileData(BookFeeds bookFeeds) {
    List<Files> files = new ArrayList<>();
    files.addAll(bookFeeds.getDraft().getFiles());
    files.addAll(bookFeeds.getOriginal().getFiles());
    files.addAll(bookFeeds.getPending().getFiles());
    files.addAll(bookFeeds.getSigned().getFiles());
    return files;
  }

  @Override
  public void onItemClick(int position) {

  }
}
