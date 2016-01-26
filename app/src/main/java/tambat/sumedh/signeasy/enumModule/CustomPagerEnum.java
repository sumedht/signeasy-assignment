package tambat.sumedh.signeasy.enumModule;

import tambat.sumedh.signeasy.R;

/**
 * @author sumedh tambat
 */
public enum CustomPagerEnum {

  JELLY_BEAN(R.string.jellyBean, R.layout.jelly_bean),
  LOLLIPOP(R.string.lollipop, R.layout.lollipop),
  KITKAT(R.string.kitkat, R.layout.kitkat),
  MUFFIN(R.string.muffin, R.layout.muffin);

  private int mTitleResId;
  private int mLayoutResId;

  CustomPagerEnum(int titleResId, int layoutResId) {
    mTitleResId = titleResId;
    mLayoutResId = layoutResId;
  }

  public int getTitleResId() {
    return mTitleResId;
  }

  public int getLayoutResId() {
    return mLayoutResId;
  }
}
