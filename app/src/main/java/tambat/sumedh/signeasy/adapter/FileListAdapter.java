package tambat.sumedh.signeasy.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import tambat.sumedh.signeasy.R;
import tambat.sumedh.signeasy.entities.Files;
import tambat.sumedh.signeasy.holder.FileListViewHolder;
import tambat.sumedh.signeasy.listeners.RecyclerViewOnItemClickListener;


/**
 * Adapter to show file list.
 *
 * @author sumedh tambat
 */
public class FileListAdapter extends RecyclerView.Adapter<FileListViewHolder> {

  private List<Files> filesList;
  private RecyclerViewOnItemClickListener viewOnItemClickListener;

  public FileListAdapter(RecyclerViewOnItemClickListener
                             viewOnItemClickListener) {
    this.viewOnItemClickListener = viewOnItemClickListener;
    this.filesList = new ArrayList<>();
  }

  @Override
  public FileListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new FileListViewHolder(createNewsView(parent), viewOnItemClickListener);
  }

  private View createNewsView(ViewGroup parent) {
    return LayoutInflater.from(parent.getContext())
        .inflate(R.layout.books_item, parent, false);
  }

  @Override
  public void onBindViewHolder(FileListViewHolder holder, final int position) {
    Files booksFeed = filesList.get(position);
    holder.title.setText(booksFeed.getName());
    holder.lastModified.setText(getLastModifiedDuration(Long.parseLong(booksFeed
        .getLast_modified_time())));
  }

  public void setBookFeed(List<Files> bookFeed){
    this.filesList.addAll(bookFeed);
  }

  @Override
  public int getItemCount() {
    return filesList.size();
  }

  public String getLastModifiedDuration(long millis)
  {
    if(millis < 0)
    {
      throw new IllegalArgumentException("Duration must be greater than zero!");
    }
    StringBuilder sb = new StringBuilder(64);
    long days = TimeUnit.MILLISECONDS.toDays(millis);
    if(days >= 1) {
      sb.append(days+" days ago");
      return sb.toString();
    } else {
      millis -= TimeUnit.DAYS.toMillis(days);
      long hours = TimeUnit.MILLISECONDS.toHours(millis);
      if(hours > 0 && hours <24) {
        sb.append(hours+" hours ago");
        return sb.toString();
      } else {
        millis -= TimeUnit.HOURS.toMillis(hours);
        long minutes = TimeUnit.MILLISECONDS.toMinutes(millis);
        if(minutes > 0 && minutes < 60) {
          sb.append(hours+" minutes ago");
          return sb.toString();
        }
      }
    }
    return(sb.toString());
  }
}
