package tambat.sumedh.signeasy.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import tambat.sumedh.signeasy.R;
import tambat.sumedh.signeasy.adapter.PagerAdapter;
import tambat.sumedh.signeasy.entities.Constants;
import tambat.sumedh.signeasy.listeners.RecyclerViewOnItemClickListener;

/**
 * @author sumedh tambat
 */
public class FileListActiviry extends AppCompatActivity implements RecyclerViewOnItemClickListener{


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_book_list);

    Bundle bundle = getIntent().getExtras();
    String emailID = bundle.getString(Constants.EMAIL_ID);
    String password = bundle.getString(Constants.PASSWORD);

    TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
    tabLayout.addTab(tabLayout.newTab().setText("ALL"));
    tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

    final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
    final PagerAdapter adapter = new PagerAdapter
        (getSupportFragmentManager(), tabLayout.getTabCount(), emailID, password);
    viewPager.setAdapter(adapter);
    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
      @Override
      public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
      }

      @Override
      public void onTabUnselected(TabLayout.Tab tab) {

      }

      @Override
      public void onTabReselected(TabLayout.Tab tab) {

      }
    });
  }

  @Override
  public void onItemClick(int position) {
  }
}
