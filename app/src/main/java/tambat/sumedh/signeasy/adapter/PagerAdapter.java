package tambat.sumedh.signeasy.adapter;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;

import tambat.sumedh.signeasy.entities.Constants;
import tambat.sumedh.signeasy.fragment.AllFragment;

/**
 * @author sumedh tambat
 */
public class PagerAdapter extends FragmentStatePagerAdapter {
  int numberOfTabs;
  String emailId, password;

  public PagerAdapter(FragmentManager fm, int numberOfTabs, String emailId, String password) {
    super(fm);
    this.numberOfTabs = numberOfTabs;
    this.emailId = emailId;
    this.password = password;
  }
  @Override
  public Fragment getItem(int position) {
    Fragment fragment;
    switch (position) {
      case 0:
        fragment = new AllFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Constants.EMAIL_ID,emailId);
        bundle.putString(Constants.PASSWORD,password);
        fragment.setArguments(bundle);
        break;
      default:
        fragment = null;
    }
    return fragment;
  }

  @Override
  public int getCount() {
    return numberOfTabs;
  }
}
