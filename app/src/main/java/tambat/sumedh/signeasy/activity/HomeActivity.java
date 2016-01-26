package tambat.sumedh.signeasy.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.viewpagerindicator.CirclePageIndicator;

import tambat.sumedh.signeasy.R;
import tambat.sumedh.signeasy.adapter.CustomPagerAdapter;

/**
 * @author sumedh tambat
 */
public class HomeActivity extends Activity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_home);

    ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
    viewPager.setAdapter(new CustomPagerAdapter(this));

    CirclePageIndicator mIndicator = (CirclePageIndicator)findViewById(R.id.circleIndicator);
    mIndicator.setPageColor(Color.BLACK);
    mIndicator.setStrokeWidth(0.0f);
    mIndicator.setViewPager(viewPager);

    Button login = (Button)findViewById(R.id.login);
    login.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
      }
    });
  }
}
