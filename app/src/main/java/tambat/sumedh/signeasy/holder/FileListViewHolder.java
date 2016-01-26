package tambat.sumedh.signeasy.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import tambat.sumedh.signeasy.R;
import tambat.sumedh.signeasy.listeners.RecyclerViewOnItemClickListener;

/**
 * Holder for file list adapter.
 *
 * @author sumedh tambat
 */

public class FileListViewHolder extends RecyclerView.ViewHolder {

  public ImageView image;
  public TextView title;
  public TextView lastModified;
  private RecyclerViewOnItemClickListener viewOnItemClickListene;

  public FileListViewHolder(View view, final RecyclerViewOnItemClickListener
      viewOnItemClickListene) {
    super(view);

    this.viewOnItemClickListene = viewOnItemClickListene;
    this.image = (ImageView) view.findViewById(R.id.image);
    this.title = (TextView) view.findViewById(R.id.title);
    this.lastModified = (TextView) view.findViewById(R.id.lastModified);

    view.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        viewOnItemClickListene.onItemClick(getPosition());
      }
    });
  }
}
